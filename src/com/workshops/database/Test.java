package com.workshops.database;

import java.sql.Connection;

import java.sql.DriverManager;


/**
 * This program demonstrates how to establish database connection to Microsoft
 * SQL Server.
 * 
 * @author www.codejava.net
 *
 */
public class Test {

	public static void main(String[] args) {
		String DB_URL = "jdbc:jtds:sqlserver://192.168.9.154:1433;DatabaseName=POKEMON_WORKSHOP";
		String user = "workshop";
		String password = "password";
		String DB_driver = "net.sourceforge.jtds.jdbc.Driver";
		@SuppressWarnings("unused")
		Connection conn = null;

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

}
