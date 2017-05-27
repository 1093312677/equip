package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 警报相关的逻辑处理
 * @author kone
 *
 */

import com.dao.impl.CommonDaoImpl;
import com.entity.Warning;
@Service
public class WarningService {
	@Autowired
	private CommonDaoImpl commonDaoImpl;
	/**
	 * 添加报警
	 * @param warning
	 * @return
	 */
	public boolean addWarning(Warning warning) {
		return commonDaoImpl.save(warning);
	}
	/**
	 * 查看设备
	 * @return
	 */
	public List<Warning> viewWarning() {
		List<Warning> warnings = commonDaoImpl.view("Warning");
		for(int i=0;i<warnings.size();i++) {
			warnings.get(i).getEquipParameter().getEquipmentName();
			warnings.get(i).getEquipParameter().setMaintainPlans(null);
			warnings.get(i).getEquipParameter().setRunParams(null);
			warnings.get(i).getEquipParameter().setWarnings(null);
		}
		commonDaoImpl.closeSession();
		return warnings;
	}
	
}
