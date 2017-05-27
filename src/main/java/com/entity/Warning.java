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
 * 报警记录
 * @author kone
 *
 */
@Entity
@Table(name="warning")
public class Warning {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String earlyWarning;//预警信息
	
	private String earlyTime;//预警时间
	
	private String warning;//警报信息
	private String warningTime;//报警时间
	private String createDate;//
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
	public String getEarlyWarning() {
		return earlyWarning;
	}
	public void setEarlyWarning(String earlyWarning) {
		this.earlyWarning = earlyWarning;
	}
	public String getWarning() {
		return warning;
	}
	public void setWarning(String warning) {
		this.warning = warning;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public EquipParameter getEquipParameter() {
		return equipParameter;
	}
	public void setEquipParameter(EquipParameter equipParameter) {
		this.equipParameter = equipParameter;
	}
	public String getEarlyTime() {
		return earlyTime;
	}
	public void setEarlyTime(String earlyTime) {
		this.earlyTime = earlyTime;
	}
	public String getWarningTime() {
		return warningTime;
	}
	public void setWarningTime(String warningTime) {
		this.warningTime = warningTime;
	}
	
	
}
