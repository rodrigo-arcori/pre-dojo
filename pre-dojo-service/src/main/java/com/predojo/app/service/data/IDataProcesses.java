package com.predojo.app.service.data;

import java.util.List;

import com.predojo.app.entity.GameMatch;
import com.predojo.app.entity.MatchResponse;

/**
 * <pre>
 * 	Interface responsible for process data log for the game.
 * </pre>
 * @author rodrigo.arcori - https://github.com/rodrigo-arcori
 *
 */
public interface IDataProcesses {

	/**
	 * Execute and process an game match containing a row state match 
	 * @param gameMatch object
	 */
	void execute( GameMatch gameMatch );
	
	/**
	 * Return an match response after any game match processed.
	 * @return {@link MatchResponse} object
	 */
	List< MatchResponse > getResponse();
}
