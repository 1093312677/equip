package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.dao.impl.CommonDaoImpl;
import com.entity.EquipAndMaintain;
import com.entity.EquipParameter;
import com.entity.MaintainAndWorker;
import com.entity.MaintainPlan;
import com.entity.Spare;
import com.entity.Worker;

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
			equipParameters.get(i).setLifeLogs(null);
		}
		commonDaoImpl.closeSession();
		return equipParameters;
	}
	
	/**
	 * 查看员工
	 * @return
	 */
	public List<Worker> viewWorker() {
		List<Worker> workers = commonDaoImpl.view("Worker");
		for(int i=0;i<workers.size();i++) {
			workers.get(i).setMaintainAndWorkers(null);
		}
		commonDaoImpl.closeSession();
		return workers;
	}
	/**
	 * 添加设备维护计划  
	 * @param maintainPlan
	 * @param spareName
	 * @param spareTotal
	 * @param equipId
	 * @param workers
	 * @return
	 */
	public boolean addMaintainPlan(MaintainPlan maintainPlan, int spareName[], int spareTotal[], int equipId,int workers[]) {
		Spare spare = null;
		EquipAndMaintain equipAndMaintain = null;
		
		Worker worker = null;
//		设置备件
		for(int i=0;i<spareName.length;i++) {
			spare = new Spare();
			spare.setId(spareName[i]);
			equipAndMaintain = new EquipAndMaintain();
			
			equipAndMaintain.setSpare(spare);
			equipAndMaintain.setNeedNumber(spareTotal[i]);
			equipAndMaintain.setMaintainPlan(maintainPlan);
			maintainPlan.getEquipAndMaintains().add(equipAndMaintain);
		}
//		设置员工
		MaintainAndWorker maintainAndWorker = null;
		for(int i=0;i<workers.length;i++) {
			worker = new Worker();
			worker.setId(workers[i]);
			
			maintainAndWorker = new MaintainAndWorker();
			maintainAndWorker.setWorker(worker);
			
			maintainAndWorker.setMaintainPlan(maintainPlan);
			
			maintainPlan.getMaintainAndWorkers().add(maintainAndWorker);
		}
//		设置设备
		EquipParameter equipParameter = new EquipParameter();
		equipParameter.setId(equipId);
		maintainPlan.setEquipParameter(equipParameter);
		if(commonDaoImpl.save(maintainPlan))
			return true;
		return false;
	}
	
	/**
	 * 查看设备维护计划
	 * @return
	 */
	public List<MaintainPlan> viewMaintainPlan() {
		List<MaintainPlan> maintainPlans = commonDaoImpl.view("MaintainPlan");
		List<MaintainPlan> maintainPlans2 = new ArrayList<MaintainPlan>();
		MaintainPlan maintainPlan = null;
		
		List<MaintainAndWorker> maintainAndWorkers = null;
		MaintainAndWorker maintainAndWorker = null;
		Worker worker = null;
		for(int i=0;i<maintainPlans.size();i++) {
			for(int jjj =0;jjj<maintainPlans.get(i).getMaintainAndWorkers().size();jjj++) {
	//			maintainPlans.get(i).getEquipAndMaintains().get(j).getMaintainPlan().getMaintainAndWorkers().get(jjj).setMaintainPlan(null);
				System.out.println("-------"+maintainPlans.get(i).getMaintainAndWorkers().get(jjj).getWorker().getName());
			}
			
			
			for(int jj=0;jj<maintainPlans.get(i).getEquipAndMaintains().size();jj++) {
	//				maintainPlans.get(i).getEquipAndMaintains().get(j).getMaintainPlan().getEquipAndMaintains().get(jj).setMaintainPlan(null);
				System.out.println("++++"+maintainPlans.get(i).getEquipAndMaintains().get(jj).getSpare().getSpareName());
				
			}
		}
//		for(int i=0;i<maintainPlans.size();i++) {
//			maintainPlan = new MaintainPlan();
//			
////			EquipParameter
//			maintainPlans.get(i).getEquipParameter().setMaintainPlans(null);
//			maintainPlans.get(i).getEquipParameter().setRunParams(null);
//			maintainPlans.get(i).getEquipParameter().setWarnings(null);
//			maintainPlan.setEquipParameter(maintainPlans.get(i).getEquipParameter());
//			
////			maintainAndWorker
//			maintainAndWorkers = new ArrayList<MaintainAndWorker>();
//			maintainAndWorker = null;
//			worker = null;
//			for(int k=0;k<maintainPlans.get(i).getMaintainAndWorkers().size();k++) {
//				maintainAndWorker = new MaintainAndWorker();
//				worker = new Worker();
//				worker.setName(maintainPlans.get(i).getMaintainAndWorkers().get(k).getWorker().getName());
//				worker.setNo(maintainPlans.get(i).getMaintainAndWorkers().get(k).getWorker().getNo());
//				maintainAndWorker.setWorker(worker);
//				maintainAndWorkers.add(maintainAndWorker);
//			}
//			maintainPlan.setMaintainAndWorkers(maintainAndWorkers);
//			
//			maintainPlans2.add(maintainPlan);
//			
//			for(int jjj =0;jjj<maintainPlans.get(i).getMaintainAndWorkers().size();jjj++) {
////				maintainPlans.get(i).getEquipAndMaintains().get(j).getMaintainPlan().getMaintainAndWorkers().get(jjj).setMaintainPlan(null);
//				System.out.println("-------"+maintainPlans.get(i).getMaintainAndWorkers().get(jjj).getWorker().getName());
//			}
//			
//			
//			for(int jj=0;jj<maintainPlans.get(i).getEquipAndMaintains().size();jj++) {
////					maintainPlans.get(i).getEquipAndMaintains().get(j).getMaintainPlan().getEquipAndMaintains().get(jj).setMaintainPlan(null);
//				System.out.println("++++"+maintainPlans.get(i).getEquipAndMaintains().get(jj).getSpare().getSpareName());
//				
//			}
//		}
		commonDaoImpl.closeSession();
		return maintainPlans;
	}
}
