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

@Entity
@Table(name="spare")
public class Spare {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String spareName;//备件名
	private int inventoryTotal;//库存数
	private String spareAddress;//备件地址
	@OneToMany(mappedBy="spare",cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	private List<SpareInLog> spareInLogs = new ArrayList<SpareInLog>();
	@OneToMany(mappedBy="spare",cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	private List<SpareOutLog> spareOutLogs = new ArrayList<SpareOutLog>();
//	备件和设备维护一对多
	@OneToMany(mappedBy="spare",cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	private List<EquipAndMaintain> equipAndMaintains = new ArrayList<EquipAndMaintain>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpareName() {
		return spareName;
	}
	public void setSpareName(String spareName) {
		this.spareName = spareName;
	}
	public String getSpareAddress() {
		return spareAddress;
	}
	public void setSpareAddress(String spareAddress) {
		this.spareAddress = spareAddress;
	}
	public List<SpareInLog> getSpareInLogs() {
		return spareInLogs;
	}
	public void setSpareInLogs(List<SpareInLog> spareInLogs) {
		this.spareInLogs = spareInLogs;
	}
	public List<SpareOutLog> getSpareOutLogs() {
		return spareOutLogs;
	}
	public void setSpareOutLogs(List<SpareOutLog> spareOutLogs) {
		this.spareOutLogs = spareOutLogs;
	}
	public int getInventoryTotal() {
		return inventoryTotal;
	}
	public void setInventoryTotal(int inventoryTotal) {
		this.inventoryTotal = inventoryTotal;
	}
	public List<EquipAndMaintain> getEquipAndMaintains() {
		return equipAndMaintains;
	}
	public void setEquipAndMaintains(List<EquipAndMaintain> equipAndMaintains) {
		this.equipAndMaintains = equipAndMaintains;
	}
	
	
	
}
