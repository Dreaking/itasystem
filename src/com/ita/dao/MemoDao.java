package com.ita.dao;

import java.util.List;

import com.ita.model.Memo;
import com.ita.model.User;

public interface MemoDao{
	
	/**
	 * 根据标识属性加载Memo实例
	 * @param id 需要加载的Memo实例的标识属性
	 * @return 指定标识属性的Memo实例
	 */
	Memo get(Integer id);
	
	/**
	 * 持久化指定的Memo实例
	 * @param memo 需要持久化的Memo实例
	 * @return 被持久化的Memo实例的标识属性
	 */
	Integer save(Memo memo);
	
	/**
	 * 修改指定的Memo实例
	 * @param memo 需要被修改的Memo实例
	 */
	void update(Memo memo);
	
	/**
	 * 删除指定的Memo实例
	 * @param memo 需要被删除的Memo实例
	 */
	void detele(Memo memo);
	
	/**
	 * 根据标识属性删除指定的Memo实例
	 * @param id 需要被删除的Memo实例
	 */
	void detele(Integer id);
	
	/**
	 * 查询数据库全部的Memo实例
	 * @return 数据库中全部的Memo实例集合
	 */
	List<Memo> findAll();
	
	/**
	 * 根据用户查询Memo实例
	 * @param user 相应的用户
	 * @return 数据库中指定用户的Memo实例集合
	 */
	List<Memo> findByUser(User user);
	
	/**
	 * 根据用户和同步标志查询Memo实例
	 * @param user 相应的用户
	 * @return 数据库中指定用户的Memo实例集合
	 */
	List<Memo> findByUserAndSyn(User user);
}