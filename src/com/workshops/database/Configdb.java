package com.workshops.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configdb {

		private static String DB_URL = "jdbc:jtds:sqlserver://192.168.9.154:1433/POKEMON_WORKSHOP";
		private static String user = "workshop";
		private static String password = "password";
		private static String DB_driver = "net.sourceforge.jtds.jdbc.Driver";
		private static Connection conn = null;

		/**
		 * connection database
		 */
		public static void setConnectionDb() {
			try {
				// connection driver
				Class.forName(DB_driver);
			} catch (ClassNotFoundException e) {
				System.out.println("Fail load Driver Class");
			}
			try {
				// connection database
				conn = DriverManager.getConnection(DB_URL, user, password);
				System.out.println("Success");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * close connection
		 */
		public static void closeConnection() {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public static Connection getConnectionDB() {
			if (conn == null)
				setConnectionDb();
			return conn;
		}

	}
