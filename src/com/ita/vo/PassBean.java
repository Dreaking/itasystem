package com.ita.vo;

import java.io.Serializable;

public class PassBean implements Serializable{
	
	private static final long serialVersionUID=48L;
	
	private String old;
	private String new1;
	private String new2;
	
	public String getOld() {
		return old;
	}
	public void setOld(String old) {
		this.old = old;
	}
	public String getNew1() {
		return new1;
	}
	public void setNew1(String new1) {
		this.new1 = new1;
	}
	public String getNew2() {
		return new2;
	}
	public void setNew2(String new2) {
		this.new2 = new2;
	}
	
	//全参
	public PassBean(String old, String new1, String new2) {
		super();
		this.old = old;
		this.new1 = new1;
		this.new2 = new2;
	}
	//无参
	public PassBean(){
		
	}
	
	
}