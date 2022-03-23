package com.bvc.app.helpers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDb {

		static String db = "db_sergiodiaz";
		static String login = "root";
		static String password = "CRISTOVIVE22";
		static String url = "jdbc:mysql://localhost/" + db;

		Connection conn = null;

		public void Conexion() {
			try {
				
				Class.forName("com.mysql.jdbc.Driver");

			
				conn = DriverManager.getConnection(url, login, password);
				if (conn != null) {
					System.out.println("conected" + db);
				}
			} catch (SQLException e) {
				System.out.println("SQLException");
				e.printStackTrace();
			} catch (Exception e) {

				System.out.println("Exception");
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
