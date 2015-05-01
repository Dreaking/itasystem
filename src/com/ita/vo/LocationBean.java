package com.ita.vo;

import java.io.Serializable;

public class LocationBean implements Serializable{
	
	private static final long serialVersionUID=48L;
	
	private String longitude;
	private String latitude;
	
	//无参数构造器
	public LocationBean(){	
	};

	//全参数构造器
	public LocationBean(String longitude, String latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}

	//longitude的getter和setter方法
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	//latitude的getter和setter方法
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	};
	
	//VO对象无需重写hashCode()方法和equals()方法
	
	
}