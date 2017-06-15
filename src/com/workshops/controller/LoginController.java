package com.workshops.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.workshops.database.Configdb;
import com.workshops.database.WS_TEAM;
import com.workshops.database.WS_USER;

@Controller
public class LoginController {
	@RequestMapping("/register")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Connection conn = Configdb.getConnectionDB();	
		try {

			// the mysql insert statement
			String query = " insert into WS_USER (USER_NAME, USER_PASSWORD,USER_GENDER,PLAYER_NAME,TEAM_ID,CURRENT_LEVEL,"
					+ "CURRENT_EXP,CURRENT_POCKET_SLOT,MAX_LEVEL_EXP,MAX_POCKET_SLOT)" + " values (?, ?, ?, ?, ?,0,0,15,100,15)";

			// create the mysql insert preparedstatement

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, request.getParameter("username_re"));
			preparedStmt.setString(2, request.getParameter("password_re"));
			preparedStmt.setInt(3, Integer.parseInt(request.getParameter("gender")));
			preparedStmt.setString(4, request.getParameter("playername_re"));
			preparedStmt.setInt(5, Integer.parseInt(request.getParameter("team")));

			// execute the preparedstatement
			preparedStmt.execute();

			// conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

		return  new ModelAndView  ("redirect:/home");
	}
	
	@RequestMapping(value="home",method =RequestMethod.GET)
	public String indexGET(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException  {
	
		System.out.println("home");
		setDataRegister(request,response,session);
		return "index";
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException  {	
		System.out.println("logout");
		session.invalidate();
		return "redirect:/home";
		
	}
	
	public void setDataRegister(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException {
		List<WS_TEAM> list_WS_TEAM = new ArrayList<WS_TEAM>();
		Connection conn = Configdb.getConnectionDB();
		try {
			// the mysql insert statement
			String query = "SELECT * FROM WS_TEAM";

			// create the mysql insert preparedstatement

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			ResultSet resultSet = preparedStmt.executeQuery();
			while (resultSet.next()) {
				WS_TEAM WS_TEAM = new WS_TEAM();
				WS_TEAM.setTEAM_ID(resultSet.getInt("TEAM_ID"));
				WS_TEAM.setTEAM_NAME(resultSet.getString("TEAM_NAME"));
				WS_TEAM.setTEAM_IMAGE(resultSet.getString("TEAM_IMAGE"));
				
				WS_TEAM.setTEAM_COLOR(resultSet.getString("TEAM_COLOR"));
				list_WS_TEAM.add(WS_TEAM);
				// execute the preparedstatement
			}

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());

		}

		// conn.close();
		session.setAttribute("list_WS_TEAM", list_WS_TEAM);
	}

	@RequestMapping("/welcome")
	public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		WS_USER WS_USER = null;
		Connection conn = Configdb.getConnectionDB();
		try {

			// the mysql insert statement
			String query = "SELECT  * FROM WS_USER U"
					+ " INNER JOIN WS_TEAM T ON U.TEAM_ID = T.TEAM_ID"
					+ " WHERE U.USER_NAME = ? AND U.USER_PASSWORD = ?";

			// create the mysql insert preparedstatement

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, request.getParameter("username"));
			preparedStmt.setString(2, request.getParameter("password"));

			ResultSet resultSet = preparedStmt.executeQuery();

			if (resultSet.next()) {
				WS_USER = new WS_USER();
				WS_USER.setUSER_ID(resultSet.getInt("USER_ID"));
				WS_USER.setUSER_NAME(resultSet.getString("USER_NAME"));
				WS_USER.setUSER_PASSWORD(resultSet.getString("USER_PASSWORD"));
				WS_USER.setUSER_GENDER(resultSet.getString("USER_GENDER").charAt(0));
				WS_USER.setPLAYER_NAME(resultSet.getString("PLAYER_NAME"));
				WS_USER.setTEAM_ID(resultSet.getInt("TEAM_ID"));
				WS_USER.setCURRENT_LEVEL(resultSet.getInt("CURRENT_LEVEL"));
				WS_USER.setCURRENT_EXP(resultSet.getInt("CURRENT_EXP"));
				WS_USER.setCURRENT_POCKET_SLOT(resultSet.getInt("CURRENT_POCKET_SLOT"));
				WS_USER.setMAX_LEVEL_EXP(resultSet.getInt("MAX_LEVEL_EXP"));
				WS_USER.setMAX_POCKET_SLOT(resultSet.getInt("MAX_POCKET_SLOT"));

	   		WS_TEAM WS_TEAM = new WS_TEAM();
				WS_TEAM.setTEAM_ID(resultSet.getInt("TEAM_ID"));
				WS_TEAM.setTEAM_NAME(resultSet.getString("TEAM_NAME"));
				WS_TEAM.setTEAM_COLOR(resultSet.getString("TEAM_COLOR"));
				WS_TEAM.setTEAM_IMAGE(resultSet.getString("TEAM_IMAGE"));

				WS_USER.setWS_TEAM(WS_TEAM);
				
				session.setAttribute("WS_USER", WS_USER);
				return new ModelAndView("redirect:/dashboard");
			}
			// execute the preparedstatement
			else {
				 String mgs = "LoginFail";
				 request.setAttribute("mgs", mgs);
				System.out.println(""+mgs);
				return new ModelAndView("redirect:/","mgs",mgs);
			}
		} catch (

		Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return new ModelAndView("welcome");
	}
	
}
