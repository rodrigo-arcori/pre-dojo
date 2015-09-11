package org.com.predojo.app.client;

import com.predojo.app.service.log.GameLogService;
import com.predojo.app.service.log.IGameLogService;
import com.predojo.app.service.result.IResultWriter;
import com.predojo.app.service.result.ScreenResultWriter;

/**
 * <pre>
 * 	PreDojoAppClient main class.
 * </pre>
 * @author rodrigo.arcori - https://github.com/rodrigo-arcori
 *
 */
public class PreDojoAppClient 
{
    public static void main( String[] args )
    {
    	
    	try {
    		
    		IGameLogService fileLogService = new GameLogService();
    		
    		IResultWriter resultWriter = new ScreenResultWriter( fileLogService.load() );
    		
    		resultWriter.showResult();
    		
		} catch ( Exception exception ) {
			
			System.err.println( exception.getMessage() );
			
		}
    	
    		
    }
}
