package com.yu.bpbascp.notice;

import java.util.Date;

public class NoticeReply {
	private int no;
	private int bnNo;
	private String writer;
	private String txt;
	private Date date;

	public NoticeReply() {
	}

	public NoticeReply(int no, int bnNo, String writer, String txt, Date date) {
		super();
		this.no = no;
		this.bnNo = bnNo;
		this.writer = writer;
		this.txt = txt;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getBnNo() {
		return bnNo;
	}

	public void setBnNo(int bnNo) {
		this.bnNo = bnNo;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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
