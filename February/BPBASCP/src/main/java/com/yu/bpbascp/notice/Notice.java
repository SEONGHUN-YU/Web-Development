package com.yu.bpbascp.notice;

import java.util.Date;

public class Notice {
	private int no;
	private String writerID;
	private String title;
	private String txt;
	private Date date;

	public Notice() {
	}

	public Notice(int no, String writerID, String title, String txt, Date date) {
		super();
		this.no = no;
		this.writerID = writerID;
		this.title = title;
		this.txt = txt;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriterID() {
		return writerID;
	}

	public void setWriterID(String writerID) {
		this.writerID = writerID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
