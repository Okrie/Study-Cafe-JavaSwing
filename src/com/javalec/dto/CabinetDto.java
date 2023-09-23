package com.javalec.dto;

public class CabinetDto {
	
	String pricecategory;
	int timeprice;
	int calctime;
	
	public CabinetDto() {
		// TODO Auto-generated constructor stub
	}

	public CabinetDto(String pricecategory, int pprice, int calctime) {
		super();
		this.pricecategory = pricecategory;
		this.timeprice = pprice;
		this.calctime = calctime;
	}

	public String getPricecategory() {
		return pricecategory;
	}

	public void setPricecategory(String pricecategory) {
		this.pricecategory = pricecategory;
	}

	public int getTimeprice() {
		return timeprice;
	}

	public void setTimeprice(int pprice) {
		this.timeprice = timeprice;
	}

	public int getCalctime() {
		return calctime;
	}

	public void setCalctime(int calctime) {
		this.calctime = calctime;
	}
	
	

}
