package com.ita.vo;

import java.io.Serializable;

public class UserBean implements Serializable{
	
	private static final long serialVersionUID=48L;
	
	private String name;
	private String address;
	private String phone;
	private String image;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	//全参
	public UserBean(String name, String address, String phone, String image) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.image = image;
	}
	
	//无参
	public UserBean(){
		
	}

	
}