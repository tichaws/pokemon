package com.workshops.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.workshops.database.Configdb;
import com.workshops.database.HistoryDetail;
import com.workshops.database.PokedexDetail;
import com.workshops.database.WS_PURCHASE_TRANSACTION;
import com.workshops.database.WS_SHOP;
import com.workshops.database.WS_TEAM;
import com.workshops.database.WS_USER;

@Controller
public class DashboardController {
	@RequestMapping("/dashboard")
	public ModelAndView dashboard(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		if (session.getAttribute("WS_USER") == null) {
			return new ModelAndView("redirect:/home");
		} else {
			Connection conn = Configdb.getConnectionDB();
			List<WS_TEAM> list_WS_TEAM = new ArrayList<WS_TEAM>();
			String query = "SELECT WS_TEAM.TEAM_ID, WS_TEAM.TEAM_NAME, (SELECT COUNT(WS_USER.TEAM_ID) "
					+ "FROM WS_USER WHERE WS_TEAM.TEAM_ID = WS_USER.TEAM_ID) COUNT_USER, SUM(HUNT_COUNT) SUM_HUNT FROM  WS_TEAM "
					+ "LEFT JOIN WS_USER ON (WS_TEAM.TEAM_ID = WS_USER.TEAM_ID) " + "LEFT JOIN WS_USER_POKEDEX ON (WS_USER.USER_ID = WS_USER_POKEDEX.USER_ID) "
					+ "GROUP BY WS_TEAM.TEAM_ID, WS_TEAM.TEAM_NAME ORDER BY WS_TEAM.TEAM_ID";
			try {
				PreparedStatement preparedStmt = conn.prepareStatement(query);
				ResultSet resultSet = preparedStmt.executeQuery();
				while (resultSet.next()) {
					WS_TEAM WS_TEAM = new WS_TEAM();
					WS_TEAM.setTEAM_ID(resultSet.getInt("TEAM_ID"));
					WS_TEAM.setTEAM_NAME(resultSet.getString("TEAM_NAME"));
					WS_TEAM.setCounting_player(resultSet.getInt("COUNT_USER"));
					System.out.println("TEAM" + WS_TEAM.getCounting_player());
					WS_TEAM.setSum_hunting(resultSet.getInt("SUM_HUNT"));
					list_WS_TEAM.add(WS_TEAM);

				}
				session.setAttribute("list_WS_TEAM", list_WS_TEAM);
				System.out.println("1");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pokedex(request, response, session);
			getHistory(request, response, session);
			getPurchase(request, response, session);
			return new ModelAndView("welcome");
		}
	}

	public void pokedex(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Connection conn = Configdb.getConnectionDB();
		List<PokedexDetail> list_Pokedex = new ArrayList<PokedexDetail>();
		String query = "SELECT WS_USER_POKEDEX.POKEMON_ID, POKEMON_NAME, POKEMON_IMAGE, HUNT_COUNT FROM WS_USER_POKEDEX "
				+ "JOIN WS_POKEMON ON (WS_USER_POKEDEX.POKEMON_ID = WS_POKEMON.POKEMON_ID) " + "WHERE USER_ID = ? ORDER BY WS_USER_POKEDEX.POKEMON_ID";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			ResultSet resultSet = null;
			WS_USER WS_USER = (WS_USER) session.getAttribute("WS_USER");
			int id = WS_USER.getUSER_ID();
			preparedStmt.setInt(1, id);
			resultSet = preparedStmt.executeQuery();
			while (resultSet.next()) {
				PokedexDetail pokedexDetail = new PokedexDetail();
				pokedexDetail.setPOKEMON_ID(resultSet.getInt("POKEMON_ID"));
				pokedexDetail.setPOKEMON_NAME(resultSet.getString("POKEMON_NAME"));
				pokedexDetail.setPOKEMON_IMAGE(resultSet.getString("POKEMON_IMAGE"));
				pokedexDetail.setHUNT_COUNT(resultSet.getInt("HUNT_COUNT"));
				list_Pokedex.add(pokedexDetail);

			}
			System.out.println(list_Pokedex.size());
			session.setAttribute("list_Pokedex", list_Pokedex);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void getHistory(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		List<HistoryDetail> listHistory = new ArrayList<HistoryDetail>();
		Connection conn = Configdb.getConnectionDB();
		String query = "SELECT Convert(varchar(20),TXN_DATETIME,120) AS DATE_HUNT, POKEMON_NAME, "
				+ "CONCAT(PLAYER_WIN_COUNT , '-' , POKEMON_WIN_COUNT) AS WIN_RESULT "
				+ "FROM WS_HUNT_TRANSACTION JOIN WS_POKEMON ON (WS_HUNT_TRANSACTION.POKEMON_ID = WS_POKEMON.POKEMON_ID) "
				+ "WHERE USER_ID = ? ORDER BY TXN_DATETIME";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			ResultSet resultSet = null;
			WS_USER WS_USER = (WS_USER) session.getAttribute("WS_USER");
			int id = WS_USER.getUSER_ID();
			preparedStmt.setInt(1, id);
			resultSet = preparedStmt.executeQuery();
			while (resultSet.next()) {
				HistoryDetail historyDetail = new HistoryDetail();
				historyDetail.setPOKEMON_NAME(resultSet.getString("POKEMON_NAME"));
				historyDetail.setDATE_HUNT(resultSet.getString("DATE_HUNT"));
				historyDetail.setWIN_RESULT(resultSet.getString("WIN_RESULT"));
				System.out.println(historyDetail);
				listHistory.add(historyDetail);
			}
			session.setAttribute("listHistory", listHistory);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getPurchase(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Connection conn = Configdb.getConnectionDB();
		List<WS_PURCHASE_TRANSACTION> list_WS_PURCHASE_TRANSACTION = new ArrayList<WS_PURCHASE_TRANSACTION>();
		String query = "SELECT  * FROM WS_PURCHASE_TRANSACTION P_T" + " INNER JOIN WS_SHOP S ON P_T.ITEM_ID = S.ITEM_ID" + " WHERE P_T.USER_ID = ? "
				+ " ORDER BY PURC_DATETIME";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			WS_USER WS_USER = (WS_USER) session.getAttribute("WS_USER");
			int id = WS_USER.getUSER_ID();
			preparedStmt.setInt(1, id);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				WS_PURCHASE_TRANSACTION WS_PURCHASE_TRANSACTION = new WS_PURCHASE_TRANSACTION();
				WS_PURCHASE_TRANSACTION.setPURC_TXN_ID(rs.getInt("PURC_TXN_ID"));
				WS_PURCHASE_TRANSACTION.setUSER_ID(rs.getInt("USER_ID"));
				WS_PURCHASE_TRANSACTION.setITEM_ID(rs.getInt("ITEM_ID"));
				WS_PURCHASE_TRANSACTION.setPURC_DATETIME(rs.getString("PURC_DATETIME"));
				WS_PURCHASE_TRANSACTION.setTRANSACTION_ID(rs.getString("TRANSACTION_ID"));

				WS_SHOP WS_SHOP = new WS_SHOP();
				WS_SHOP.setITEM_ID(rs.getInt("ITEM_ID"));
				WS_SHOP.setITEM_NAME(rs.getString("ITEM_NAME"));
				WS_SHOP.setITEM_PRICE(rs.getDouble("ITEM_PRICE"));
				WS_SHOP.setPOKEBALL_QTY(rs.getInt("POKEBALL_QTY"));

				WS_PURCHASE_TRANSACTION.setWS_SHOP(WS_SHOP);
				list_WS_PURCHASE_TRANSACTION.add(WS_PURCHASE_TRANSACTION);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("list_WS_PURCHASE_TRANSACTION", list_WS_PURCHASE_TRANSACTION);
	}

}
