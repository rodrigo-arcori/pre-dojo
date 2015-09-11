package com.predojo.app.api.test;

import org.junit.Assert;
import org.junit.Test;

import com.predojo.app.entity.Player;
import com.predojo.app.entity.Weapon;

/**
 * PlayerTest used for validate state object.
 * @author rodrigo.arcori - https://github.com/rodrigo-arcori
 *
 */
public class PlayerTest {
	
	@Test
	public final void validState(){
		
		final String winnerName = "Roman";
		
		final String lostName = "Nick";
		
		final String weaponName = "DROWN";
		
		Player player = new Player( winnerName );
		
		player.setWeapon( Weapon.getEnum( weaponName )  );
		
		player.setLost( new Player( lostName ) );
		
		Assert.assertEquals( winnerName, player.getName() );
		
		Assert.assertEquals( lostName, player.getLost().getName() );
		
		Assert.assertEquals( weaponName, player.getWeapon().name() );
	}
	
	@Test
	public final void invalidState(){
		
		Player player = new Player( "" );
		
		Assert.assertEquals( "", player.getName() );
		
		Assert.assertNull( player.getLost() );
	}

}
