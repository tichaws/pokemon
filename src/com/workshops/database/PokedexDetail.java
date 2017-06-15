package com.workshops.database;

import java.util.List;

public class PokedexDetail {
private int POKEMON_ID ;
private String POKEMON_NAME;
private String POKEMON_IMAGE ;
private int HUNT_COUNT;

private List<WS_USER_POKEDEX> list_Pokedex;

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

public String getPOKEMON_IMAGE() {
	return POKEMON_IMAGE;
}

public void setPOKEMON_IMAGE(String pOKEMON_IMAGE) {
	POKEMON_IMAGE = pOKEMON_IMAGE;
}

public int getHUNT_COUNT() {
	return HUNT_COUNT;
}

public void setHUNT_COUNT(int hUNT_COUNT) {
	HUNT_COUNT = hUNT_COUNT;
}

public List<WS_USER_POKEDEX> getList_Pokedex() {
	return list_Pokedex;
}

public void setList_Pokedex(List<WS_USER_POKEDEX> list_Pokedex) {
	this.list_Pokedex = list_Pokedex;
}
}
