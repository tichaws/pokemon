package com.workshops.database;

import com.workshops.database.WS_USER;
import java.io.Serializable;
import java.util.List;

public class WS_TEAM implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int TEAM_ID;
	private String TEAM_NAME;
	private String TEAM_COLOR;
	private String TEAM_IMAGE;
	private int counting_player = 0;
	private int sum_hunting = 0;
	
	private List<WS_USER> list_WS_USER;
	
	
	public int getSum_hunting() {
		return sum_hunting;
	}
	public void setSum_hunting(int sum_hunting) {
		this.sum_hunting = sum_hunting;
	}
	public int getCounting_player() {
		return counting_player;
	}
	public void setCounting_player(int counting_player) {
		this.counting_player = counting_player;
	}
	public List<WS_USER> getList_WS_USER() {
		return list_WS_USER;
	}
	public void setList_WS_USER(List<WS_USER> list_WS_USER) {
		this.list_WS_USER = list_WS_USER;
	}
	public int getTEAM_ID() {
		return TEAM_ID;
	}
	public void setTEAM_ID(int tEAM_ID) {
		TEAM_ID = tEAM_ID;
	}
	public String getTEAM_NAME() {
		return TEAM_NAME;
	}
	public void setTEAM_NAME(String tEAM_NAME) {
		TEAM_NAME = tEAM_NAME;
	}
	public String getTEAM_COLOR() {
		return TEAM_COLOR;
	}
	public void setTEAM_COLOR(String tEAM_COLOR) {
		TEAM_COLOR = tEAM_COLOR;
	}
	public String getTEAM_IMAGE() {
		return TEAM_IMAGE;
	}
	public void setTEAM_IMAGE(String tEAM_IMAGE) {
		TEAM_IMAGE = tEAM_IMAGE;
	}
	
	
}
