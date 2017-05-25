package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDaoImpl<T> {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private String hql;
	public boolean save(T entity){
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			if(session.isOpen()) {
				session.close();
			}
		}
	}
	
	public List view(String table){
		hql = "From "+table;
		List entitys = null;
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			entitys = session.createQuery(hql).list();
			session.getTransaction().commit();
			return entitys;
		}catch(Exception e){
			return entitys;
		}finally{
			if(session.isOpen()) {
				session.close();
			}
		}
	}
}
