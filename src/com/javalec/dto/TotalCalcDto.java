package com.javalec.dto;

import java.sql.Timestamp;

public class TotalCalcDto {
	Timestamp date;
	int totalPrice;
	String day;
	
	public TotalCalcDto(Timestamp date, int totalPrice) {
		super();
		this.date = date;
		this.totalPrice = totalPrice;
	}
	
	public TotalCalcDto(int totalPrice, String day) {
		super();
		this.totalPrice = totalPrice;
		this.day = day;
	}



	public Timestamp getDate() {
		return date;
	}



	public void setDate(Timestamp date) {
		this.date = date;
	}



	public int getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}



	public String getDay() {
		return day;
	}



	public void setDay(String day) {
		this.day = day;
	}



}
