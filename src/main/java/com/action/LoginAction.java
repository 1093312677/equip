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
@Action(value="login",results = { @Result(name = "login",location = "/success.jsp") })//ʹ��convention-plugin����ṩ��@Actionע�⽫һ����ͨjava���עΪһ�����Դ����û������Action
@Namespace("/")//ʹ��convention-plugin����ṩ��@Namespaceע��Ϊ���Actionָ��һ�������ռ�
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
		System.out.println("name"+outWareHouse.getEquipimentName()+"  ��������"+outWareHouse.getNumber()+" ����ʱ�䣺"+outWareHouse.getTime()+" ��ȡ�ˣ�"+outWareHouse.getReceiptor());
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
