package com.ita.dao;

import java.util.List;

import com.ita.model.Protector;
import com.ita.model.User;

public interface ProtectorDao{
	
	Protector get(Integer id);
	
	Integer save(Protector protector);
	
	void update(Protector protector);
	
	void detele(Protector protector);
	
	void detele(Integer id);
	
	List<Protector> findall();
	
	List<Protector> findByUser(User user);
	
}