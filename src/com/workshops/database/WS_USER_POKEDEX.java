package com.workshops.database;


import java.io.Serializable;

public class WS_USER_POKEDEX implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int USER_ID;
	private int POKEMON_ID;
	private int HUNT_COUNT;
	
	private WS_POKEMON WS_POKEMON;
	
	public WS_POKEMON getWS_POKEMON() {
		return WS_POKEMON;
	}
	public void setWS_POKEMON(WS_POKEMON wS_POKEMON) {
		WS_POKEMON = wS_POKEMON;
	}
	public int getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	public int getPOKEMON_ID() {
		return POKEMON_ID;
	}
	public void setPOKEMON_ID(int pOKEMON_ID) {
		POKEMON_ID = pOKEMON_ID;
	}
	public int getHUNT_COUNT() {
		return HUNT_COUNT;
	}
	public void setHUNT_COUNT(int hUNT_COUNT) {
		HUNT_COUNT = hUNT_COUNT;
	}	
	
	
}
