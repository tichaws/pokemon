package com.workshops.database;
public class HistoryDetail{
	private String POKEMON_NAME;
	private String DATE_HUNT;
	private String WIN_RESULT;
	public String getPOKEMON_NAME() {
		return POKEMON_NAME;
	}
	public void setPOKEMON_NAME(String pOKEMON_NAME) {
		POKEMON_NAME = pOKEMON_NAME;
	}
	public String getDATE_HUNT() {
		return DATE_HUNT;
	}
	public void setDATE_HUNT(String dATE_HUNT) {
		DATE_HUNT = dATE_HUNT;
	}
	public String getWIN_RESULT() {
		return WIN_RESULT;
	}
	public void setWIN_RESULT(String wIN_RESULT) {
		WIN_RESULT = wIN_RESULT;
	}
}