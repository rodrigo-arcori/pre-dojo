package com.predojo.app.entity;

import java.io.Serializable;

/**
 * <pre>
 * 	First Player game.
 * </pre>
 * @author rodrigo.arcori - https://github.com/rodrigo-arcori
 *
 */
public final class Player implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1978368991113657521L;

	private String name;
	
	private Weapon weapon = Weapon.BAYONET;
	
	private Player lost;
	
	public Player( String name ) {
		this.name = name;
	}
	
	public String getName() {
		
		return name;
		
	}

	public Weapon getWeapon() {
		
		return weapon;
		
	}

	public void setWeapon( Weapon weapon ) {
		
		this.weapon = weapon;
		
	}

	public Player getLost() {
		
		return lost;
		
	}

	public void setLost(Player lost) {
		
		this.lost = lost;
		
	}

	@Override
	public String toString() {
		
		return String.format("Player{ name:%s, weapon:%s }", this.name, this.weapon ) ;
		
	}

}
