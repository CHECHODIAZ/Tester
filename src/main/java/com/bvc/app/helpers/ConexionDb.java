package com.bvc.app.helpers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDb {

		static String db = "a2censo";
		static String login = "root";
		static String password = "CRISTOVIVE22";
		static String url = "jdbc:mysql://localhost:3306/a2censo?useSSL=false&serverTimezone=GMT-5"; 

		Connection conn = null;

		public void Conexion() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, login, password);
				if (conn != null) {
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public Connection getConnection() {
			return conn;
		}

//		public static void main(String[] args) {
//			Conexion con = new Conexion();
//		}

}
