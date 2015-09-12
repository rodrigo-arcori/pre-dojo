package com.predojo.app.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 	Class responsible for process some logic with data.
 * </pre>
 * @author rodrigo.arcori - https://github.com/rodrigo-arcori
 *
 */
public final class DataMatch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 105911780328278892L;

	private final static String WORLD_OUT = "<WORLD>";

	Map< String, MatchResponse > index = new HashMap< String, MatchResponse >();

	public void counter( GameMatch gameMatch ) {

		Player player = gameMatch.getPlayer();

		if ( !player.getName().equals( WORLD_OUT ) )
			computeWinner( gameMatch.getIdMatch(), player );

		computeLost( gameMatch.getIdMatch(), player.getLost() );
	}

	public List< MatchResponse > getResponse() {

		List< MatchResponse > listResponse = new LinkedList< MatchResponse >();
		
		for( String playName : index.keySet() ) {
			
			MatchResponse matchResponse = index.get( playName );
			
			listResponse.add( matchResponse );
		}
		
		Collections.sort( listResponse, MatchResponse.MatchResponseKillerComparator );
		
		return listResponse;
	}

	private void computeWinner( Integer idMatch, Player player ) {

		if ( index.containsKey( player.getName() ) ) {

			index.get( player.getName() ).incrementKiller();

		} else {

			MatchResponse matchResponse = new MatchResponse( idMatch, player.getName() );

			matchResponse.incrementKiller();

			index.put( matchResponse.getPlayerName(), matchResponse );
		}

	}

	private void computeLost( Integer idMatch, Player player ) {

		if ( index.containsKey( player.getName() ) ) {

			index.get( player.getName() ).incrementDie();

		} else {

			MatchResponse matchResponse = new MatchResponse( idMatch, player.getName() );

			matchResponse.incrementDie();

			index.put( matchResponse.getPlayerName(), matchResponse );
		}

	}

	@Override
	public String toString() {
		
		return String.format( "DataMatch{ indexTree:%s, lost:%s }", index);
		
	}

}
