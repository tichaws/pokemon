package com.workshops.database;


import java.io.Serializable;

public class WS_HUNT_TRANSACTION  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int HUNT_TXN_ID;
	private int USER_ID;
	private int POKEMON_ID;
	private String TXN_DATETIME;
	private int EARN_EXP;
	private int PLAYER_WIN_COUNT;
	private int POKEMON_WIN_COUNT;
	
	private WS_POKEMON WS_POKEMON;
	
	public WS_POKEMON getWS_POKEMON() {
		return WS_POKEMON;
	}
	public void setWS_POKEMON(WS_POKEMON wS_POKEMON) {
		WS_POKEMON = wS_POKEMON;
	}
	public int getHUNT_TXN_ID() {
		return HUNT_TXN_ID;
	}
	public void setHUNT_TXN_ID(int hUNT_TXN_ID) {
		HUNT_TXN_ID = hUNT_TXN_ID;
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
	public String getTXN_DATETIME() {
		return TXN_DATETIME;
	}
	public void setTXN_DATETIME(String tXN_DATETIME) {
		TXN_DATETIME = tXN_DATETIME;
	}
	public int getEARN_EXP() {
		return EARN_EXP;
	}
	public void setEARN_EXP(int eARN_EXP) {
		EARN_EXP = eARN_EXP;
	}
	public int getPLAYER_WIN_COUNT() {
		return PLAYER_WIN_COUNT;
	}
	public void setPLAYER_WIN_COUNT(int pLAYER_WIN_COUNT) {
		PLAYER_WIN_COUNT = pLAYER_WIN_COUNT;
	}
	public int getPOKEMON_WIN_COUNT() {
		return POKEMON_WIN_COUNT;
	}
	public void setPOKEMON_WIN_COUNT(int pOKEMON_WIN_COUNT) {
		POKEMON_WIN_COUNT = pOKEMON_WIN_COUNT;
	}
	
	
}

