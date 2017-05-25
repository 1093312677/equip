package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.impl.CommonDaoImpl;
import com.dao.impl.SpareDaoImpl;
import com.entity.Spare;
import com.entity.SpareInLog;
import com.entity.SpareOutLog;

@Service
public class SpareService {
	@Autowired
	private CommonDaoImpl commonDaoImpl;
	@Autowired
	private SpareDaoImpl spareDaoImpl;
	public boolean addSpare(Spare spare) {
		
		return commonDaoImpl.save(spare);
	}
	/**
	 * �������
	 * @param spareInLog
	 * @return
	 */
	public boolean addSpareOutLog(SpareOutLog spareOutLog) {
		
		return spareDaoImpl.addSpareOutLog(spareOutLog);
	}
	/**
	 * ��������
	 * @param spareInLog
	 * @return
	 */
	public boolean addSpareInLog(SpareInLog spareInLog) {
		
		return spareDaoImpl.addSpareInLog(spareInLog);
	}
	/**
	 * �鿴����
	 * @return
	 */
	public List<Spare> viewSpare() {
		List<Spare> spares = commonDaoImpl.view("Spare");
		for(int i=0;i<spares.size();i++) {
			spares.get(i).setSpareInLogs(null);
			spares.get(i).setSpareOutLogs(null);
		}
		return spares;
	}
	
	/**
	 * �鿴��������¼
	 * @return
	 */
	public List<SpareInLog> viewSpareInLog() {
		List<SpareInLog> spareInLogs = commonDaoImpl.view("SpareInLog");
//		for(int i=0;i<spareInLogs.size();i++) {
//			spareInLogs.get(i).setSpareInLogs(null);
//			spareInLogs.get(i).setSpareOutLogs(null);
//		}
		return spareInLogs;
	}
}
