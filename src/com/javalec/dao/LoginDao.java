package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.javalec.util.ShareVar;

public class LoginDao {
	// Field
		String id;
		String password;
		
		private final String url_mysql = ShareVar.DBNAME; //sql에서 db가져오기
		private final String id_mysql = ShareVar.DBUSER;
		private final String pw_mysql = ShareVar.DBPASS;
		
		
		// Constructor
		public LoginDao() {
			// TODO Auto-generated constructor stub
		}


		public LoginDao(String id, String password) {
			super();
			this.id = id;
			this.password = password;
		}
		
		
		public boolean checkAction(int isAdmin) {
			// admin 이면 1 유저는 0

			ShareVar.id = "";
			String wkId = "";
			String wkPw = "";
			String whereDefault;

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				if (isAdmin == 0) {
					whereDefault = "select customerid, password from customer where customerid = '" + id + "'";
				} else {
					whereDefault = "select adminid, password from admin where adminid = '" + id + "'";
				}

				ResultSet rs = stmt_mysql.executeQuery(whereDefault);

				if (rs.next()) {
					wkId = rs.getString(1);
					wkPw = rs.getString(2);
				}

				conn_mysql.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (id.equals(wkId) && password.equals(wkPw)) {
				ShareVar.id = wkId;
				return true;
			} else {
				return false;
			}

		}
		
		
		 public int isNewUser() {
		      String query = "select count(*)"
		            + " from purchase"
		            + " where customer_customerid = " + ShareVar.id + " and now() between startdatetime and enddatetime;" ;
		      
		      int count = 0;
		      try {
		         Class.forName("com.mysql.cj.jdbc.Driver");
		         Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		         Statement stmt_mysql = conn_mysql.createStatement();
		         
		         ResultSet rs = stmt_mysql.executeQuery(query);
		         
		         if(rs.next()) {
		            count = rs.getInt(1);
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		      
		      return count;
		   }

			
}//END
