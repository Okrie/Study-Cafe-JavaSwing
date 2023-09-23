package com.javalec.dto;

import java.sql.Timestamp;

public class CustomerDto {
	
	// Field
	private int customerid;
	private int password;
	private Timestamp insertdate;
	private int session;
	
	
	// Constructor
	
	public CustomerDto() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerDto(int customerid) {
		super();
		this.customerid = customerid;
	}

	public CustomerDto(int customerid, int password, Timestamp insertdate, int session) {
		super();
		this.customerid = customerid;
		this.password = password;
		this.insertdate = insertdate;
		this.session = session;
	}

	// Methond
	
	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public Timestamp getInsertdate() {
		return insertdate;
	}

	public void setInsertdate(Timestamp insertdate) {
		this.insertdate = insertdate;
	}

	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		this.session = session;
	}
	
	
	
}
