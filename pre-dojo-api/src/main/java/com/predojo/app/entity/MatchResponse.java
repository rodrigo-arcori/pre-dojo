package com.predojo.app.entity;

import java.io.Serializable;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <pre>
 * 	Class response used in the client view.
 * </pre> 
 * @author rodrigo.arcori - https://github.com/rodrigo-arcori
 *
 */
public final class MatchResponse implements Serializable, Comparable< MatchResponse > {

	private Integer idMatch;
	
	private String playerName;
	
	private AtomicInteger counterkiller = new AtomicInteger() ;
	
	private AtomicInteger counterDie = new AtomicInteger();
	
	public MatchResponse( Integer idMatch, String playerName ) {
		
		this.idMatch = idMatch;
		
		this.playerName = playerName;
	}
	
	public void incrementKiller(){
		
		this.counterkiller.incrementAndGet();
		
	}
	
	public void incrementDie(){
		
		this.counterDie.incrementAndGet();
		
	}

	public String getPlayerName() {
		return playerName;
	}
	
	public Integer getIdMatch() {
		
		return idMatch;
		
	}

	public Integer getCounterkiller() {
		
		return counterkiller.get();
		
	}

	public Integer getCounterDie() {
		
		return counterDie.get();
		
	}

	public static Comparator<MatchResponse> MatchResponseKillerComparator = new Comparator<MatchResponse>() {
		
		public int compare(MatchResponse refA, MatchResponse refB) {
			
			Integer idMatchA = refA.counterkiller.intValue();
			
			Integer idMatchB = refB.counterkiller.intValue();
			
			return idMatchB.compareTo(idMatchA);
			
		};
		
	};
	
	@Override
	public int compareTo(MatchResponse matchResponse) {
		
		return Integer.compare(this.idMatch, matchResponse.idMatch);
		
	}

	@Override
	public String toString() {
		
		return String.format("MatchResponse{ idMatch:%s, playerName:%s, counterkilled:%s, counterDies:%s }", idMatch, playerName, counterkiller.get(), counterDie.get() );
		
	}
	
	
}
