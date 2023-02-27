package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
			// url
			private static String url = "jdbc:mysql://localhost:3306/";

			// user
			private static String user = "root";
			// password
			private static String password = "";

			// database name
			private static String database_name ="etrehumain";
			
			private static Connection connexion = null;
			
			private MyConnection() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connexion =DriverManager.getConnection(url+database_name,user,password);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			public static Connection getConnection() {
				if(connexion == null) {
					new MyConnection();
					
				}
				return connexion ;
			}
			
			public static void disconnect () {
				try {
					connexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			public static void main(String[] args) {
				MyConnection c= new MyConnection();
				c.getConnection();
			}
}
