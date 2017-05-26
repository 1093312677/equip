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
 * 设备参数
 * @author kone
 * 2017-5-25
 */
@Entity
@Table(name="deviceParam")
public class RunParam {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String totalTime;
	private String workTime;
	private String remainTime;
	private String exchange;
	private String exchangeReasons;
	@ManyToOne
	@JoinColumn(name="equipParameterId")
	@Basic(fetch=FetchType.LAZY)
	private EquipParameter equipParameter;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	public String getRemainTime() {
		return remainTime;
	}
	public void setRemainTime(String remainTime) {
		this.remainTime = remainTime;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getExchangeReasons() {
		return exchangeReasons;
	}
	public void setExchangeReasons(String exchangeReasons) {
		this.exchangeReasons = exchangeReasons;
	}
	public EquipParameter getEquipParameter() {
		return equipParameter;
	}
	public void setEquipParameter(EquipParameter equipParameter) {
		this.equipParameter = equipParameter;
	}
	
}
