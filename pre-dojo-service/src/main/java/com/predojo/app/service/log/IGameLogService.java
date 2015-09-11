package com.predojo.app.service.log;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.predojo.app.entity.MatchResponse;

/**
 * Entry Interface responsible for load and process all data. 
 * @author rodrigo.arcori - https://github.com/rodrigo-arcori
 *
 */
public interface IGameLogService {
	
	/**
	 * <pre>
	 * Method responsible for load and process data.
	 * To avoid possible issue like IO-Blocking, the process is executed in several tasks management from ExecutionServices.
	 * Tasks are executed when there is data available in the queue.
	 * The threads from the pool was created thinking about blocking coefficient.
	 * </pre>
	 * @return a list with all match game as response
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	List<MatchResponse> load() throws InterruptedException, ExecutionException;

}
