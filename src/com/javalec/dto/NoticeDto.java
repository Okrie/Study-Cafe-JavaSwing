package com.javalec.dto;

public class NoticeDto {
	// Field
	private int seq;
	private String title;
	private String contents;
	private int viewon;

	// Constructor
	public NoticeDto() {
		// TODO Auto-generated constructor stub
	}

	public NoticeDto(int seq, String title, String contents, int viewon) {
		super();
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.viewon = viewon;
	}

	
	
	
	
	

	public NoticeDto(int seq, String title, String contents) {
		super();
		this.seq = seq;
		this.title = title;
		this.contents = contents;
	}

	// Method
	
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getViewon() {
		return viewon;
	}

	public void setViewon(int viewon) {
		this.viewon = viewon;
	}
	
}
