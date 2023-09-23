package com.javalec.dto;

public class AdminDto {
	// Field
	private String adminid;
	private String password;
	private String branchoffice;
	private int telnum;
	
	// Constructor
	public AdminDto() {
		// TODO Auto-generated constructor stub
	}

	public AdminDto(String adminid) {
		super();
		this.adminid = adminid;
	}

	
	
	// Method
	
	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBranchoffice() {
		return branchoffice;
	}

	public void setBranchoffice(String branchoffice) {
		this.branchoffice = branchoffice;
	}

	public int getTelnum() {
		return telnum;
	}

	public void setTelnum(int telnum) {
		this.telnum = telnum;
	}
}
