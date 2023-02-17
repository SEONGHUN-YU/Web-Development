package com.yu.feb171ct.weather;

public class Weather {
	private String hour;
	private String temp;
	private String wfKor;

	public Weather() {
	}

	public Weather(String hour, String temp, String wfKor) {
		super();
		this.hour = hour;
		this.temp = temp;
		this.wfKor = wfKor;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getWfKor() {
		return wfKor;
	}

	public void setWfKor(String wfKor) {
		this.wfKor = wfKor;
	}
}
