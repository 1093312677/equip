package com.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.OutWareHouse;
import com.entity.Worker;
import com.service.LoginService;

@ParentPackage("basePackage")
@Action(value="login",results = { @Result(name = "login",location = "/success.jsp") })//使用convention-plugin插件提供的@Action注解将一个普通java类标注为一个可以处理用户请求的Action
@Namespace("/")//使用convention-plugin插件提供的@Namespace注解为这个Action指定一个命名空间
public class LoginAction {
	@Autowired
	private LoginService loginService;
	private Worker worker;
	public String login(){
		System.out.println("ok");
		loginService.login();
		
		return "login";
	}
	
	public String saveOutWareHouse() {
		System.out.println("name"+outWareHouse.getEquipimentName()+"  出库数："+outWareHouse.getNumber()+" 出库时间："+outWareHouse.getTime()+" 领取人："+outWareHouse.getReceiptor());
		return "login";
	}
	
	public String addWorker() {
		loginService.addWorker(worker);
		return null;
	}
	
	
	
	private OutWareHouse outWareHouse= new OutWareHouse();
	public OutWareHouse getOutWareHouse() {
		return outWareHouse;
	}

	public void setOutWareHouse(OutWareHouse outWareHouse) {
		this.outWareHouse = outWareHouse;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	
}
