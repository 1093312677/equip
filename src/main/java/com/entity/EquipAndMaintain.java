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
 * �豸��ά���м��
 * @author kone
 * 2017-5-26
 */
@Entity
@Table(name="equipAndMaintain")
public class EquipAndMaintain {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
//	�豸ά���ͱ������һ
	@ManyToOne
	@JoinColumn(name="spareId")
	@Basic(fetch=FetchType.LAZY)
	private Spare spare;
//	�豸ά����ά���ƻ����һ
	@ManyToOne
	@JoinColumn(name="maintainPlanId")
	@Basic(fetch=FetchType.LAZY)
	private MaintainPlan maintainPlan;

	private int needNumber;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Spare getSpare() {
		return spare;
	}

	public void setSpare(Spare spare) {
		this.spare = spare;
	}

	public MaintainPlan getMaintainPlan() {
		return maintainPlan;
	}

	public void setMaintainPlan(MaintainPlan maintainPlan) {
		this.maintainPlan = maintainPlan;
	}

	public int getNeedNumber() {
		return needNumber;
	}

	public void setNeedNumber(int needNumber) {
		this.needNumber = needNumber;
	}
	
}
