package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.impl.AccountDaoImpl;
import com.entity.Worker;

@Service
public class LoginService {
	@Autowired
	private AccountDaoImpl accountDaoImpl;
	public void login(){
		System.out.println("service");
		accountDaoImpl.get();
	}
	
	public boolean addWorker(Worker worker) {
		return accountDaoImpl.save(worker);
	}
}
