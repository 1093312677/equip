package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.OutWareHouse;
import com.entity.User;

@Repository
public class AccountDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private String hql;
	public void login(){
		try{
			User user = new User();
			user.setPassword("kone");
			user.setUsername("kone");
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{
			if(session.isOpen()) {
				session.close();
			}
		}
		System.out.println("dao");
	}
	public void get(){
		hql = "from User";
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			List<User> user = session.createQuery(hql).list();
			for(int i=0;i<user.size();i++) {
				System.out.println(user.get(i).getUsername()+"  "+user.get(i).getPassword());
			}
			session.getTransaction().commit();
			System.out.println("ko");
		}catch(Exception e){
			
		}finally{
			if(session.isOpen()) {
				session.close();
			}
		}
	}
	
	public boolean saveOutWareHouse(OutWareHouse outWareHouse) {
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(outWareHouse);
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
