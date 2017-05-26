package com.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.EquipParameter;
import com.service.EquipService;

@ParentPackage("basePackage")
@Action(value="equip",results = { @Result(name = "login",location = "/success.jsp") })//ʹ��convention-plugin����ṩ��@Actionע�⽫һ����ͨjava���עΪһ�����Դ����û������Action
@Namespace("/")//ʹ��convention-plugin����ṩ��@Namespaceע��Ϊ���Actionָ��һ�������ռ�
public class EquipAction {
	@Autowired
	private EquipService equipService;
	private EquipParameter equipParameter = new EquipParameter();
	/**
	 * ����豸����
	 * @return
	 */
	public String addEquip() {
		equipService.addEquip(equipParameter);
		return null;
	}
	
	
	
	
	public EquipParameter getEquipParameter() {
		return equipParameter;
	}
	public void setEquipParameter(EquipParameter equipParameter) {
		this.equipParameter = equipParameter;
	}
	
	
	
	
	
	
	
	
}
