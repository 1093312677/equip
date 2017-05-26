package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.impl.CommonDaoImpl;
import com.entity.EquipParameter;
import com.entity.Spare;

/**
 * 设备相关的逻辑处理
 * @author kone
 *
 */
@Service
public class EquipService {

	@Autowired
	private CommonDaoImpl commonDaoImpl;
	/**
	 * 保存设备信息
	 * @param equipParameter
	 * @return
	 */
	public boolean addEquip(EquipParameter equipParameter) {
		
		return commonDaoImpl.save(equipParameter);
	}
	/**
	 * 查看设备
	 * @return
	 */
	public List<EquipParameter> viewEquipParameter() {
		List<EquipParameter> equipParameters = commonDaoImpl.view("EquipParameter");
		for(int i=0;i<equipParameters.size();i++) {
			equipParameters.get(i).setMaintainPlans(null);
			equipParameters.get(i).setRunParams(null);
			equipParameters.get(i).setWarnings(null);
		}
		commonDaoImpl.closeSession();
		return equipParameters;
	}
	
	
}
