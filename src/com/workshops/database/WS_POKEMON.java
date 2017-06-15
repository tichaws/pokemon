package com.workshops.database;


import java.io.Serializable;
import java.util.List;

import com.workshops.database.WS_USER_POKEDEX;
import com.workshops.database.WS_HUNT_TRANSACTION;

public class WS_POKEMON implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int POKEMON_ID;
	private String POKEMON_NAME;
	private String POKEMON_TYPE;
	private String POKEMON_IMAGE;
	private String POKEMON_LEVEL;
	private int POKEMON_MIN_CP;
	private int POKEMON_MAX_CP;
	private List<WS_USER_POKEDEX> list_WS_USER_POKEDEX;
	private List<WS_HUNT_TRANSACTION> list_WS_HUNT_TRANSACTION;
	
	public List<WS_USER_POKEDEX> getList_WS_USER_POKEDEX() {
		return list_WS_USER_POKEDEX;
	}
	public void setList_WS_USER_POKEDEX(List<WS_USER_POKEDEX> list_WS_USER_POKEDEX) {
		this.list_WS_USER_POKEDEX = list_WS_USER_POKEDEX;
	}
	public List<WS_HUNT_TRANSACTION> getList_WS_HUNT_TRANSACTION() {
		return list_WS_HUNT_TRANSACTION;
	}
	public void setList_WS_HUNT_TRANSACTION(List<WS_HUNT_TRANSACTION> list_WS_HUNT_TRANSACTION) {
		this.list_WS_HUNT_TRANSACTION = list_WS_HUNT_TRANSACTION;
	}
	public int getPOKEMON_ID() {
		return POKEMON_ID;
	}
	public void setPOKEMON_ID(int pOKEMON_ID) {
		POKEMON_ID = pOKEMON_ID;
	}
	public String getPOKEMON_NAME() {
		return POKEMON_NAME;
	}
	public void setPOKEMON_NAME(String pOKEMON_NAME) {
		POKEMON_NAME = pOKEMON_NAME;
	}
	public String getPOKEMON_TYPE() {
		return POKEMON_TYPE;
	}
	public void setPOKEMON_TYPE(String pOKEMON_TYPE) {
		POKEMON_TYPE = pOKEMON_TYPE;
	}
	public String getPOKEMON_IMAGE() {
		return POKEMON_IMAGE;
	}
	public void setPOKEMON_IMAGE(String pOKEMON_IMAGE) {
		POKEMON_IMAGE = pOKEMON_IMAGE;
	}
	public String getPOKEMON_LEVEL() {
		return POKEMON_LEVEL;
	}
	public void setPOKEMON_LEVEL(String pOKEMON_LEVEL) {
		POKEMON_LEVEL = pOKEMON_LEVEL;
	}
	public int getPOKEMON_MIN_CP() {
		return POKEMON_MIN_CP;
	}
	public void setPOKEMON_MIN_CP(int pOKEMON_MIN_CP) {
		POKEMON_MIN_CP = pOKEMON_MIN_CP;
	}
	public int getPOKEMON_MAX_CP() {
		return POKEMON_MAX_CP;
	}
	public void setPOKEMON_MAX_CP(int pOKEMON_MAX_CP) {
		POKEMON_MAX_CP = pOKEMON_MAX_CP;
	}
	
	
}

