package com.ita.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class User implements Serializable{
	
	private static final long serialVersionUID=48L;
	//标识属性
	private Integer id;
	//用户名
	private String name;
	//用户密码
	private String pass;
	//用户电话
	private String phone;
	//用户地址
	private String address;
	//用户邮箱/帐号
	private String email;
	//头像
	private String image;
	//用户标记
	private Set<Location> locations = new HashSet<Location>();
	
	private Set<Memo> memos =new HashSet<Memo>();
	
	private Set<Protector> protectors =new HashSet<Protector>();
	
	//无参数构造器
	public User(){
	}

	
	



	public User(Integer id, String name, String pass, String phone,
			String address, String email, String image,
			Set<Location> locations, Set<Memo> memos, Set<Protector> protectors) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.image = image;
		this.locations = locations;
		this.memos = memos;
		this.protectors = protectors;
	}






	//location的getter和setter方法

	public Set<Location> getLocations() {
		return locations;
	}
	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}
	
	//memo的getter和setter方法
	public Set<Memo> getMemos() {
		return memos;
	}


	public void setMemos(Set<Memo> memos) {
		this.memos = memos;
	}


	//全部属性getter方法
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	
	//全部属性setter方法
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Set<Protector> getProtectors() {
		return protectors;
	}



	public void setProtectors(Set<Protector> protectors) {
		this.protectors = protectors;
	}


	//image的getter和setter
	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	
	
	//根据email、pass计算hashCode值
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		return result;
	}
	//重写equals()方法，只有email和pass相同的用户才认为相等
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pass=" + pass
				+ ", phone=" + phone + ", address=" + address + ", email="
				+ email + ", locations=" + locations + ", memos=" + memos
				+ ", protectors=" + protectors + "]";
	}






	
}