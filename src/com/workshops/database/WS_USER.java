package com.workshops.database;

import com.workshops.database.WS_LOGIN_HISTORY;
import com.workshops.database.WS_PURCHASE_TRANSACTION;
import java.io.Serializable;
import java.util.List;

public class WS_USER implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int USER_ID;
	private String USER_NAME;
	private String USER_PASSWORD;
	private char USER_GENDER;
	private String PLAYER_NAME;
	private int TEAM_ID;
	private int CURRENT_LEVEL;
	private int CURRENT_EXP;
	private int CURRENT_POCKET_SLOT;
	private int CURRENT_EXTRA_SLOT;
	private int MAX_LEVEL_EXP;
	private int MAX_POCKET_SLOT;
	
	private WS_LOGIN_HISTORY WS_LOGIN_HISTORY;
	private WS_TEAM WS_TEAM;
	
	private List<WS_USER_POKEDEX> list_WS_USER_POKEDEX;
	private List<WS_HUNT_TRANSACTION> list_WS_HUNT_TRANSACTION;
	private List<WS_LOGIN_HISTORY> list_WS_LOGIN_HISTORY;
	private List<WS_PURCHASE_TRANSACTION> list_WS_PURCHASE_TRANSACTION;
	
	
	public WS_LOGIN_HISTORY getWS_LOGIN_HISTORY() {
		return WS_LOGIN_HISTORY;
	}
	public void setWS_LOGIN_HISTORY(WS_LOGIN_HISTORY wS_LOGIN_HISTORY) {
		WS_LOGIN_HISTORY = wS_LOGIN_HISTORY;
	}
	public WS_TEAM getWS_TEAM() {
		return WS_TEAM;
	}
	public void setWS_TEAM(WS_TEAM wS_TEAM) {
		WS_TEAM = wS_TEAM;
	}
	public int getCURRENT_EXP() {
		return CURRENT_EXP;
	}
	public void setCURRENT_EXP(int cURRENT_EXP) {
		CURRENT_EXP = cURRENT_EXP;
	}
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
	public List<WS_LOGIN_HISTORY> getList_WS_LOGIN_HISTORY() {
		return list_WS_LOGIN_HISTORY;
	}
	public void setList_WS_LOGIN_HISTORY(List<WS_LOGIN_HISTORY> list_WS_LOGIN_HISTORY) {
		this.list_WS_LOGIN_HISTORY = list_WS_LOGIN_HISTORY;
	}
	public List<WS_PURCHASE_TRANSACTION> getList_WS_PURCHASE_TRANSACTION() {
		return list_WS_PURCHASE_TRANSACTION;
	}
	public void setList_WS_PURCHASE_TRANSACTION(List<WS_PURCHASE_TRANSACTION> list_WS_PURCHASE_TRANSACTION) {
		this.list_WS_PURCHASE_TRANSACTION = list_WS_PURCHASE_TRANSACTION;
	}
	public int getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}
	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}
	public char getUSER_GENDER() {
		return USER_GENDER;
	}
	public void setUSER_GENDER(char uSER_GENDER) {
		USER_GENDER = uSER_GENDER;
	}
	public String getPLAYER_NAME() {
		return PLAYER_NAME;
	}
	public void setPLAYER_NAME(String pLAYER_NAME) {
		PLAYER_NAME = pLAYER_NAME;
	}
	public int getTEAM_ID() {
		return TEAM_ID;
	}
	public void setTEAM_ID(int tEAM_ID) {
		TEAM_ID = tEAM_ID;
	}
	public int getCURRENT_LEVEL() {
		return CURRENT_LEVEL;
	}
	public void setCURRENT_LEVEL(int cURRENT_LEVEL) {
		CURRENT_LEVEL = cURRENT_LEVEL;
	}
	public int getCURRENT_POCKET_SLOT() {
		return CURRENT_POCKET_SLOT;
	}
	public void setCURRENT_POCKET_SLOT(int cURRENT_POCKET_SLOT) {
		CURRENT_POCKET_SLOT = cURRENT_POCKET_SLOT;
	}
	public int getCURRENT_EXTRA_SLOT() {
		return CURRENT_EXTRA_SLOT;
	}
	public void setCURRENT_EXTRA_SLOT(int cURRENT_EXTRA_SLOT) {
		CURRENT_EXTRA_SLOT = cURRENT_EXTRA_SLOT;
	}
	public int getMAX_LEVEL_EXP() {
		return MAX_LEVEL_EXP;
	}
	public void setMAX_LEVEL_EXP(int mAX_LEVEL_EXP) {
		MAX_LEVEL_EXP = mAX_LEVEL_EXP;
	}
	public int getMAX_POCKET_SLOT() {
		return MAX_POCKET_SLOT;
	}
	public void setMAX_POCKET_SLOT(int mAX_POCKET_SLOT) {
		MAX_POCKET_SLOT = mAX_POCKET_SLOT;
	}
}

