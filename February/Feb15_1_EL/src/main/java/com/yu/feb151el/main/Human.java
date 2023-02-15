package com.yu.feb151el.main;

public class Human {
	private String name;
	private int birth;

	public Human() {
	}

	public Human(String name, int birth) {
		super();
		this.name = name;
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}
}
