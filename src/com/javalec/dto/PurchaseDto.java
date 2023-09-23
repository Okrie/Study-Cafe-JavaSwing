package com.javalec.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class PurchaseDto {
	// Field
	private int pnum;
	private String product_productid;
	private int customer_customerid;
	private Timestamp startdatetime;
	private Timestamp enddatetime;
	private int pprice;
	private String pricetable_pricecategory;
	
	
	// Constructor
	public PurchaseDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public PurchaseDto(String product_productid, Timestamp enddatetime, int pprice, String pricetable_pricecategory) {
		super();
		this.product_productid = product_productid;
		this.enddatetime = enddatetime;
		this.pprice = pprice;
		this.pricetable_pricecategory = pricetable_pricecategory;
	}



	public PurchaseDto(String product_productid, int customer_customerid, Timestamp enddatetime) {
		super();
		this.product_productid = product_productid;
		this.customer_customerid = customer_customerid;
		this.enddatetime = enddatetime;
	}

	public PurchaseDto(String product_productid, int customer_customerid, Timestamp enddatetime, int pprice) {
		super();
		this.product_productid = product_productid;
		this.customer_customerid = customer_customerid;
		this.enddatetime = enddatetime;
		this.pprice = pprice;
	}

	public PurchaseDto(int pnum, int customer_customerid, Timestamp startdatetime, Timestamp enddatetime) {
		super();
		this.pnum = pnum;
		this.customer_customerid = customer_customerid;
		this.startdatetime = startdatetime;
		this.enddatetime = enddatetime;
	}

	public PurchaseDto(String product_productid, int customer_customerid, Timestamp startdatetime, Timestamp enddatetime,
			String pricetable_pricecategory) {
		super();
		this.product_productid = product_productid;
		this.customer_customerid = customer_customerid;
		this.startdatetime = startdatetime;
		this.enddatetime = enddatetime;
		this.pricetable_pricecategory = pricetable_pricecategory;
	}
	
	

	// Method
	public int getPnum() {
		return pnum;
	}


	public void setPnum(int pnum) {
		this.pnum = pnum;
	}


	public String getProduct_productid() {
		return product_productid;
	}


	public void setProduct_productid(String product_productid) {
		this.product_productid = product_productid;
	}


	public int getCustomer_customerid() {
		return customer_customerid;
	}


	public void setCustomer_customerid(int customer_customerid) {
		this.customer_customerid = customer_customerid;
	}


	public Timestamp getStartdatetime() {
		return startdatetime;
	}


	public void setStartdatetime(Timestamp startdatetime) {
		this.startdatetime = startdatetime;
	}


	public Timestamp getEnddatetime() {
		return enddatetime;
	}


	public void setEnddatetime(Timestamp enddatetime) {
		this.enddatetime = enddatetime;
	}


	public int getPprice() {
		return pprice;
	}


	public void setPprice(int pprice) {
		this.pprice = pprice;
	}


	public String getPricetable_pricecategory() {
		return pricetable_pricecategory;
	}


	public void setPricetable_pricecategory(String pricetable_pricecategory) {
		this.pricetable_pricecategory = pricetable_pricecategory;
	}
}
