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
import com.entity.LifeLog;
import com.entity.RunParam;
import com.service.LifeLogService;

import superAction.SuperAction;

@ParentPackage("basePackage")
@Action(value="lifeLog",results = { @Result(name = "service_plan",location = "/service_plan.jsp") })//ʹ��convention-plugin����ṩ��@Actionע�⽫һ����ͨjava���עΪһ�����Դ����û������Action
@Namespace("/")//ʹ��convention-plugin����ṩ��@Namespaceע��Ϊ���Actionָ��һ�������ռ�
public class LifeLogAction extends SuperAction{
	@Autowired
	private LifeLogService lifeLogService;
	private int equipId;
	private LifeLog lifeLog;
	/**
	 * ���������¼
	 * @return
	 */
	public String addLifeLog() {
		EquipParameter equipParameter = new EquipParameter();
		equipParameter.setId(equipId);
		lifeLog.setEquipParameter(equipParameter);
		lifeLogService.addLifeLog(lifeLog);
		return null;
	}
	
	public String viewLifeLog() {
		List<LifeLog> lifeLogs = lifeLogService.viewLifeLog();
		JSONObject json  = new JSONObject();
		json.put("data", lifeLogs);
		try {
			response.getWriter().println(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int getEquipId() {
		return equipId;
	}
	public void setEquipId(int equipId) {
		this.equipId = equipId;
	}
	public LifeLog getLifeLog() {
		return lifeLog;
	}
	public void setLifeLog(LifeLog lifeLog) {
		this.lifeLog = lifeLog;
	}
	
	
}
