package com.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.entity.EquipParameter;
import com.entity.MaintainPlan;
import com.entity.Worker;
import com.service.EquipService;

import superAction.SuperAction;

@ParentPackage("basePackage")
@Action(value="equip",results = { @Result(name = "service_plan",location = "/service_plan.jsp") })//使用convention-plugin插件提供的@Action注解将一个普通java类标注为一个可以处理用户请求的Action
@Namespace("/")//使用convention-plugin插件提供的@Namespace注解为这个Action指定一个命名空间
public class EquipAction extends SuperAction{
	@Autowired
	private EquipService equipService;
	private EquipParameter equipParameter = new EquipParameter();
	
	private MaintainPlan maintainPlan = new MaintainPlan();
	private int spareName[];
	private int spareTotal[];
	private int equipId;
	private int worker[];
	/**
	 * 添加设备参数
	 * @return
	 */
	public String addEquip() {
		equipService.addEquip(equipParameter);
		return null;
	}
	
	/**
	 * 查看设备
	 * @return
	 */
	public String viewEquip() {
		
		List<EquipParameter> equipParameters = equipService.viewEquipParameter();
		JSONObject json  = new JSONObject();
		json.put("data", equipParameters);
		try {
			response.getWriter().println(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 添加设备维护计划
	 * @return
	 */
	public String addServicePlan() {
		if(equipService.addMaintainPlan(maintainPlan, spareName, spareTotal, equipId, worker)) {
			try {
				response.getWriter().println(1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().println(0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 查看设备维护计划
	 * @return
	 */
	public String viewServicePlan() {
		List<MaintainPlan> maintainPlans = equipService.viewMaintainPlan();
//		JSONObject json  = new JSONObject();
//		json.put("data", maintainPlans);
//		try {
//			response.getWriter().println(json.toString());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		request.setAttribute("plan", maintainPlans);
		return "service_plan";
	}
	
	/**
	 * 查看员工
	 * @return
	 */
	public String viewWorker() {
		List<Worker> workers = equipService.viewWorker();
		JSONObject json  = new JSONObject();
		json.put("data", workers);
		try {
			response.getWriter().println(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public EquipParameter getEquipParameter() {
		return equipParameter;
	}
	public void setEquipParameter(EquipParameter equipParameter) {
		this.equipParameter = equipParameter;
	}

	public MaintainPlan getMaintainPlan() {
		return maintainPlan;
	}

	public void setMaintainPlan(MaintainPlan maintainPlan) {
		this.maintainPlan = maintainPlan;
	}


	public int[] getSpareName() {
		return spareName;
	}

	public void setSpareName(int[] spareName) {
		this.spareName = spareName;
	}

	public int getEquipId() {
		return equipId;
	}

	public void setEquipId(int equipId) {
		this.equipId = equipId;
	}


	public int[] getWorker() {
		return worker;
	}

	public void setWorker(int[] worker) {
		this.worker = worker;
	}

	public int[] getSpareTotal() {
		return spareTotal;
	}

	public void setSpareTotal(int[] spareTotal) {
		this.spareTotal = spareTotal;
	}
	
	
	
	
	
	
	
	
}
