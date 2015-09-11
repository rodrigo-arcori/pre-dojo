package com.predojo.app.service.log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;

import com.predojo.app.entity.GameMatch;
import com.predojo.app.entity.MatchResponse;
import com.predojo.app.service.data.DataProcessesService;
import com.predojo.app.service.data.IDataProcesses;


/*
 * (non-Javadoc)
 * @see com.predojo.app.service.log.BaseLogService
 * @see com.predojo.app.service.log.IGameLogService
 */
public class GameLogService extends BaseLogService implements IGameLogService {
	
	
	/*
	 * (non-Javadoc)
	 * @see com.predojo.app.service.log.IGameLogService#load()
	 */
	@Override
	public List<MatchResponse> load() throws InterruptedException, ExecutionException {
		
		final PriorityBlockingQueue<GameMatch> queue = read();
		
		final int numberOfCores = Runtime.getRuntime().availableProcessors();
		
		final double blockingCoefficient = 0.9;
		
		final int poolSize = (int) ( numberOfCores / ( 1 - blockingCoefficient ) );
		
		final List<Callable<GameMatch>> partitions = new ArrayList<Callable<GameMatch>>();
		
		while ( !queue.isEmpty() ) {
			
			final GameMatch gameMatch = queue.poll();
			
			partitions.add( new Callable<GameMatch>() {
				
				public GameMatch call() throws Exception {
					
					return gameMatch;
				}
				
			} );
			
		}
			
		final ExecutorService executorPool = Executors.newFixedThreadPool(poolSize);
		
		final List<Future<GameMatch>> gameMatches = executorPool.invokeAll(partitions);

		IDataProcesses dataProcesses = new DataProcessesService();
		
		for( final Future<GameMatch> futures : gameMatches)
			dataProcesses.execute( futures.get() );
		
		executorPool.shutdown();
		
		return dataProcesses.getResponse(); 
			
	}

}
