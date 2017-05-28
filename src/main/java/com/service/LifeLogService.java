package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.impl.CommonDaoImpl;
import com.entity.LifeLog;
import com.entity.RunParam;

@Service
public class LifeLogService {
	@Autowired
	private CommonDaoImpl commonDaoImpl;
	public boolean addLifeLog(LifeLog lifeLog) {
		
		return commonDaoImpl.save(lifeLog);
	}
	
	public List<LifeLog> viewLifeLog() {
		List<LifeLog> lifeLogs = commonDaoImpl.view("LifeLog");
		for(int i=0;i<lifeLogs.size();i++) {
			lifeLogs.get(i).getEquipParameter().getEquipmentName();
			lifeLogs.get(i).getEquipParameter().setMaintainPlans(null);
			lifeLogs.get(i).getEquipParameter().setRunParams(null);
			lifeLogs.get(i).getEquipParameter().setWarnings(null);
			lifeLogs.get(i).getEquipParameter().setLifeLogs(null);
		}
		commonDaoImpl.closeSession();
		return lifeLogs;
	}
}
