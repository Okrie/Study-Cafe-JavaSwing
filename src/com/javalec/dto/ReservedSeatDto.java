package com.javalec.dto;

public class ReservedSeatDto {

	// Field
	int customerid; // 고객 아이디
	int timeprice; // 지정석 시간별 가격
	int pprice; //고객이 구매한 물건의 가격을 저장 (예 박지환 고객(customerid = 010-6608-3474)이, 지성석(productid=reservedSeat)을 골라서, 기간제(pricecategoryid=기간제)를 골라 2주짜리(timprice=2주)를 구매했을 때 저장하는 가격)
	int startdatetime; // 구매한 물건의 시작시간(구매와 동시에 생김)
	int pnum; //구매한 물건의 고유번호 (예 박지환 고객(customerid = 010-6608-3474)이, 지성석(productid=reservedSeat)을 골라서, 기간제(pricecategoryid=기간제)를 골라 2주짜리(timprice=2주)를 구매해서 생기는 번호 고유)
	int enddatetime; // 구매한 물건의 끝나는 시간
	String productid; // 이게 지정석인지 자유석인지 스터디룸인지 캐비닛인지 
	String status; // 물건이 지금 비어있는지 차있는지 상태
	String priceCategory; // 지정석의 시간종류(시간제, 기간권 중에 고름)
	// Constructor
	public ReservedSeatDto() {
		// TODO Auto-generated constructor stub
	}

	public ReservedSeatDto(int timeprice, String pricecategory) {
		super();
		this.timeprice = timeprice;
		this.priceCategory = pricecategory;
	}
	
	
	
	
	

	public ReservedSeatDto(String pricecategory, int timeprice) {
		super();
		this.priceCategory = pricecategory;
		this.timeprice = timeprice;
	}

	// Method
	public String getProductid() {
		return productid;
	}
	
	public void setProductid(String productid) {
		this.productid = productid;
	}
	
	public String getPriceCategory() {
		return priceCategory;
	}
	
	public void setPriceCategory(String priceCategory) {
		this.priceCategory = priceCategory;
	}
	
	public int getTimeprice() {
		return timeprice;
	}
	
	public void setTimeprice(int timeprice) {
		this.timeprice = timeprice;
	}
	

	
	
	
	
	
	
	
}
