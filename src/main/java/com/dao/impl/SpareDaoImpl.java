package com.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.SpareInLog;
import com.entity.SpareOutLog;
/**
 * spare dao
 * @author kone
 * 2017 5 25
 */
@Repository
public class SpareDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private String hql;
	public boolean addSpareInLog(SpareInLog spareInLog){
		hql = "UPDATE Spare SET inventoryTotal = inventoryTotal+"+spareInLog.getNumber();
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(spareInLog);
			session.createQuery(hql).executeUpdate();
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
	
	public boolean addSpareOutLog(SpareOutLog spareOutLog){
		hql = "UPDATE Spare SET inventoryTotal = inventoryTotal-"+spareOutLog.getNumber();
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(spareOutLog);
			session.createQuery(hql).executeUpdate();
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
	
}
