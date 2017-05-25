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

@Entity
@Table(name="spareOutLog")
public class SpareOutLog {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String number;//出库数
	private String time;//出库时间
	private String reason;//出库原因
	private String getPerson;//领取人
	private String outPerson;//出库人
	@ManyToOne
	@JoinColumn(name="spareId")
	@Basic(fetch=FetchType.LAZY)
	private Spare spare;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getGetPerson() {
		return getPerson;
	}
	public void setGetPerson(String getPerson) {
		this.getPerson = getPerson;
	}
	public String getOutPerson() {
		return outPerson;
	}
	public void setOutPerson(String outPerson) {
		this.outPerson = outPerson;
	}
	public Spare getSpare() {
		return spare;
	}
	public void setSpare(Spare spare) {
		this.spare = spare;
	}
	
}
