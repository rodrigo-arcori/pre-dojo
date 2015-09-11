package com.predojo.app.api.test;

import org.junit.Assert;
import org.junit.Test;

import com.predojo.app.entity.DataMatch;
import com.predojo.app.entity.GameMatch;
import com.predojo.app.entity.Player;
import com.predojo.app.entity.Weapon;

/**
 * MatchTest used for validate state object.
 * @author rodrigo.arcori - https://github.com/rodrigo-arcori
 *
 */
public class MatchTest 
{
	
	@Test
	public void invalidGameMatchState() {
		
		GameMatch gameMatch = new GameMatch( null, null );
		
		Assert.assertNotNull( gameMatch );
		
		Assert.assertNull( gameMatch.getIdMatch() );
		
		Assert.assertNull( gameMatch.getPlayer() );
	}
	
	@Test
	public void invalidDataMatchState() {
		
		RuntimeException exception = null;
		
		DataMatch dataMatch = new DataMatch();
		
		try {
			
			dataMatch.counter( null );
			
		} catch( NullPointerException e ) {
			
			exception = e;
		}
		
		Assert.assertNotNull( "Exception was not thrown", exception );
		
		Assert.assertNotNull( dataMatch );
		
		Assert.assertTrue( "Response list is not empty", dataMatch.getResponse().isEmpty() );
	}
	
	@Test
	public void validState(){
		
		DataMatch dataMatch = new DataMatch();

		Player winner = new Player( "Rodrigo" );
		
		winner.setWeapon( Weapon.DROWN );

		winner.setLost( new Player( "Batman" ) );

		GameMatch gameMatch = new GameMatch(new Integer( "0101010" ), winner);

		dataMatch.counter( gameMatch );
		
		Assert.assertNotNull( "DataMatch is null",  dataMatch );
		
		Assert.assertNotNull( "DataMatch is null",  gameMatch );
		
		Assert.assertFalse( "Response list is empty",  dataMatch.getResponse().isEmpty() );
	}
	
}
