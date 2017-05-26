package com.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 员工和维护中间表
 * @author kone
 * 2017-5-26
 */
@Entity
@Table(name="maintainAndWorker")
public class MaintainAndWorker {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
//	设备维护和员工多对一
	@ManyToOne
	@JoinColumn(name="workerId")
	@Basic(fetch=FetchType.LAZY)
	private Worker worker ;
//	设备维护和维护计划多对一
	@ManyToOne
	@JoinColumn(name="maintainPlanId")
	@Basic(fetch=FetchType.LAZY)
	private MaintainPlan maintainPlan;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Worker getWorker() {
		return worker;
	}
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	public MaintainPlan getMaintainPlan() {
		return maintainPlan;
	}
	public void setMaintainPlan(MaintainPlan maintainPlan) {
		this.maintainPlan = maintainPlan;
	}
	
	
}
