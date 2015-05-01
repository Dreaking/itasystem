package com.ita.model;

import java.io.Serializable;

public class Protector implements Serializable{
	
	private static final long serialVersionUID=48L;
	
	private Integer id;
	private String phone;
	private String name;
	private User user;
	
	//无参
	public Protector(){
		
	}
	//全参
	public Protector(Integer id, String phone, String name, User user) {
		this.id = id;
		this.phone = phone;
		this.name = name;
		this.user = user;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	
	
}