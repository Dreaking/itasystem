package com.ita.dao.impl;

import java.util.List;

import com.ita.dao.LocationDao;
import com.ita.model.Location;
import com.ita.model.User;
import com.ita.support.PlusHibernateDaoSupport;

public class LocationDaoHibernate
	extends PlusHibernateDaoSupport
	implements LocationDao{

	/**
	 * 根据标识属性加载location实例
	 */
	@Override
	public Location get(Integer id) {
		// TODO Auto-generated method stub
		return (Location)getHibernateTemplate().get(Location.class, id);
	}

	/**
	 * 持久化指定的location实例
	 */
	@Override
	public Integer save(Location location) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(location);
	}

	/**
	 * 修改指定的location实例
	 */
	@Override
	public void update(Location location) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(location);
	}

	/**
	 * 删除指定的location实例
	 */
	@Override
	public void delete(Location location) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(location);
	}

	/**
	 * 根据标识属性删除location实例
	 */
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * 查询全部的location实例
	 */
	@Override
	public List<Location> findAll() {
		// TODO Auto-generated method stub
		return (List<Location>)getHibernateTemplate().find("from Location");
	}

	/**
	 * 根据用户查询location实例
	 */
	@Override
	public List<Location> findByUser(User user) {
		// TODO Auto-generated method stub
		return (List<Location>)getHibernateTemplate().find("from Location as l where l.user = ?",user);
	}
	
}