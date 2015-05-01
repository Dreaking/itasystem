package com.ita.vo;

import java.io.Serializable;


public class MemoBean implements Serializable{
	
	private static final long serialVersionUID=48L;
	
	private Integer id;
	private String appid;
	private String place;
	private String thing;
	private String time;
	private int syn;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
	private String title;
	
	//无参构造器
	public MemoBean(){
		
	};
	
	//全参构造器
	

	public MemoBean(Integer id, String appid, String place, String thing,
			String time, int syn, String title) {
		super();
		this.id = id;
		this.appid = appid;
		this.place = place;
		this.thing = thing;
		this.time = time;
		this.syn = syn;
		this.title = title;
	}
	
	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}
	public String getThing() {
		return thing;
	}
	public void setThing(String thing) {
		this.thing = thing;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getSyn() {
		return syn;
	}

	public void setSyn(int syn) {
		this.syn = syn;
	}
	//无需重写hashCode() 和 equal() 方法
}