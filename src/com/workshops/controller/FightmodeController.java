package com.workshops.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.workshops.database.Configdb;
import com.workshops.database.WS_POKEMON;
import com.workshops.database.WS_USER;
import com.workshops.database.WS_USER_POKEDEX;
import com.workshops.fightmode.PaoYingShupR;
import com.workshops.fightmode.PaoYingShupType;

@Controller
public class FightmodeController {
	PaoYingShupR PaoYingShupR = new PaoYingShupR();
	Random rand = new Random();

	@RequestMapping("/standby")
	public ModelAndView standby(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		if(session.getAttribute("WS_USER")==null){
			return new ModelAndView("redirect:/home");
		}{
		Connection conn = Configdb.getConnectionDB();
		Random rand = new Random();
		WS_POKEMON WS_POKEMON = null;
		int CP = 0;
		String query = "SELECT TOP 1 * FROM WS_POKEMON ORDER BY NEWID()";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = conn.prepareStatement(query);
			ResultSet resultSet = preparedStmt.executeQuery();
			while (resultSet.next()) {
				WS_POKEMON = new WS_POKEMON();
				WS_POKEMON.setPOKEMON_ID(resultSet.getInt("POKEMON_ID"));
				WS_POKEMON.setPOKEMON_NAME(resultSet.getString("POKEMON_NAME"));
				WS_POKEMON.setPOKEMON_TYPE(resultSet.getString("POKEMON_TYPE"));
				WS_POKEMON.setPOKEMON_IMAGE(resultSet.getString("POKEMON_IMAGE"));
				WS_POKEMON.setPOKEMON_LEVEL(resultSet.getString("POKEMON_LEVEL"));
				WS_POKEMON.setPOKEMON_MIN_CP(resultSet.getInt("POKEMON_MIN_CP"));
				WS_POKEMON.setPOKEMON_MAX_CP(resultSet.getInt("POKEMON_MAX_CP"));
			}
			CP = rand.nextInt(WS_POKEMON.getPOKEMON_MAX_CP()) + WS_POKEMON.getPOKEMON_MAX_CP();
			session.setAttribute("WS_POKEMON", WS_POKEMON);
			session.setAttribute("CP", CP);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

		System.out.println("standby");
		return new ModelAndView("standby");}
	}

