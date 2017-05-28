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
import com.entity.RunParam;
import com.service.RunParamService;

import superAction.SuperAction;

@ParentPackage("basePackage")
@Action(value="runParam",results = { @Result(name = "service_plan",location = "/service_plan.jsp") })//ʹ��convention-plugin����ṩ��@Actionע�⽫һ����ͨjava���עΪһ�����Դ����û������Action
@Namespace("/")//ʹ��convention-plugin����ṩ��@Namespaceע��Ϊ���Actionָ��һ�������ռ�
public class RunParamAction extends SuperAction{
	@Autowired
	private RunParamService paramService;
	
	private RunParam runParm;
	private int equipId;
	/**
	 * ������в���
	 * @return
	 */
	public String addRunParam() {
		EquipParameter equipParameter = new EquipParameter();
		equipParameter.setId(equipId);
		runParm.setEquipParameter(equipParameter);
		paramService.addRunParam(runParm);
		return null;
	}
	/**
	 * �鿴���в���
	 * @return
	 */
	public String viewRunParam() {
		List<RunParam> runParams = paramService.viewRunParam();
		JSONObject json  = new JSONObject();
		json.put("data", runParams);
		try {
			response.getWriter().println(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public RunParam getRunParm() {
		return runParm;
	}
	public void setRunParm(RunParam runParm) {
		this.runParm = runParm;
	}
	public int getEquipId() {
		return equipId;
	}
	public void setEquipId(int equipId) {
		this.equipId = equipId;
	}
	
	
}
