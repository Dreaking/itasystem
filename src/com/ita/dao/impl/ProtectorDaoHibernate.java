package com.ita.dao.impl;

import java.util.List;

import com.ita.dao.ProtectorDao;
import com.ita.model.Protector;
import com.ita.model.User;
import com.ita.support.PlusHibernateDaoSupport;

public class ProtectorDaoHibernate
	extends PlusHibernateDaoSupport
	implements ProtectorDao{

	@Override
	public Protector get(Integer id) {
		// TODO Auto-generated method stub
		return (Protector)getHibernateTemplate().get(Protector.class, id);
	}

	@Override
	public Integer save(Protector protector) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(protector);
	}

	@Override
	public void update(Protector protector) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(protector);
	}

	@Override
	public void detele(Protector protector) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(protector);
	}

	@Override
	public void detele(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<Protector> findall() {
		// TODO Auto-generated method stub
		return (List<Protector>)getHibernateTemplate().find("from Protector");
	}

	@Override
	public List<Protector> findByUser(User user) {
		// TODO Auto-generated method stub
		return (List<Protector>)getHibernateTemplate().find("from Protector as p where p.user = ? ",user);
	}
	
}