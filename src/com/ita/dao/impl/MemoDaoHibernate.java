package com.ita.dao.impl;

import java.util.List;

import com.ita.dao.MemoDao;
import com.ita.model.Memo;
import com.ita.model.User;
import com.ita.support.PlusHibernateDaoSupport;

public class MemoDaoHibernate 
	extends PlusHibernateDaoSupport
	implements MemoDao{

	@Override
	public Memo get(Integer id) {
		// TODO Auto-generated method stub
		return (Memo)getHibernateTemplate().get(Memo.class, id);
	}

	@Override
	public Integer save(Memo memo) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(memo);
	}

	@Override
	public void update(Memo memo) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(memo);
	}

	@Override
	public void detele(Memo memo) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(memo);
	}

	@Override
	public void detele(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<Memo> findAll() {
		// TODO Auto-generated method stub
		return (List<Memo>)getHibernateTemplate().find("from Memo");
	}

	@Override
	public List<Memo> findByUser(User user) {
		// TODO Auto-generated method stub
		return (List<Memo>)getHibernateTemplate().find("from Memo as m where m.user = ? ",user);
	}

	@Override
	public List<Memo> findByUserAndSyn(User user) {
		// TODO Auto-generated method stub
		return (List<Memo>)getHibernateTemplate().find("from Memo as m where m.user = ? and (m.syn = 0 or m.syn = -1)",user);
	}

	
}