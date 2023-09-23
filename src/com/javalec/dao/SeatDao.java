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

import com.javalec.dto.AdminDto;
import com.javalec.dto.ProductDto;
import com.javalec.dto.SeatDto;
import com.javalec.util.ShareVar;

public class SeatDao {
	
	//Field
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
	
	//constructor
	public SeatDao() {
		// TODO Auto-generated constructor stub
	}

	public SeatDao(String purchaseduration, String pricecategory, String productid, int timeprice) {
		super();
		this.purchaseduration = purchaseduration;
		this.pricecategory = pricecategory;
		this.productid = productid;
		this.timeprice = timeprice;
	}
	
	
	
	//Method
	public ArrayList<Integer> getSeatStatus() {

		ArrayList<Integer> SeatStatus = new ArrayList<>(); 
		String query = "select status from product where productid like 'Free%';" ;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				SeatStatus.add(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SeatStatus;
	}
	
	
	public ArrayList<SeatDto> getButtonData() {
	    ArrayList<SeatDto> dtoList = new ArrayList<SeatDto>();

	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT timeprice, SUBSTRING(pricecategory, LENGTH('Freetime') + 1) "
	    		+ "AS extracted_number FROM pricetable WHERE pricecategory LIKE 'Free%' ORDER BY timeprice";
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        stmt = conn_mysql.prepareStatement(query);
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            timeprice = rs.getInt("timeprice");
	            extractedNumber = rs.getString("extracted_number");
	            SeatDto SeatDto = new SeatDto(timeprice,extractedNumber);
	            dtoList.add(SeatDto);
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
	
	
	public SeatDto getDataByNumber(int number, String pricecategory) {
	    SeatDto SeatDto = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT SUBSTRING(pricetable.pricecategory, LENGTH('FreeTime') + 1), pricetable.timeprice";
	    String query1 = " FROM pricetable";
	    String query2 = " WHERE SUBSTRING(pricetable.pricecategory, LENGTH('FreeTime') + 1) = ?";
	    
//	    String query = "SELECT SUBSTRING(pricetable.pricecategory, LENGTH('FreeTime') + 1) AS subcategory, pricetable.timeprice";
//	    String query1 = " FROM pricetable";
//	    String query2 = " WHERE SUBSTRING(pricetable.pricecategory, LENGTH('FreeTime') + 1) = ?";
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        stmt = conn_mysql.prepareStatement(query + query1 + query2);
	        stmt.setInt(1, number);
	        rs = stmt.executeQuery();

	        if (rs.next()) {
	            String time = rs.getString(1);
	            int timeprice = rs.getInt(2);
	            SeatDto = new SeatDto(time, timeprice);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return SeatDto;
	}

	public ArrayList<SeatDto> selectList(){ 
		ArrayList<SeatDto> seatdtoList = new ArrayList<SeatDto>();
		String whereDefault = "SELECT pricecategory, timeprice";
	    String whereDefault1 = " FROM pricetable";
	    String orderBy = " ORDER BY CASE " +
	    	        "WHEN pricecategory LIKE '%Free%' THEN 1 " +
	    	        "WHEN pricecategory LIKE '%Fixed%' THEN 2 " +
	    	        "WHEN pricecategory LIKE '%Room%' THEN 3 " +
	    	        "WHEN pricecategory LIKE '%Cabinet%' THEN 4 " +
	    	        "ELSE 5 END";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); 
			stmt_mysql.execute("SET SESSION sql_mode=''");
			ResultSet rs = stmt_mysql.executeQuery(whereDefault+whereDefault1+orderBy);
			
			while(rs.next()) { 
				String pricecategory= rs.getString(1);
				int timeprice=rs.getInt(2);
				SeatDto dto = new SeatDto(pricecategory, timeprice);
				seatdtoList.add(dto);
			}
			} catch(Exception e) {
				e.printStackTrace();
			}
		return seatdtoList; //반드시 return을 넣어줘야한다. 나를 부른놈에게 dtoList를 주겠다는 의미를 가지고 있다.
	}
	
	public boolean isOnOffSeat(int i, String producti) {
		PreparedStatement ps = null;
		String whereDefault = "update product set status = ? where productid = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); 
			
			ps = conn_mysql.prepareStatement(whereDefault);
			ps.setInt(1, i);
			ps.setString(2, producti);
			
			ps.executeUpdate();
			conn_mysql.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public ArrayList<ProductDto> isOnSeat() {
		ArrayList<ProductDto> isOn = new ArrayList<ProductDto>();
		
		String whereDefault = "select * from product";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); 
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			
			while(rs.next()) {
				String wkProduct = rs.getString(1);
				int wkStatus = rs.getInt(2);
				
				ProductDto dto = new ProductDto(wkProduct, wkStatus);
				isOn.add(dto);
			}
			
			conn_mysql.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return isOn;
	}
	
	
	
	
	
	
	
	
	
	
}














