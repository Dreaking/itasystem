package com.ita.model;

import java.io.Serializable;

public class Location implements Serializable{
	
	public static final long serialVersionUID=48L;
	//标识属性
	private Integer id;
	//经度
	private String longitude;
	//纬度
	private String latitude;
	//作标记的用户
	private User user;
	
	//无参数构造器
	public Location(){
	}
	//全部参数构造器
	public Location(Integer id, String longitude, String latitude, User user) {
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.user = user;
	}
	
	//id属性的getter和setter方法
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	//longitude属性的getter和setter方法
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	//latitude属性的getter和setter方法
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	//user属性的getter和setter方法
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	//因为是地标，无需重写equals()和hashCode();
	
}