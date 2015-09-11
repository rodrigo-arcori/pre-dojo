package com.predojo.app.service.test;

import org.junit.Assert;
import org.junit.Test;

import com.predojo.app.entity.GameMatch;
import com.predojo.app.entity.Player;
import com.predojo.app.entity.Weapon;
import com.predojo.app.service.data.DataProcessesService;
import com.predojo.app.service.data.IDataProcesses;

/**
 * DataProcessesServiceTest used for validate state object.
 * @author rodrigo.arcori - https://github.com/rodrigo-arcori
 *
 */
public class DataProcessesServiceTest {

	@Test
	public final void invalidState() {
		
		IDataProcesses dataProcesses = new DataProcessesService();
		
		RuntimeException exception = null;
		
		try {
			
			dataProcesses.execute( null );
			
		} catch( NullPointerException e ) {
			
			exception = e;
		}
		
		Assert.assertNotNull( "Exception was not thrown", exception );
		
		Assert.assertTrue( "Response list is not empty", dataProcesses.getResponse().isEmpty() );
	}
	
	@Test
	public final void validState(){

		Player winner = new Player( "Rodrigo" );
		
		winner.setWeapon( Weapon.DROWN );

		winner.setLost( new Player( "Batman" ) );

		GameMatch gameMatch = new GameMatch(new Integer( "0101010" ), winner);

		IDataProcesses dataProcesses = new DataProcessesService();
		
		dataProcesses.execute( gameMatch );
		
		Assert.assertFalse( "Response list is empty",  dataProcesses.getResponse().isEmpty() );
	}
	
}
