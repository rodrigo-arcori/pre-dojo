package com.predojo.app.service.log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.PriorityBlockingQueue;

import com.predojo.app.entity.GameMatch;
import com.predojo.app.entity.Player;
import com.predojo.app.entity.Weapon;

/**
 * Abstract Base class responsible for load and read an game log file.
 * @author rodrigo.arcori - https://github.com/rodrigo-arcori
 *
 */
public abstract class BaseLogService {
	
	final static String NEW = "new";
	
	final static String MATCH = "match";
	
	final static int INDEX_WINNER = 3;
	
	final static int INDEX_LOST = 5;
	
	final static int INDEX_WEAPON = 7;

	/**
	 * Load a game file an read each entry.
	 * @return a queue object maintaining ordering elements.
	 */
	protected PriorityBlockingQueue<GameMatch> read() {
		
		final PriorityBlockingQueue<GameMatch> queue = new PriorityBlockingQueue<GameMatch>();
		
		BufferedReader reader = null;
		
		try {
			
			ClassLoader classLoader = getClass().getClassLoader();
			
			reader = new BufferedReader( new FileReader(classLoader.getResource("gamelog.txt").getFile() ));
			
			String logEntry = null;
			
			Integer idMatch = -1;
			
			while ( ( logEntry = reader.readLine() ) != null ) {
				
				String[] content = logEntry.split(" ");
				
				if( content[ INDEX_WINNER ].toLowerCase().equals( NEW ) && content[4].toLowerCase().equals( MATCH ) ) {
					
					idMatch = Integer.valueOf(content[5]);
					
					continue;
					
				} else if( idMatch != -1 && content[ INDEX_WINNER ].toLowerCase().equals( MATCH ) ) {
					
					idMatch = -1;
					
					continue;
				}
				
				String winner = content[ INDEX_WINNER ];
				
				String lost = content[ INDEX_LOST ];
				
				String weapon = content[ INDEX_WEAPON ];
				
				Player playerWinner = new Player( winner );
				
				playerWinner.setWeapon( Weapon.getEnum( weapon ) );
				
				playerWinner.setLost( new Player(lost) );
				
				queue.add( new GameMatch( idMatch, playerWinner ) );
				
			}

			
		} catch (Exception e) {
			
			throw new RuntimeException( "Could not read the game log file." );
			
		} finally {
			
			try {
				
				if( reader != null) reader.close();
				
			} catch (IOException e) {
				
				throw new RuntimeException( "Could not close the buffered reader." );
				
			}
		}
		
		return queue;
		
	}
}
