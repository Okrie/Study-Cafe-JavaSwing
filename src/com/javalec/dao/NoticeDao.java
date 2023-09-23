package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.javalec.dto.NoticeDto;
import com.javalec.util.ShareVar;

public class NoticeDao {
	// Field
	private String title;
	private String contents;
	private int viewon;
	
	
	// DB 연결을 위한 세팅
	private final String url_mysql = ShareVar.DBNAME;
	private final String id_mysql = ShareVar.DBUSER;
	private final String pw_mysql = ShareVar.DBPASS;

	
	
	
	// Constructor
	public NoticeDao() {
		// TODO Auto-generated constructor stub
	}

	public NoticeDao(String title, String contents, int viewon) {
		super();
		this.title = title;
		this.contents = contents;
		this.viewon = viewon;
	}
	
	

	// Method
	
	// 공지 등록하기
	public boolean insertAction() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "insert into notice (title , contents, registertime, viewon, admin_adminid)";
			String query1 = " values (?, ?, now(), ?, 'admin') ";
			
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(1, title);
			ps.setString(2, contents);
			ps.setInt(3, viewon);			
			
			ps.executeUpdate();
			conn_mysql.close();
						
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	// seq로 접근
	public ArrayList<NoticeDto> searchList(int seq){
		ArrayList<NoticeDto> dtoList = new ArrayList<NoticeDto>();
		
		String whereDefault = "select seq, title, contents, viewon from notice where seq = '" + seq + "';";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); // schema 접근
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			if(rs.next()) {
				int wkSeq = rs.getInt(1);
				String wkTitle = rs.getString(2);
				String wkContents = rs.getString(3);
				int wkViewon = rs.getInt(4);
				
				NoticeDto dto = new NoticeDto(wkSeq, wkTitle, wkContents, wkViewon);
				dtoList.add(dto);
			}
			
			conn_mysql.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	// 공지로 등록 유무 0을 받아 오면 내리고 1을 받아 오면 올린다.
	public boolean viewOnAnno(int i, int seq) {
		PreparedStatement ps = null;
		String whereDefault = "update notice set viewon = ? where seq = '" + seq + "';";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); 
			
			ps = conn_mysql.prepareStatement(whereDefault);
			ps.setInt(1, i);
			
			ps.executeUpdate();
			conn_mysql.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	// 노출된 공지만 접근
	public ArrayList<NoticeDto> viewList(){
		ArrayList<NoticeDto> dtoList = new ArrayList<NoticeDto>();
		
		String whereDefault = "select seq, title, contents, viewon from notice where viewon = 1;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); // schema 접근
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			while(rs.next()) {
				int wkSeq = rs.getInt(1);
				String wkTitle = rs.getString(2);
				String wkContents = rs.getString(3);
				int wkViewon = rs.getInt(4);
				
				NoticeDto dto = new NoticeDto(wkSeq, wkTitle, wkContents, wkViewon);
				dtoList.add(dto);
			}
			
			
			conn_mysql.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(reverseList(dtoList), new NoticeComparator());
		return dtoList;
	}
	
	public NoticeDto tableClick(int wkSeqno) {
		NoticeDto dto = null;
	
		String whereDefault = "select seq, title, contents from notice";
		String whereDefault1 = " where seq =" + wkSeqno;
		System.out.println(wkSeqno);
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(whereDefault + whereDefault1);
			
			if(rs.next()) {
				int wkSeq = rs.getInt(1);
				String wktitle = rs.getString(2);
				String wkcontents = rs.getString(3);
				
				
				dto = new NoticeDto(wkSeq, wktitle, wkcontents);
			}

			conn_mysql.close();
						
		}catch(Exception e) {
			e.printStackTrace();
		}

		return dto;

	}
	
	public ArrayList<NoticeDto> selectList(){
		ArrayList<NoticeDto> dtoList = new ArrayList<NoticeDto>();
		
		String whereDefault = "select seq, title, contents, viewon from notice;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); // schema 접근
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			while(rs.next()) {
				int wkSeq = rs.getInt(1);
				String wkTitle = rs.getString(2);
				String wkContents = rs.getString(3);
				int wkViewon = rs.getInt(4);
				
				NoticeDto dto = new NoticeDto(wkSeq, wkTitle, wkContents, wkViewon);
				dtoList.add(dto);
			}
			
			
			conn_mysql.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(reverseList(dtoList), new NoticeComparator());
		return dtoList;
	}
	
	// 데이터 역순으로 노출하기
	private ArrayList<NoticeDto> reverseList(ArrayList<NoticeDto> list){
		Comparator<NoticeDto> reverseList = Collections.reverseOrder(
				Comparator.comparingInt(NoticeDto::getViewon));
		Collections.sort(list, reverseList);
		return list;
	}
	
	
}

class NoticeComparator implements Comparator<NoticeDto>{
	@Override
	public int compare(NoticeDto a, NoticeDto b) {
		if(a.getViewon() < b.getViewon()) return 1;
		if(a.getViewon() > b.getViewon()) return -1;
		if(a.getViewon() == b.getViewon() && a.getSeq() < b.getSeq()) return 1;
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//END