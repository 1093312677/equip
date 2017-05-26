package com.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.EquipParameter;
import com.service.EquipService;

@ParentPackage("basePackage")
@Action(value="equip",results = { @Result(name = "login",location = "/success.jsp") })//使用convention-plugin插件提供的@Action注解将一个普通java类标注为一个可以处理用户请求的Action
@Namespace("/")//使用convention-plugin插件提供的@Namespace注解为这个Action指定一个命名空间
public class EquipAction {
	@Autowired
	private EquipService equipService;
	private EquipParameter equipParameter = new EquipParameter();
	/**
	 * 添加设备参数
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
