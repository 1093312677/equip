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
 * �����ƻ�
 * @author kone
 *
 */
@Entity
@Table(name="maintainPlan")
public class MaintainPlan {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String startTime;//Ԥ��ά����ʼʱ�䣨startTime��
	private String finishTime;//Ԥ��ά������ʱ�䣨finishTime��
	private String totalTime;//Ԥ��ά��ʱ����totalTime��
	private int spareTotal;//���豸������spareTotal�� 
//	ά�޼ƻ����豸���һ
	@ManyToOne
	@JoinColumn(name="equipParameterId")
	@Basic(fetch=FetchType.LAZY)
	private EquipParameter equipParameter;
//	ά�޼ƻ����豸ά��һ�Զ�
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
