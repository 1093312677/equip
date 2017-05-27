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
import com.entity.Warning;
import com.service.WarningService;

import superAction.SuperAction;

@ParentPackage("basePackage")
@Action(value="warning",results = { @Result(name = "service_plan",location = "/service_plan.jsp") })//ʹ��convention-plugin����ṩ��@Actionע�⽫һ����ͨjava���עΪһ�����Դ����û������Action
@Namespace("/")//ʹ��convention-plugin����ṩ��@Namespaceע��Ϊ���Actionָ��һ�������ռ�
public class WarningAction extends SuperAction{
	@Autowired
	private WarningService warningService;
	private Warning warning;
	private int equipId;
	public String addWarning() {
		EquipParameter equipParameter = new EquipParameter();
		equipParameter.setId(equipId);
		warning.setEquipParameter(equipParameter);
		if(warningService.addWarning(warning)) {
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
	 * �鿴����
	 * @return
	 */
	public String viewWarning() {
		List<Warning> warnings = warningService.viewWarning();
		JSONObject json  = new JSONObject();
		json.put("data", warnings);
		try {
			response.getWriter().println(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public Warning getWarning() {
		return warning;
	}
	public void setWarning(Warning warning) {
		this.warning = warning;
	}
	public int getEquipId() {
		return equipId;
	}
	public void setEquipId(int equipId) {
		this.equipId = equipId;
	}
	
}
