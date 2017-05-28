package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.impl.CommonDaoImpl;
import com.entity.RunParam;
import com.entity.Warning;
/**
 * 运行参数的相关逻辑操作
 * @author kone
 *
 */
@Service
public class RunParamService {
	@Autowired
	private CommonDaoImpl commonDaoImpl;
	/**
	 * 添加运行参数
	 * @param runParm
	 * @return
	 */
	public boolean addRunParam(RunParam runParm) {
		
		return commonDaoImpl.save(runParm);
	}
	
	public List<RunParam> viewRunParam() {
		List<RunParam> runParams = commonDaoImpl.view("RunParam");
		for(int i=0;i<runParams.size();i++) {
			runParams.get(i).getEquipParameter().getEquipmentName();
			runParams.get(i).getEquipParameter().setMaintainPlans(null);
			runParams.get(i).getEquipParameter().setRunParams(null);
			runParams.get(i).getEquipParameter().setWarnings(null);
			runParams.get(i).getEquipParameter().setLifeLogs(null);
		}
		commonDaoImpl.closeSession();
		return runParams;
	}
}
