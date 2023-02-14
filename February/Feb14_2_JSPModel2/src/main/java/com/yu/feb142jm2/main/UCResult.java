package com.yu.feb142jm2.main;

public class UCResult {
	private double num;
	private String unit1;
	private String what;
	private double result;
	private String unit2;

	public UCResult() {
	}

	public UCResult(double num, String unit1, String what, double result, String unit2) {
		super();
		this.num = num;
		this.unit1 = unit1;
		this.what = what;
		this.result = result;
		this.unit2 = unit2;
	}

	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}

	public String getUnit1() {
		return unit1;
	}

	public void setUnit1(String unit1) {
		this.unit1 = unit1;
	}

	public String getWhat() {
		return what;
	}

	public void setWhat(String what) {
		this.what = what;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public String getUnit2() {
		return unit2;
	}

	public void setUnit2(String unit2) {
		this.unit2 = unit2;
	}
}
