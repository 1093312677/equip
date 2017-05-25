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
	private String number;//������
	private String time;//����ʱ��
	private String reason;//����ԭ��
	private String getPerson;//��ȡ��
	private String outPerson;//������
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
