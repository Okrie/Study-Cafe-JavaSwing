package com.javalec.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.javalec.dto.ReservedSeatDto;
import com.javalec.util.ShareVar;

public class ReservedSeatDao {

	// Field
	int customerid;
	String pnum;
	int pprice;
	int startdatetime;
	int enddatetime;
	String purchaseduration;
	String pricecategory;
	String extractedNumber;
	String productid;
	String status;
	String week;
	int timeprice;
	int DataByNumber;
	private final String url_mysql = ShareVar.DBNAME;
	private final String id_mysql = ShareVar.DBUSER;
	private final String pw_mysql = ShareVar.DBPASS;
	
	
	// Constructor
	public ReservedSeatDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ReservedSeatDao(String productid, String pricecategory, String purchaseduration, int timeprice) {
		super();
		this.productid = productid;
		this.pricecategory = pricecategory;
		this.purchaseduration = purchaseduration;
		this.timeprice = timeprice;
	}
	
	
	
	
	
	
	
	
	// Method
	public ArrayList<Integer> getRsSeatStatus() {

		ArrayList<Integer> rsSeatStatus = new ArrayList<>(); 
		String query = "select status from product where productid like 'Fix%';" ;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				rsSeatStatus.add(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rsSeatStatus;
	}
	
	
	// 버튼이 어떤 녀석인지 알 수 있게 해준다.
	public ArrayList<ReservedSeatDto> getButtonData() {
	    ArrayList<ReservedSeatDto> dtoList = new ArrayList<ReservedSeatDto>();

	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT timeprice, SUBSTRING(pricecategory, LENGTH('FixedDate') + 1) AS extracted_number FROM pricetable WHERE pricecategory LIKE 'Fix%' ORDER BY timeprice";
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        stmt = conn_mysql.prepareStatement(query);
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            timeprice = rs.getInt("timeprice");
	            extractedNumber = rs.getString("extracted_number");
	            ReservedSeatDto reservedSeatDto = new ReservedSeatDto(timeprice,extractedNumber);
	            dtoList.add(reservedSeatDto);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return dtoList;
	}
	
	// 텍스트 필드에 값을 넣어줘야한다.
	/*
	public AdminDto tableClick() { // innerTable 안에 무언가를 눌렀을 때 작동하게 만드는 녀
		AdminDto dto = null; // 먼저 데이터를 비워놓고.
	    String whereDefault = "select photo, pcode, name, category, price, stock";
	    String whereDefault1 = " from product";
	    String whereDefault2 = " where pcode = '" + this.pcode+"'";
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        Statement stmt_mysql = conn_mysql.createStatement();

	        ResultSet rs = stmt_mysql.executeQuery(whereDefault + whereDefault1 + whereDefault2); // 쿼리문 합치기

	        if (rs.next()) {
	            String wkPcode = rs.getString(2);
	            String wkName = rs.getString(3);
	            String wkCategory = rs.getString(4);
	            int wkPrice = rs.getInt(5);
	            int wkPstock = rs.getInt(6);
	            ShareVar.filename += 1; //
				
	            File file = new File(Integer.toString(ShareVar.filename)); 
				FileOutputStream output = new FileOutputStream(file); 
				InputStream input = rs.getBinaryStream(1); 
				byte[] buffer = new byte[1024]; 
				while(input.read(buffer)>0) { 
					output.write(buffer);
	            dto = new AdminDto(wkPcode, wkName, wkCategory, wkPrice, wkPstock); // 데이터가 있을때 생성자를 만들어
	        }
	        conn_mysql.close();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	*/
	
	
	//
	public ReservedSeatDto getDataByNumber(int number, String pricecategory) {
	    ReservedSeatDto reservedSeatDto = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT SUBSTRING(pricetable.pricecategory, LENGTH('FixedDate') + 1), pricetable.timeprice";
	    String query1 = " FROM pricetable";
	    String query2 = " WHERE CAST(SUBSTRING(pricetable.pricecategory, LENGTH('FixedDate') + 1) AS UNSIGNED) DIV 7 = ?";
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        stmt = conn_mysql.prepareStatement(query + query1 + query2);
	        stmt.setInt(1, number);
	        rs = stmt.executeQuery();

	        if (rs.next()) {
	            String week = rs.getString(1);
	            int timeprice = rs.getInt(2);
	            reservedSeatDto = new ReservedSeatDto(week, timeprice);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return reservedSeatDto;
	}
	
	
	public ArrayList<Integer> getFixedSeat() {

		ArrayList<Integer> rsSeatStatus = new ArrayList<>(); 
		String query = "select status from product where productid like 'Fix%';" ;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				rsSeatStatus.add(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rsSeatStatus;
	}
	
	
	
	
	
	
	
	
	
	
	
}
