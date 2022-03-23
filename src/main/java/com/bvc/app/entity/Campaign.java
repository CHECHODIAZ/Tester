package com.bvc.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "campaign")
public class Campaign implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idcampaign", nullable=false, unique = true)
	private Long id;
	
	@Column(nullable=false, length = 200)
	private String name;
	
	@Column(nullable=false, length = 20)
	private Double amount;
	
	@Column(nullable=false, length = 20)
	private Double requestedAmount;
    
	@Column(nullable=true, length = 20)
	private Double adminRate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getRequestedAmount() {
		return requestedAmount;
	}

	public void setRequestedAmount(Double requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

	public Double getAdminRate() {
		return adminRate;
	}

	public void setAdminRate(Double adminRate) {
		this.adminRate = adminRate;
	}
	
	
	
	
	
}
