package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.ShareVar;

public class CheckoutDao {//퇴실할 때의 내용 상정 클래스
	
	private final String url_mysql = ShareVar.DBNAME;
	private final String id_mysql = ShareVar.DBUSER;
	private final String pw_mysql = ShareVar.DBPASS;
	
	//Field
	
	String customerid;
	String startdatetime;
	String enddatetime;
	int status;//product_status 입실:1, 퇴실:0
	
	//Constructor
	public CheckoutDao() {
		// TODO Auto-generated constructor stub
	}

	public CheckoutDao(String customerid, String startdatetime, String enddatetime, int status) {
		super();
		this.customerid = customerid;
		this.startdatetime = startdatetime;
		this.enddatetime = enddatetime;
		this.status = status;
	}
	
	
	
	public CheckoutDao(String customerid) {
		super();
		this.customerid = customerid;
	}

	//Method
	
	/*
	 * 퇴실은 기간제 사용자, 시간제 사용자로 구분이 되는데,
	 * 기간제 사용자의 경우 ifusinguser의 버튼 자체를 disabled하여 클릭자체를 하지못하도록 하며
	 * 시간제 사용자의 경우 ifusinguser의 버튼은 활성화가 되어있고,
	 * 1. 퇴실을 누르게 되면 product_status를 0으로 변경하게되고
	 * 2. endtime이 현재시간으로(function.TimeStampFlow)를 update 하도록 만들면 된다.
	 */
	
	
	//1. 퇴실을 누르게 되면 product_status를 0으로 변경
	public void updateStatus() {
	    PreparedStatement ps = null;
	   
	    String updateQuery = "UPDATE product SET status = 0 WHERE user_id = ?;";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        ps = conn_mysql.prepareStatement(updateQuery);
	        ps.setInt(1, Integer.parseInt(ShareVar.id));

	        ps.executeUpdate();

	        conn_mysql.close();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    
	}	
	
	
	
	//2. endtime이 현재시간으로(function.TimeStampFlow)를 update
	public void endtimeUpdate() {
		PreparedStatement ps = null;
		
		String whereDefault = "update purchase set endtime = now()";
		String whereDefault1= " where customerid = '" + ShareVar.id +"';";//DB다 작성되면 enditme update 되는지 확인 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); // schema 접근
			
			
			ps = conn_mysql.prepareStatement(whereDefault + whereDefault1);
		
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}	
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//end
