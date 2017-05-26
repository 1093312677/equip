package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 设备参数
 * @author kone
 * 2017-5-25
 */
@Entity
@Table(name="equipParam")
public class EquipParameter {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String equipmentName;
	private String pressure;
	private String flux;
	private String temperature;
	private String power;
	private String frequency;
	private String bd;
//	和运行参数一对多
	@OneToMany(mappedBy="equipParameter",cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	private List<RunParam> runParams = new ArrayList<RunParam>();
//	和报警一对多
	@OneToMany(mappedBy="equipParameter",cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	private List<Warning> warnings = new ArrayList<Warning>();
//	和维护计划一对多
	@OneToMany(mappedBy="equipParameter",cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	private List<MaintainPlan> maintainPlans = new ArrayList<MaintainPlan>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getFlux() {
		return flux;
	}
	public void setFlux(String flux) {
		this.flux = flux;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getBd() {
		return bd;
	}
	public void setBd(String bd) {
		this.bd = bd;
	}
	public List<RunParam> getRunParams() {
		return runParams;
	}
	public void setRunParams(List<RunParam> runParams) {
		this.runParams = runParams;
	}
	public List<Warning> getWarnings() {
		return warnings;
	}
	public void setWarnings(List<Warning> warnings) {
		this.warnings = warnings;
	}
	public List<MaintainPlan> getMaintainPlans() {
		return maintainPlans;
	}
	public void setMaintainPlans(List<MaintainPlan> maintainPlans) {
		this.maintainPlans = maintainPlans;
	}
	
}