	@RequestMapping("/fightmode")
	public ModelAndView fightmode(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		if(session.getAttribute("WS_USER")==null){
			return new ModelAndView("redirect:/home");
		}else{
		try {
			if (session.getAttribute("scoreme") == null) {
				int scoreme = 0;
				int scoreyou = 0;
				session.setAttribute("scoreme", scoreme);
				session.setAttribute("scoreyou", scoreyou);
				System.out.println(scoreyou);
			} else {
				System.out.println("a");
				System.out.println("");
			}
			int waepon = Integer.parseInt(request.getParameter("waepon"));
			PaoYingShupType pokemon = PaoYingShupR.takeAction();
			int poke = takeAction();
			int scoreme = (int) session.getAttribute("scoreme");
			int scoreyou = (int) session.getAttribute("scoreyou");
			if (waepon == 1) {
				if (poke == 1) {
					scoreme = scoreme + 0;
					scoreyou = scoreyou + 0;
				}
				if (poke == 2) {
					scoreme = scoreme + 0;
					scoreyou = scoreyou + 1;
				}
				if (poke == 3) {
					scoreme = scoreme + 1;
					scoreyou = scoreyou + 0;
				}
			}
			if (waepon == 2) {
				if (poke == 1) {
					scoreme = scoreme + 1;
					scoreyou = scoreyou + 0;
				}
				if (poke == 2) {
					scoreme = scoreme + 0;
					scoreyou = scoreyou + 0;
				}
				if (poke == 3) {
					scoreme = scoreme + 0;
					scoreyou = scoreyou + 1;
				}
			}
			if (waepon == 3) {
				if (poke == 1) {
					scoreme = scoreme + 0;
					scoreyou = scoreyou + 1;
				}
				if (poke == 2) {
					scoreme = scoreme + 1;
					scoreyou = scoreyou + 0;
				}
				if (poke == 3) {
					scoreme = scoreme + 0;
					scoreyou = scoreyou + 0;
				}
			}

			System.out.println("waepon  :" + waepon);
			System.out.println("pokemon2 :" + poke);
			session.setAttribute("waepon ", waepon);
			session.setAttribute("poke", poke);
			session.setAttribute("scoreme", scoreme);
			session.setAttribute("scoreyou", scoreyou);
			System.out.println("scoreyou" + scoreyou);
			System.out.println("scoreme" + scoreme);

			// conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

		return new ModelAndView("fightmode");}
	}

	public int takeAction() {
		int i = rand.nextInt(3);
		int a;
		switch (i) {
		case 0:
			a = 1;
			break;
		case 1:
			a = 2;
			break;
		default:
			a = 3;
		}
		return a;
	}

	@RequestMapping("/waepon")
	public ModelAndView waepon(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		if(session.getAttribute("WS_USER")==null){
			return new ModelAndView("redirect:/home");
		}else{
		try {
			if (session.getAttribute("scoreme") == null || session.getAttribute("scoreyou") == null) {
				WS_USER WS_USER = (WS_USER) session.getAttribute("WS_USER");
				if (WS_USER == null) {
					return new ModelAndView("redirect:/");
				} else {
					WS_USER.setCURRENT_POCKET_SLOT(WS_USER.getCURRENT_POCKET_SLOT() - 1);
				}
				System.out.println("2");
			} else {
				if ((int) session.getAttribute("scoreme") == 3 || (int) session.getAttribute("scoreyou") == 3) {
					return new ModelAndView("redirect:/save");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

		return new ModelAndView("waepon");}
	}

	@RequestMapping("/save")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException {
		if(session.getAttribute("WS_USER")==null){
			return new ModelAndView("redirect:/home");
		}else{
		Connection conn = Configdb.getConnectionDB();
		WS_USER WS_USER = (WS_USER) session.getAttribute("WS_USER");
		WS_POKEMON WS_POKEMON = (WS_POKEMON) session.getAttribute("WS_POKEMON");
		WS_USER_POKEDEX WS_USER_POKEDEX = null;
		int CP = (int) session.getAttribute("CP");
		int SCOREM = (int) session.getAttribute("scoreme");
		int SCOREU = (int) session.getAttribute("scoreyou");
		int EARN_EXP = 0;
		PreparedStatement preparedStmt;
		if (SCOREM == 3) {
			EARN_EXP = CP;

			String query = "SELECT * FROM WS_USER_POKEDEX WHERE USER_ID = ? AND POKEMON_ID = ?";
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, WS_USER.getUSER_ID());
			preparedStmt.setInt(2, WS_POKEMON.getPOKEMON_ID());
			ResultSet resultSet = preparedStmt.executeQuery();
			if (resultSet.next()) {
				WS_USER_POKEDEX = new WS_USER_POKEDEX();
				WS_USER_POKEDEX.setHUNT_COUNT(WS_USER_POKEDEX.getHUNT_COUNT() + 1);
			} else {
				String query2 = "insert into WS_USER_POKEDEX(USER_ID,POKEMON_ID,HUNT_COUNT) " + " values(?,?,?)";
				try {
					preparedStmt = conn.prepareStatement(query2);
					preparedStmt.setInt(1, WS_USER.getUSER_ID());
					preparedStmt.setInt(2, WS_POKEMON.getPOKEMON_ID());
					preparedStmt.setInt(3, 1);
					preparedStmt.execute();
					System.out.println("add");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if (SCOREM < 3) {
			EARN_EXP = (CP * SCOREM )/3;
		}

		String query = "insert into WS_HUNT_TRANSACTION(USER_ID, POKEMON_ID, TXN_DATETIME, EARN_EXP, PLAYER_WIN_COUNT, POKEMON_WIN_COUNT) "
				+ " values(?,?,SYSDATETIME(),?,?,?)";
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, WS_USER.getUSER_ID());
			preparedStmt.setInt(2, WS_POKEMON.getPOKEMON_ID());
			preparedStmt.setInt(3, EARN_EXP);
			preparedStmt.setInt(4, SCOREM);
			preparedStmt.setInt(5, SCOREU);
			preparedStmt.execute();
			System.out.println("add");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		calculator_level(WS_USER,EARN_EXP);
		updateUser(WS_USER);
		session.removeAttribute("scoreme");
		session.removeAttribute("scoreyou");
		return new ModelAndView("redirect:/standby");}
	}

	public void calculator_level(WS_USER WS_USER, int EARN_EXP) {
		WS_USER.setCURRENT_EXP(WS_USER.getCURRENT_EXP() + EARN_EXP);
		while (WS_USER.getCURRENT_EXP() > WS_USER.getMAX_LEVEL_EXP()) {
			WS_USER.setCURRENT_LEVEL(WS_USER.getCURRENT_LEVEL() + 1);
			WS_USER.setMAX_POCKET_SLOT(calculator_pocket_slot(WS_USER.getMAX_POCKET_SLOT()));
			WS_USER.setMAX_LEVEL_EXP(calculator_max_level_exp(WS_USER.getMAX_LEVEL_EXP()));
		}
	}

	public int calculator_pocket_slot(int pocket_slot_old) {
		return (int) Math.ceil(pocket_slot_old * 1.15);
	}

	public int calculator_max_level_exp(int max_exp_old) {
		return (int) Math.ceil((max_exp_old * 2) + (1.1 * max_exp_old));
	}
	
	public void updateUser(WS_USER WS_USER) {
      try {
      	Connection conn = Configdb.getConnectionDB();
          String query = "UPDATE WS_USER SET CURRENT_LEVEL=? , CURRENT_EXP=? , CURRENT_POCKET_SLOT=? , MAX_LEVEL_EXP=? , MAX_POCKET_SLOT=? "
                  + " WHERE USER_ID = ?";
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          preparedStmt = conn.prepareStatement(query);
          preparedStmt.setInt(1, WS_USER.getCURRENT_LEVEL());
          preparedStmt.setInt(2, WS_USER.getCURRENT_EXP());
          preparedStmt.setInt(3, WS_USER.getCURRENT_POCKET_SLOT());
          preparedStmt.setInt(4, WS_USER.getMAX_LEVEL_EXP());
          preparedStmt.setInt(5, WS_USER.getMAX_POCKET_SLOT());
          preparedStmt.setInt(6, WS_USER.getUSER_ID());
          preparedStmt.executeUpdate();
      } catch (SQLException ex) {
          ex.printStackTrace();
      }
  }
}
