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
@Table(name="spareInLog")
public class SpareInLog {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String number;//入库数
	private String time;//入库时间
	private String reason;//入库原因
	private String sendPerson;//送货人
	private String inPerson;//入库人
	@ManyToOne
	@JoinColumn(name="spareId")
	@Basic(fetch=FetchType.EAGER)
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
	public String getSendPerson() {
		return sendPerson;
	}
	public void setSendPerson(String sendPerson) {
		this.sendPerson = sendPerson;
	}
	public String getInPerson() {
		return inPerson;
	}
	public void setInPerson(String inPerson) {
		this.inPerson = inPerson;
	}
	public Spare getSpare() {
		return spare;
	}
	public void setSpare(Spare spare) {
		this.spare = spare;
	}
	
}
