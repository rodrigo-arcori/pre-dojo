package com.predojo.app.entity;


/**
 * <pre>
 * 	Weapon used in the game.
 * </pre>
 * 
 * @author rodrigo.arcori - https://github.com/rodrigo-arcori
 * 
 */
public enum Weapon {

	BAYONET,

	DROWN,

	M16,

	P90;

	public static Weapon getEnum( String value ) {
		
		if ( DROWN.name().equals( value ) )
			return DROWN;
		else if ( M16.name().equals( value ) )
			return M16;
		else if ( P90.name().equals( value ) )
			return P90;
		
		throw new IllegalArgumentException( "No Enum Weapon specified correctly." );
	}

}
