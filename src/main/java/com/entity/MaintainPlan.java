package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 工作计划
 * @author kone
 *
 */
@Entity
@Table(name="maintainPlan")
public class MaintainPlan {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String startTime;//预计维护开始时间（startTime）
	private String finishTime;//预计维护结束时间（finishTime）
	private String totalTime;//预计维护时长（totalTime）
	private int spareTotal;//所需备件数（spareTotal） 
//	维修计划和设备多对一
	@ManyToOne
	@JoinColumn(name="equipParameterId")
	@Basic(fetch=FetchType.LAZY)
	private EquipParameter equipParameter;
//	维修计划和设备维修一对多
	@OneToMany(mappedBy="maintainPlan",cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	private List<EquipAndMaintain> equipAndMaintains = new ArrayList<EquipAndMaintain>();
	
	@OneToMany(mappedBy="maintainPlan",cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	private List<MaintainAndWorker> maintainAndWorkers = new ArrayList<MaintainAndWorker>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	public String getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}
	public int getSpareTotal() {
		return spareTotal;
	}
	public void setSpareTotal(int spareTotal) {
		this.spareTotal = spareTotal;
	}
	public EquipParameter getEquipParameter() {
		return equipParameter;
	}
	public void setEquipParameter(EquipParameter equipParameter) {
		this.equipParameter = equipParameter;
	}
	public List<EquipAndMaintain> getEquipAndMaintains() {
		return equipAndMaintains;
	}
	public void setEquipAndMaintains(List<EquipAndMaintain> equipAndMaintains) {
		this.equipAndMaintains = equipAndMaintains;
	}
	public List<MaintainAndWorker> getMaintainAndWorkers() {
		return maintainAndWorkers;
	}
	public void setMaintainAndWorkers(List<MaintainAndWorker> maintainAndWorkers) {
		this.maintainAndWorkers = maintainAndWorkers;
	}
	
	
	
}
