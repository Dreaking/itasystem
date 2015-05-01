package com.ita.model;

import java.io.Serializable;

public class Memo implements Serializable{
	
	public static final long serialVersionUID=48L;
	
	private Integer id;
	private String appid;
	private String title;
	private String time;
	private String place;
	private String thing;
	private int syn;
	private User user;
	
	//无参构造器
	public Memo(){
		
	}

	//全参构造器


	public Memo(Integer id, String appid, String title, String time,
			String place, String thing, int syn, User user) {
		super();
		this.id = id;
		this.appid = appid;
		this.title = title;
		this.time = time;
		this.place = place;
		this.thing = thing;
		this.syn = syn;
		this.user = user;
	}
	
	
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public int getSyn() {
		return syn;
	}

	public void setSyn(int syn) {
		this.syn = syn;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}	
	
}