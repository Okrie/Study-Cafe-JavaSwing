package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.javalec.dto.PurchaseDto;
import com.javalec.dto.SeatDto;
import com.javalec.util.ShareVar;


// 관리자 화면 내 노출되는 테이블에 대한 내용을 주고 받는데 주로 씀
public class AdminDao {
	// Field
	
	// DB 연결을 위한 세팅
	private final String url_mysql = ShareVar.DBNAME;
	private final String id_mysql = ShareVar.DBUSER;
	private final String pw_mysql = ShareVar.DBPASS;
	
	String conditionQueryColumn;
	String tfQueryGet;
	
	
	// Constructor
	public AdminDao() {
		// TODO Auto-generated constructor stub
	}

	public AdminDao(String conditionQueryColumn, String tfQueryGet) {
		super();
		this.conditionQueryColumn = conditionQueryColumn;
		this.tfQueryGet = tfQueryGet;
	}


	// Method
	
	// 현재 입실한 유저의 Seq생성? pnum 사용으로 대체
	
	// 현재 입실한 유저의 사용자 넘버, 입실시간, 종료 시간, 남은시간 가져와야 함 = 최근 구매한 유저의 기록
	public ArrayList<PurchaseDto> selectList(){
		ArrayList<PurchaseDto> dtoList = new ArrayList<PurchaseDto>();
		
		String whereDefault = "select pnum, customer_customerid, startdatetime, enddatetime from purchase";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); // schema 접근
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			while(rs.next()) {
				int wkPnum = rs.getInt(1);
				int wkCustomerId = rs.getInt(2);
				Timestamp wkStartdateTime = rs.getTimestamp(3);
				Timestamp wkEnddateTime = rs.getTimestamp(4);
				
				PurchaseDto dto = new PurchaseDto(wkPnum, wkCustomerId, wkStartdateTime, wkEnddateTime);
				dtoList.add(dto);
			}
			
			
			conn_mysql.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return reverseList(dtoList);
	}
	
	// 현재 입실한 유저의 정보를 역순으로 노출 해야 함
	private ArrayList<PurchaseDto> reverseList(ArrayList<PurchaseDto> list){
//		ArrayList<PurchaseDto> list = new ArrayList<PurchaseDto>();
		Comparator<PurchaseDto> reverseList = Collections.reverseOrder(
				Comparator.comparingInt(PurchaseDto::getPnum));
		Collections.sort(list, reverseList);
		return list;
	}
	
	// 실시간으로 ? 는 우선순위 최하
	
	// 현재 이용자, 비어 있는 자리, 사물함 이용, 사물함 남은 개수
	public ArrayList<Integer> selectSeat() {
		ArrayList<Integer> isUse = new ArrayList<Integer>();
		int emptyCount = 0;
		int emptyCabiCount = 0;
		int count = 0;
		int cabiCount = 0;
		
		String whereDefault = "select * from product";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); // schema 접근
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			
			while(rs.next()) {
				String wkProductid = rs.getString(1);
				int wkStatus = rs.getInt(2);
				
				if(wkProductid.contains("Cabi") && wkStatus == 1 ) {
					cabiCount++;
				} else if(wkProductid.contains("Cabi") && wkStatus == 0){
					emptyCabiCount++;
				} else if(wkStatus == 1){
					count++;
				} else {
					emptyCount++;
				}
			}
			
			isUse.add(count);			// 첫번째는 사용중인 자리
			isUse.add(emptyCount);		// 두번째는 빈자리
			isUse.add(cabiCount);		// 세번째 사물함 사용중
			isUse.add(emptyCabiCount);	// 네번째 사물함 빈자리 
			
			conn_mysql.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return isUse;
	}
	
	// 좌석 및 사용자 정보를 받아 오기 위함
	public ArrayList<SeatDto> selectSeat(String condition, String conndata, int isInfo) {
		String conn = condition;
		String conda = conndata;
		ArrayList<SeatDto> dtoList = new ArrayList<SeatDto>();
		
		String whereDefault1 = "select c.customerid, p.productid, pu.startdatetime, pu.enddatetime, pr.pricecategory, p.status from product p";
		String whereDefault2 = " left join purchase pu on p.productid = pu.product_productid left join customer c on c.customerid = pu.customer_customerid left join pricetable pr on pr.pricecategory = pu.pricetable_pricecategory";
		String whereDefault3 = " where " + conn + " = '" + conda + "';";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); // schema 접근
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault1 + whereDefault2 + whereDefault3);
			
			while(rs.next()) {
				// 좌석 넘버
				String wkProductid = rs.getString(2);
				// 사용자
				int wkCustomerid = rs.getInt(1);
				// 이용 시작 시간
				Timestamp wkStartdate = rs.getTimestamp(3);
				// 종료 시간
				Timestamp wkEnddate = rs.getTimestamp(4);
				// 이용권
				String wkPriceCate = rs.getString(5);
				// 자리 상태
				int wkSeat = rs.getInt(6);
				
				SeatDto seatDto = new SeatDto(wkCustomerid, wkStartdate, wkEnddate, wkProductid, Integer.toString(wkSeat), wkPriceCate);
				dtoList.add(seatDto);
				
			}
			conn_mysql.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return dtoList;
	}
	
	// 컬럼 검색
	public ArrayList<PurchaseDto> selectOrder(String condition, String conndata, int isInfo) {
		String conn = condition;
		String conda = conndata;
		ArrayList<PurchaseDto> dtoList = new ArrayList<PurchaseDto>();
		
		String whereDefault1 = "select distinct c.customerid, p.productid, pu.startdatetime, pu.enddatetime, pr.pricecategory";
		String whereDefault2 = " from purchase pu, product p, customer c, pricetable pr";
		String whereDefault3 = " where p.productid = pu.product_productid and c.customerid = pu.customer_customerid and pr.pricecategory = pu.pricetable_pricecategory and " + conn + " like '%" + conda + "%';";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); // schema 접근
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault1 + whereDefault2 + whereDefault3);
			
			while(rs.next()) {
				// 좌석 넘버
				String wkProductid = rs.getString(2);
				// 사용자
				int wkCustomerid = rs.getInt(1);
				// 이용 시작 시간
				Timestamp wkStartdate = rs.getTimestamp(3);
				// 종료 시간
				Timestamp wkEnddate = rs.getTimestamp(4);
				// 이용권
				String wkPriceCate = rs.getString(5);
				
				PurchaseDto purDto = new PurchaseDto(wkProductid, wkCustomerid, wkStartdate, wkEnddate, wkPriceCate);
				dtoList.add(purDto);
				
			}
			conn_mysql.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return dtoList;
	}
	
	
	// 선택한 유저의 정보를 불러오기 위함
	public ArrayList<PurchaseDto> selectUser(int customerid) {
		
		ArrayList<PurchaseDto> dtoList = new ArrayList<PurchaseDto>();
		
		String whereDefault1 = "select distinct c.customerid, p.productid, pu.enddatetime, pu.pprice";
		String whereDefault2 = " from purchase pu, product p, customer c";
		String whereDefault3 = " where c.customerid = pu.customer_customerid and p.productid = pu.product_productid and c.customerid = " + customerid;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault1 + whereDefault2 + whereDefault3);

			while(rs.next()) {
				// 좌석 넘버
				String wkProductid = rs.getString(2);
				// 사용자
				int wkCustomerid = rs.getInt(1);
				// 종료 시간
				Timestamp wkEnddate = rs.getTimestamp(3);
				// 금액
				int wkPrice = rs.getInt(4);
				
				PurchaseDto purDto = new PurchaseDto(wkProductid, wkCustomerid, wkEnddate, wkPrice);
				
				dtoList.add(purDto);
			}
			conn_mysql.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return dtoList;
	}
	
	// 선택한 유저의 구매 정보를 불러오기 위함
	public ArrayList<PurchaseDto> selectUserTable(int customerid) {
		
		ArrayList<PurchaseDto> dtoList = new ArrayList<PurchaseDto>();
		
		String whereDefault1 = "select p.productid, pu.enddatetime, pu.pprice, pr.pricecategory";
		String whereDefault2 = " from purchase pu, product p, customer c, pricetable pr";
		String whereDefault3 = " where c.customerid = pu.customer_customerid and p.productid = pu.product_productid and c.customerid = " + customerid;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault1 + whereDefault2 + whereDefault3);

			while(rs.next()) {
				// 좌석 넘버
				String wkProductid = rs.getString(1);
				// 종료 시간
				Timestamp wkEnddate = rs.getTimestamp(2);
				// 금액
				int wkPrice = rs.getInt(3);
				// 금액권
				String wkCategory = rs.getString(4);
				
				PurchaseDto purDto = new PurchaseDto(wkProductid, wkEnddate, wkPrice, wkCategory);
				
				dtoList.add(purDto);
			}
			conn_mysql.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return dtoList;
	}
	
	// 유저 정보를 가져옴
	public ArrayList<PurchaseDto> searchUserTable() {
		
		ArrayList<PurchaseDto> dtoList = new ArrayList<PurchaseDto>();
		
		String whereDefault1 = "select distinct c.customerid, MAX(p.productid), MAX(pu.enddatetime)";
		String whereDefault2 = " from purchase pu, product p, customer c where c.customerid = pu.customer_customerid and p.productid = pu.product_productid group by c.customerid";
//		String whereDefault2 = " from purchase pu JOIN product p ON p.productid = pu.product_productid JOIN customer c ON c.customerid = pu.customer_customerid;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); // schema 접근
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault1 + whereDefault2);

			while(rs.next()) {
				// 좌석 넘버
				String wkProductid = rs.getString(2);
				// 사용자
				int wkCustomerid = rs.getInt(1);
				// 종료 시간
				Timestamp wkEnddate = rs.getTimestamp(3);
				
				PurchaseDto purDto = new PurchaseDto(wkProductid, wkCustomerid, wkEnddate);
				
				dtoList.add(purDto);
			}
			conn_mysql.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return dtoList;
	}
	
}
