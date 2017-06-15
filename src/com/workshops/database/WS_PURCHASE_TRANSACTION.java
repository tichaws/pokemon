package com.workshops.database;


import java.io.Serializable;

public class WS_PURCHASE_TRANSACTION implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int PURC_TXN_ID;
	private int USER_ID;
	private int ITEM_ID;
	private String PURC_DATETIME;
	private String TRANSACTION_ID;
	
	private WS_SHOP WS_SHOP;
	
	public WS_SHOP getWS_SHOP() {
		return WS_SHOP;
	}
	public void setWS_SHOP(WS_SHOP wS_SHOP) {
		WS_SHOP = wS_SHOP;
	}
	public int getPURC_TXN_ID() {
		return PURC_TXN_ID;
	}
	public void setPURC_TXN_ID(int pURC_TXN_ID) {
		PURC_TXN_ID = pURC_TXN_ID;
	}
	public int getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	public int getITEM_ID() {
		return ITEM_ID;
	}
	public void setITEM_ID(int iTEM_ID) {
		ITEM_ID = iTEM_ID;
	}
	public String getPURC_DATETIME() {
		return PURC_DATETIME;
	}
	public void setPURC_DATETIME(String pURC_DATETIME) {
		PURC_DATETIME = pURC_DATETIME;
	}
	public String getTRANSACTION_ID() {
		return TRANSACTION_ID;
	}
	public void setTRANSACTION_ID(String tRANSACTION_ID) {
		TRANSACTION_ID = tRANSACTION_ID;
	}
	
	
}
