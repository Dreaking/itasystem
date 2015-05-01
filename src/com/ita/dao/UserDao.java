package com.ita.dao;

import java.util.List;

import com.ita.model.User;

public interface UserDao{
	
	/**
	 * 根据标识属性加载User实例
	 * @param id 需要加载的User实例的标识属性值
	 * @return 指定标识属性对应的User实例
	 */
	User get(Integer id);
	
	/**
	 * 持久化指定的User实例
	 * @param user 需要被持久化的User实例
	 * @return User实例被持久化后的标识属性值
	 */
	Integer save(User user);
	
	/**
	 * 修改指定的User实例
	 * @param user 需要被修改的User实例
	 */
	void update(User user);
	
	/**
	 * 删除指定的User实例
	 * @param user 需要被删除的user实例
	 */
	void delete(User user);
	
	/**
	 * 根据标识属性删除User实例
	 * @param id 需要删除的user实例的标识属性
	 */
	void delete(Integer id);
	
	/**
	 * 查询全部的user实例
	 * @return 数据库中全部的user实例
	 */
	List<User> findAll();
	
	/**
	 * 根据用户邮箱(帐号)和密码查询用户
	 * @param user 包含指定邮箱(帐号)、密码的用户
	 * @return 符合指定邮箱(帐号)和密码的员工集合
	 */
	List<User> findByEmailAndPass(User user);
	
	/**
	 * 根据用户名称查询用户
	 * @param name 用户的名称
	 * @return 符合名称的用户
	 */
	User findByEmail(String email);
	
	
}