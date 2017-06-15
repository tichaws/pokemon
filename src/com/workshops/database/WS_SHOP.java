package com.workshops.database;


import com.workshops.database.WS_PURCHASE_TRANSACTION;
import java.io.Serializable;
import java.util.List;

public class WS_SHOP implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ITEM_ID;
	private String ITEM_NAME;
	private Double ITEM_PRICE;
	private int NO_POKEBALL;
	private int POKEBALL_QTY;
	
	private List<WS_PURCHASE_TRANSACTION> list_WS_PURCHASE_TRANSACTION;
	
	public List<WS_PURCHASE_TRANSACTION> getList_WS_PURCHASE_TRANSACTION() {
		return list_WS_PURCHASE_TRANSACTION;
	}
	public void setList_WS_PURCHASE_TRANSACTION(List<WS_PURCHASE_TRANSACTION> list_WS_PURCHASE_TRANSACTION) {
		this.list_WS_PURCHASE_TRANSACTION = list_WS_PURCHASE_TRANSACTION;
	}
	public int getITEM_ID() {
		return ITEM_ID;
	}
	public void setITEM_ID(int iTEM_ID) {
		ITEM_ID = iTEM_ID;
	}
	public String getITEM_NAME() {
		return ITEM_NAME;
	}
	public void setITEM_NAME(String iTEM_NAME) {
		ITEM_NAME = iTEM_NAME;
	}
	public Double getITEM_PRICE() {
		return ITEM_PRICE;
	}
	public void setITEM_PRICE(Double iTEM_PRICE) {
		ITEM_PRICE = iTEM_PRICE;
	}
	public int getNO_POKEBALL() {
		return NO_POKEBALL;
	}
	public void setNO_POKEBALL(int nO_POKEBALL) {
		NO_POKEBALL = nO_POKEBALL;
	}
	public int getPOKEBALL_QTY() {
		return POKEBALL_QTY;
	}
	public void setPOKEBALL_QTY(int pOKEBALL_QTY) {
		POKEBALL_QTY = pOKEBALL_QTY;
	}
	
	
}
