package com.predojo.app.api.test;

import org.junit.Assert;
import org.junit.Test;

import com.predojo.app.entity.Weapon;

/**
 * WeaponTest used for validate state object.
 * @author rodrigo.arcori - https://github.com/rodrigo-arcori
 *
 */
public class WeaponTest {
	
	@Test
	public final void invalidState(){
		
		RuntimeException exception = null;
		
		try {
			
			Weapon.getEnum( "Anything" );
			
		} catch( IllegalArgumentException e ) {
			
			exception = e;
			
		}
		
		Assert.assertNotNull( "Exception was not thrown", exception );
		
		Assert.assertEquals( "No Enum Weapon specified correctly.", exception.getMessage() );
	}

}
