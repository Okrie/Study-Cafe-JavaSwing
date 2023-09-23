package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.javalec.dto.CustomerDto;
import com.javalec.util.ShareVar;

public class UserDao {
	int customerid;
	
	// DB 연결을 위한 세팅
	private final String url_mysql = ShareVar.DBNAME;
	private final String id_mysql = ShareVar.DBUSER;
	private final String pw_mysql = ShareVar.DBPASS;
	
	
	public UserDao() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDao(int customerid) {
		super();
		this.customerid = customerid;
	}



	public boolean delUser() {
		PreparedStatement ps = null;
		String whereDefault = "update customer set session = ? where customerid = '" + customerid + "';";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); 
			
			ps = conn_mysql.prepareStatement(whereDefault);
			ps.setInt(1, 1);
			
			ps.executeUpdate();
			conn_mysql.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// 유저 정보만 검색
	public ArrayList<CustomerDto> selectUser(){
		ArrayList<CustomerDto> dtoList = new ArrayList<CustomerDto>();
		String query = "select * from customer where customerid ='" + customerid + "';";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			if(rs.next()) {
				int wkCustomerid = rs.getInt(1);
				int wkPassword = rs.getInt(2);
				Timestamp wkInsertDate = rs.getTimestamp(3);
				int wkSession = rs.getInt(4);
				
				CustomerDto cDto = new CustomerDto(wkCustomerid, wkPassword, wkInsertDate, wkSession);
				dtoList.add(cDto); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
}
