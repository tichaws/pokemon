package com.workshops.database;

import java.util.List;

public class ShopDetail {
 private int ITEM_ID;
 private String ITEM_NAME ;
 private int ITEM_PRICE ;
 private int POKEBALL_QTY ;
 
 List<WS_SHOP> list_shop;
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
public int getITEM_PRICE() {
	return ITEM_PRICE;
}
public void setITEM_PRICE(int iTEM_PRICE) {
	ITEM_PRICE = iTEM_PRICE;
}

public List<WS_SHOP> getList_shop() {
	return list_shop;
}
public void setList_shop(List<WS_SHOP> list_shop) {
	this.list_shop = list_shop;
}
public int getPOKEBALL_QTY() {
	return POKEBALL_QTY;
}
public void setPOKEBALL_QTY(int pOKEBALL_QTY) {
	POKEBALL_QTY = pOKEBALL_QTY;
}
}
