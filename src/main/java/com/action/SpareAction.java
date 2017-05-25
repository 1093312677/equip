package com.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.entity.Spare;
import com.entity.SpareInLog;
import com.entity.SpareOutLog;
import com.service.SpareService;

import superAction.SuperAction;

@ParentPackage("basePackage")
@Action(value="spare",results = { @Result(name = "login",location = "/success.jsp") })//ʹ��convention-plugin����ṩ��@Actionע�⽫һ����ͨjava���עΪһ�����Դ����û������Action
@Namespace("/")//ʹ��convention-plugin����ṩ��@Namespaceע��Ϊ���Actionָ��һ�������ռ�
public class SpareAction extends SuperAction{
	@Autowired
	private SpareService spareService;
	private Spare spare = new Spare();
	private SpareInLog spareInLog = new SpareInLog();
	private SpareOutLog spareOutLog = new SpareOutLog();
	
	private int spareId;
	/**
	 * ��ӱ���
	 * @return
	 */
	public String addSpare() {
		spare.setSpareName("һ����˿");
		spare.setInventoryTotal(200);
		spare.setSpareAddress("A-11-3");
		spareService.addSpare(spare);
		return null;
	}
	/**
	 * �鿴����
	 * @return
	 */
	public String viewSpare() {
		
		List<Spare> spares = spareService.viewSpare();
		JSONObject json  = new JSONObject();
		json.put("data", spares);
		try {
			response.getWriter().println(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ��ӱ���
	 * @return
	 */
	public String addSpareInLog() {
		spare.setId(spareId);
		spareInLog.setSpare(spare);
		
		try {
			if(spareService.addSpareInLog(spareInLog))
				response.getWriter().println(1);
			else 
				response.getWriter().println(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ��������
	 * @return
	 */
	public String addSpareOutLog() {
		spare.setId(spareId);
		spareOutLog.setSpare(spare);
		
		try {
			if(spareService.addSpareOutLog(spareOutLog))
				response.getWriter().println(1);
			else 
				response.getWriter().println(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * �鿴��������¼
	 * @return
	 */
	public String viewSpareInLog() {
		
		List<SpareInLog> spareInLogs = spareService.viewSpareInLog();
		JSONObject json  = new JSONObject();
		json.put("data", spareInLogs);
		try {
			response.getWriter().println(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Spare getSpare() {
		return spare;
	}

	public void setSpare(Spare spare) {
		this.spare = spare;
	}
	public SpareInLog getSpareInLog() {
		return spareInLog;
	}
	public void setSpareInLog(SpareInLog spareInLog) {
		this.spareInLog = spareInLog;
	}
	public int getSpareId() {
		return spareId;
	}
	public void setSpareId(int spareId) {
		this.spareId = spareId;
	}
	public SpareOutLog getSpareOutLog() {
		return spareOutLog;
	}
	public void setSpareOutLog(SpareOutLog spareOutLog) {
		this.spareOutLog = spareOutLog;
	}
	
	
	
}
