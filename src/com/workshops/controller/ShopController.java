package com.workshops.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.workshops.database.Configdb;
import com.workshops.database.ShopDetail;
import com.workshops.database.WS_USER;

@Controller
public class ShopController {

	@RequestMapping("/shop")
	public ModelAndView shop(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		if(session.getAttribute("WS_USER")==null){
			return new ModelAndView("redirect:/home");
		}else{
		Connection conn = Configdb.getConnectionDB();
		List<ShopDetail> list_shop = new ArrayList<ShopDetail>();
		String query = "SELECT ITEM_ID, ITEM_NAME, ITEM_PRICE, POKEBALL_QTY FROM WS_SHOP";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			ResultSet resultSet = null;
			resultSet = preparedStmt.executeQuery();
			while (resultSet.next()) {
				ShopDetail shopDetail = new ShopDetail();
				shopDetail.setITEM_ID(resultSet.getInt("ITEM_ID"));
				shopDetail.setITEM_NAME(resultSet.getString("ITEM_NAME"));
				shopDetail.setITEM_PRICE(resultSet.getInt("ITEM_PRICE"));
				shopDetail.setPOKEBALL_QTY(resultSet.getInt("POKEBALL_QTY"));
				list_shop.add(shopDetail);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("list_shop", list_shop);
		return new ModelAndView("shop");}
	}

	@RequestMapping("/paymentTransaction")
	public ModelAndView pay(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException {
		String json_data = request.getParameter("transactionPaymentData");
      JSONObject transactionPaymentData = new JSONObject(json_data);
      int ITEM_ID = transactionPaymentData.getInt("ITEM_ID");
      int pocketSlot_purchased = transactionPaymentData.getInt("pocketslot_qty");
      String transactionID = transactionPaymentData.getString("transactionID");
      WS_USER WS_USER = (WS_USER) session.getAttribute("WS_USER");
		Connection conn = Configdb.getConnectionDB();
		int id = 0;
		String query = "insert into WS_PURCHASE_TRANSACTION(USER_ID , ITEM_ID , TRANSACTION_ID , PURC_DATETIME) "
				+ " values(?,?,?,SYSDATETIME())";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStmt.setInt(1, WS_USER.getUSER_ID());
			preparedStmt.setInt(2, ITEM_ID);
			preparedStmt.setString(3, transactionID);
			preparedStmt.execute();
			ResultSet rs = preparedStmt.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			} else {
				throw new SQLException("Creating user failed, no ID obtained.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		WS_USER.setCURRENT_POCKET_SLOT(WS_USER.getCURRENT_POCKET_SLOT()+pocketSlot_purchased);
		updateCurrentPocketSlot(WS_USER);
		return new ModelAndView("shop");
	}
	
	public void updateCurrentPocketSlot(WS_USER WS_USER) {
      try {
      	Connection conn = Configdb.getConnectionDB();    	
          String query = "UPDATE WS_USER SET CURRENT_POCKET_SLOT=? "
                  + " WHERE USER_ID = ?";
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          preparedStmt = conn.prepareStatement(query);
          preparedStmt.setInt(1, WS_USER.getCURRENT_POCKET_SLOT());
          preparedStmt.setInt(2, WS_USER.getUSER_ID());
          preparedStmt.executeUpdate();
      } catch (SQLException ex) {
          ex.printStackTrace();
      } 
  }
}