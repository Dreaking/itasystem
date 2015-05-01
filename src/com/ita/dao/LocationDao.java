package com.ita.dao;

import java.util.List;

import com.ita.model.Location;
import com.ita.model.User;

public interface LocationDao{
	
	/**
	 * 根据标识属性加载Location实例
	 * @param id 需要加载的Location实例的标识属性
	 * @return 指定标识属性的location实例
	 */
	Location get(Integer id);
	
	/**
	 * 持久化指定的location实例
	 * @param location 需要被持久话的location实例
	 * @return 被持久的location实例的标识属性
	 */
	Integer save(Location location);
	
	/**
	 * 修改指定的location实例
	 * @param location 需要被修改的location实例
	 */
	void update(Location location);
	
	/**
	 * 删除指定的location实例
	 * @param location 需要被删除的location实例
	 */
	void delete(Location location);
	
	/**
	 * 根据标识属性删除指定的location实例
	 * @param id 需要被删除的location实例的标识属性
	 */
	void delete(Integer id);
	
	/**
	 * 查询数据库里全部的location实例
	 * @return 数据库中全部的location实例集合
	 */
	List<Location> findAll();
	
	/**
	 * 根据用户查询location实例
	 * @param user 作标记的用户
	 * @return 数据库中指定用户的location实例集合
	 */
	List<Location> findByUser(User user);
	
}