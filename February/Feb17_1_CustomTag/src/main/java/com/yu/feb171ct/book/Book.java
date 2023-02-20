package com.yu.feb171ct.book;

import java.util.Date;

public class Book {
	private String title;
	private String authors;
	private Date date;
	private String price;
	private String thumbnail;

	public Book() {
	}

	public Book(String title, String authors, Date date, String price, String thumbnail) {
		super();
		this.title = title;
		this.authors = authors;
		this.date = date;
		this.price = price;
		this.thumbnail = thumbnail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
}
