package com.predojo.app.entity;

import java.io.Serializable;

/**
 * <pre>
 * 	Class containing a game match state.
 * </pre>
 * @author rodrigo.arcori - https://github.com/rodrigo-arcori
 *
 */
public final class GameMatch implements Comparable< GameMatch >, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6624048686423313878L;

	Integer idMatch = -1;
	
	Player player;
	
	public GameMatch( Integer idMatch, Player player ) {
		
		this.idMatch = idMatch;
		
		this.player = player;
	}
	
	@Override
	public int compareTo( GameMatch gameMatch ) {
		
		return Integer.compare( this.idMatch, gameMatch.idMatch );
		
	}

	public Integer getIdMatch() {
		
		return idMatch;
		
	}

	public Player getPlayer() {
		
		return player;
		
	}

	@Override
	public String toString() {
		
		return String.format("GameMatch{ idMatch:%s, winner:%s, lost:%s }", this.idMatch, this.player);
		
	}
	
}
