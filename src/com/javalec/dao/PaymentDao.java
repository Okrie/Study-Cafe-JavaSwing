package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.util.ShareVar;

public class PaymentDao {
	
	private final String url_mysql = ShareVar.DBNAME;
	private final String id_mysql = ShareVar.DBUSER;
	private final String pw_mysql = ShareVar.DBPASS;

	String productid;		// product table의 pk
	int customerid;			// customer table의 pk
	String startdatetime;
	String enddatetime;
	int pprice;
	String pricecategory;
	
	public PaymentDao() {
		// TODO Auto-generated constructor stub
	}

	public PaymentDao(String productid, int customerid, int pprice,	String pricecategory) {
		super();
		this.productid = productid;
		this.customerid = customerid;
		this.pprice = pprice;
		this.pricecategory = pricecategory;
	}

	



	public PaymentDao(String productid, int customerid) { // 좌석Status 업데이트 시 정보 넘겨줄 포맷.
		super();
		this.productid = productid;
		this.customerid = customerid;
	}

	public Boolean insertOrder() { // 결제정보 DB 입력
		PreparedStatement ps = null;
		
		try {
			// DB 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String query = "insert into purchase (product_productid, customer_customerid, startdatetime, enddatetime, pprice, pricetable_pricecategory)";
			String query1 = " values (?, ?, now(), date_add(now(), interval ? hour), ?, ?)";
			
			ps = conn_mysql.prepareStatement(query + query1);
			
			ps.setString(1, productid);
			ps.setInt(2, customerid);
			ps.setInt(3, getCalcTime());
			ps.setInt(4, pprice);
			ps.setString(5, pricecategory);
			
			ps.executeUpdate();
			conn_mysql.close();
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public int getCalcTime() {

		String query = "select calctime from pricetable where pricecategory = '" + ShareVar.priceCategory + "';" ;
		int calctime = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			if(rs.next()) {
				calctime = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return calctime;
	}
	
	public void updateStatus() {
		PreparedStatement ps = null;
		
		try {
			// DB 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String query = "update product set status = 0 where productid = '" + productid + "';";
			
			ps = conn_mysql.prepareStatement(query);
			
			ps.executeUpdate();
			conn_mysql.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
} // End