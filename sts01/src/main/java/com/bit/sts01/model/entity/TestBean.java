package com.bit.sts01.model.entity;

public class TestBean {
	int sabun;
	String name;
	
	public TestBean() {
		// TODO Auto-generated constructor stub
	}

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TestBean [sabun=" + sabun + ", name=" + name + "]";
	}
	
	
}
