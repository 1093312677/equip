package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="worker")
public class Worker {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String no;
	private String name;
	@OneToMany(mappedBy="worker",cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	private List<MaintainAndWorker> maintainAndWorkers = new ArrayList<MaintainAndWorker>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<MaintainAndWorker> getMaintainAndWorkers() {
		return maintainAndWorkers;
	}
	public void setMaintainAndWorkers(List<MaintainAndWorker> maintainAndWorkers) {
		this.maintainAndWorkers = maintainAndWorkers;
	}
	
}
