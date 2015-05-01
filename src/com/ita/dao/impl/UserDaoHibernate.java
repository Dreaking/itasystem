package com.ita.dao.impl;

import java.util.List;

import com.ita.dao.UserDao;
import com.ita.model.User;
import com.ita.support.PlusHibernateDaoSupport;

public class UserDaoHibernate
	extends PlusHibernateDaoSupport
	implements UserDao{

	/**
	 * 根据标识属性加载User实例
	 */
	@Override
	public User get(Integer id) {
		return getHibernateTemplate().get(User.class, id);
	}
	
	/**
	 * 持久化指定的user实例
	 */
	@Override
	public Integer save(User user) {
		return (Integer)getHibernateTemplate().save(user);
	}

	/**
	 * 修改指定的user实例
	 */
	@Override
	public void update(User user) {
		getHibernateTemplate().update(user);		
	}
	
	/**
	 * 删除指定的user实例
	 */
	@Override
	public void delete(User user) {
		getHibernateTemplate().delete(user);		
	}

	/**
	 * 根据标识属性删除指定的user实例
	 */
	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
		
	}

	/**
	 * 查询全部的user实例
	 */
	@Override
	public List<User> findAll() {
		return (List<User>)getHibernateTemplate().find("from User");
	}

	/**
	 * 根据用户的邮箱（帐号）和密码查询用户
	 */
	@Override
	public List<User> findByEmailAndPass(User user) {
		return (List<User>)getHibernateTemplate().find("from User u where u.email = ? and u.pass = ?",user.getEmail(),user.getPass());
	}

	/**
	 * 根据用户的名称查询用户
	 */
	@Override
	public User findByEmail(String email) {
		List<User> users=(List<User>)getHibernateTemplate().find("from User u where u.email = ?",email);
		if (users!= null && users.size() >= 1)
		{
			return users.get(0);
		}
		return null;
	}
	
}