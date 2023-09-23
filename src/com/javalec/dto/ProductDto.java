package com.javalec.dto;

public class ProductDto {
	// Field
	private String productid;
	private int status;
	
	// Constructor
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}

	public ProductDto(String productid, int status) {
		super();
		this.productid = productid;
		this.status = status;
	}

	
	
	// Method 
	
	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
