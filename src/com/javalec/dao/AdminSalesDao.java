package com.javalec.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.javalec.dto.ProductDto;
import com.javalec.dto.PurchaseDto;
import com.javalec.dto.TotalCalcDto;
import com.javalec.util.ShareVar;


// 관리자 화면 내 노출되는 테이블에 대한 내용을 주고 받는데 주로 씀
public class AdminSalesDao {
	// Field
	
	// DB 연결을 위한 세팅
	private final String url_mysql = ShareVar.DBNAME;
	private final String id_mysql = ShareVar.DBUSER;
	private final String pw_mysql = ShareVar.DBPASS;
	
	String conditionQueryColumn;
	String tfQueryGet;
	
	
	// Constructor
	public AdminSalesDao() {
		// TODO Auto-generated constructor stub
	}

	public AdminSalesDao(String conditionQueryColumn, String tfQueryGet) {
		super();
		this.conditionQueryColumn = conditionQueryColumn;
		this.tfQueryGet = tfQueryGet;
	}


	// Method
	
	// 일별 구매 합산
	public ArrayList<TotalCalcDto> selectList(){
		ArrayList<TotalCalcDto> dateList = new ArrayList<TotalCalcDto>();
		
		String whereDefault = "select DATE_FORMAT(startdatetime, '%Y-%m-%d'), sum(pprice) from purchase group by DATE_FORMAT(startdatetime, '%Y-%m-%d')";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); // schema 접근
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			while(rs.next()) {
				Timestamp wkDate = rs.getTimestamp(1);
				int wkTotalPrice = rs.getInt(2);
				
				TotalCalcDto calcDto = new TotalCalcDto(wkDate, wkTotalPrice);
				dateList.add(calcDto);
			}
			
			conn_mysql.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dateList;
	}
	
	// 주간별 구매 합산
	public ArrayList<TotalCalcDto> selectWeekList(){
		ArrayList<TotalCalcDto> dateList = new ArrayList<TotalCalcDto>();
		
		String whereDefault = "select YEARWEEK(startdatetime), sum(pprice) from purchase group by YEARWEEK(startdatetime)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); // schema 접근
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			while(rs.next()) {
				String wkDay = rs.getString(1);
				int wkTotalPrice = rs.getInt(2);
				TotalCalcDto calcDto = new TotalCalcDto(wkTotalPrice, changeDayName(wkDay));
				dateList.add(calcDto);
			}
			
			conn_mysql.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dateList;
	}
	
	// 월별 구매 합산
	public ArrayList<TotalCalcDto> selectMonthList(){
		ArrayList<TotalCalcDto> dateList = new ArrayList<TotalCalcDto>();
		
		String whereDefault = "select EXTRACT(YEAR_MONTH FROM startdatetime), sum(pprice) from purchase group by EXTRACT(YEAR_MONTH FROM startdatetime)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); // schema 접근
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			while(rs.next()) {
				String wkDay = rs.getString(1);
				int wkTotalPrice = rs.getInt(2);
				TotalCalcDto calcDto = new TotalCalcDto(wkTotalPrice, changeDayName(wkDay));
				dateList.add(calcDto);
			}
			
			conn_mysql.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dateList;
	}
	
	// 요일별 구매 합산
	public ArrayList<TotalCalcDto> selectDayList(){
		ArrayList<TotalCalcDto> dateList = new ArrayList<TotalCalcDto>();
		
		String whereDefault = "select DAYNAME(startdatetime), sum(pprice) from purchase group by DAYNAME(startdatetime)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); // schema 접근
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			while(rs.next()) {
				String wkDay = rs.getString(1);
				int wkTotalPrice = rs.getInt(2);
				TotalCalcDto calcDto = new TotalCalcDto(wkTotalPrice, changeDayName(wkDay));
				dateList.add(calcDto);
			}
			
			conn_mysql.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dateList;
	}
	
	public String changeDayName(String day) {
		switch (day) {
		case "Monday":
			return "월요일";
		case "Tuesday":
			return "화요일";
		case "Wednesday":
			return "수요일";
		case "Thursday":
			return "목요일";
		case "Friday":
			return "금요일";
		case "Saturday":
			return "토요일";
		case "Sunday":
			return "일요일";
		default:
			return "오류";
		}
	}
}
