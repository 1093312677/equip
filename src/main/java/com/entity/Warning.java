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
 * ������¼
 * @author kone
 *
 */
@Entity
@Table(name="warning")
public class Warning {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String earlyWarning;//Ԥ����Ϣ
	private String warning;//������Ϣ
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
	
	
}
