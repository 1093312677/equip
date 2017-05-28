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
 * 生命日志
 * @author kone
 *
 */
@Entity
@Table(name="lifeLog")
public class LifeLog {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String outerMsg;//
	
	private String configMsg;//预警时间
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
	public String getOuterMsg() {
		return outerMsg;
	}
	public void setOuterMsg(String outerMsg) {
		this.outerMsg = outerMsg;
	}
	public String getConfigMsg() {
		return configMsg;
	}
	public void setConfigMsg(String configMsg) {
		this.configMsg = configMsg;
	}
	public EquipParameter getEquipParameter() {
		return equipParameter;
	}
	public void setEquipParameter(EquipParameter equipParameter) {
		this.equipParameter = equipParameter;
	}
	
}
