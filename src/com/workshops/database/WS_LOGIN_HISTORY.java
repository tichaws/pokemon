package com.workshops.database;

import java.io.Serializable;

public class WS_LOGIN_HISTORY implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int LOGIN_HIST_ID;
	private int USER_ID;
	private String LOGIN_DATETIME;
	private String LOGOUT_DATETIME;
	
	public WS_LOGIN_HISTORY(){
		
	}
	
	public WS_LOGIN_HISTORY(int USER_ID , String LOGIN_DATETIME){
		this.USER_ID = USER_ID;
		this.LOGIN_DATETIME = LOGIN_DATETIME;
	}
	
	public int getLOGIN_HIST_ID() {
		return LOGIN_HIST_ID;
	}
	public void setLOGIN_HIST_ID(int lOGIN_HIST_ID) {
		LOGIN_HIST_ID = lOGIN_HIST_ID;
	}
	
	public int getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getLOGIN_DATETIME() {
		return LOGIN_DATETIME;
	}
	public void setLOGIN_DATETIME(String lOGIN_DATETIME) {
		LOGIN_DATETIME = lOGIN_DATETIME;
	}
	public String getLOGOUT_DATETIME() {
		return LOGOUT_DATETIME;
	}
	public void setLOGOUT_DATETIME(String lOGOUT_DATETIME) {
		LOGOUT_DATETIME = lOGOUT_DATETIME;
	}
}
