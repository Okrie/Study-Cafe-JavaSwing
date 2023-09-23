package com.javalec.dto;

import java.sql.Timestamp;

public class SeatDto {

	
	// Field
		int customerid; // 고객 아이디
		int timeprice; // 자유석 시간별 가격
		int pprice; //고객이 구매한 물건의 가격을 저장 
		int startdatetime;
		int pnum; 
		int enddatetime;
		String productid; // 이게 지정석인지 자유석인지 스터디룸인지 캐비닛인지 
		String status; // 1이 사용가능, 0이 사용불가능.
		String priceCategory; // 자유석 시간제 구분
		String time;
		Timestamp startDateT;
		Timestamp endDateT;
		
		//constructor
		public SeatDto() {
			// TODO Auto-generated constructor stub
		}


		public SeatDto(String time, int timeprice) {
			super();
			this.timeprice = timeprice;
			this.time = time;
		}
		
		public SeatDto(int timeprice, String priceCategory) {
			super();
			this.timeprice = timeprice;
			this.priceCategory = priceCategory;
		}
		
		public SeatDto(int customerid, Timestamp startDateT, Timestamp endDateT, String productid, String status,
				String priceCategory) {
			super();
			this.customerid = customerid;
			this.startDateT = startDateT;
			this.endDateT = endDateT;
			this.productid = productid;
			this.status = status;
			this.priceCategory = priceCategory;
		}

		
		
		
		//getter and setter

		public int getCustomerid() {
			return customerid;
		}


		public void setCustomerid(int customerid) {
			this.customerid = customerid;
		}


		public int getTimeprice() {
			return timeprice;
		}


		public void setTimeprice(int timeprice) {
			this.timeprice = timeprice;
		}


		public int getPprice() {
			return pprice;
		}


		public void setPprice(int pprice) {
			this.pprice = pprice;
		}


		public int getStartdatetime() {
			return startdatetime;
		}


		public void setStartdatetime(int startdatetime) {
			this.startdatetime = startdatetime;
		}


		public int getPnum() {
			return pnum;
		}


		public void setPnum(int pnum) {
			this.pnum = pnum;
		}


		public int getEnddatetime() {
			return enddatetime;
		}


		public void setEnddatetime(int enddatetime) {
			this.enddatetime = enddatetime;
		}


		public String getProductid() {
			return productid;
		}


		public void setProductid(String productid) {
			this.productid = productid;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		public String getPriceCategory() {
			return priceCategory;
		}


		public void setPriceCategory(String priceCategory) {
			this.priceCategory = priceCategory;
		}


		public String gettime() {
			return time;
		}


		public void setTime(String time) {
			this.time = time;
		}


		public Timestamp getStartDateT() {
			return startDateT;
		}


		public void setStartDateT(Timestamp startDateT) {
			this.startDateT = startDateT;
		}


		public Timestamp getEndDateT() {
			return endDateT;
		}


		public void setEndDateT(Timestamp endDateT) {
			this.endDateT = endDateT;
		}
		
		
}
