package com.sxt.dto;

public class Money {
	private int mid;
	private String mname;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Money(int mid, String mname) {
		super();
		this.mid = mid;
		this.mname = mname;
	}
	public Money() {
		super();
	}
	@Override
	public String toString() {
		return "Money [mid=" + mid + ", mname=" + mname + "]";
	}


}
