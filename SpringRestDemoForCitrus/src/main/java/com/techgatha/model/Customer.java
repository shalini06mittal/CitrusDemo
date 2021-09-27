package com.techgatha.model;

public class Customer {

	private int cid;
	private String name;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int cid, String name) {
		super();
		this.cid = cid;
		this.name = name;
	}

	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + "]";
	}
	
}
