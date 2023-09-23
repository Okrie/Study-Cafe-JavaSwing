package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.javalec.user.Register;
import com.javalec.util.ShareVar;

public class RegisterDao {
	
	private final String url_mysql = ShareVar.DBNAME;
	private final String id_mysql = ShareVar.DBUSER;
	private final String pw_mysql = ShareVar.DBPASS;
	
	//Field
	String telno;
	String password;

	
	//constructor
	public RegisterDao() {
		// TODO Auto-generated constructor stub
	}


	public RegisterDao(String telno, String password) {
		super();
		this.telno = telno;
		this.password = password;
	}
	
	public boolean insertAction() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "insert into customer (customerid , password)";
			String query1 = " values (?, ?)";
			
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(1, telno.trim());
			ps.setString(2, password.trim());
		
			
			
			ps.executeUpdate();
			conn_mysql.close();
						
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//END
