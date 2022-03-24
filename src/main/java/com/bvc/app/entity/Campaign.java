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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idcampaign", nullable=false, unique = true)
	private Long id;
	
	@Column(name="name", nullable=false, length = 200)
	private String Name;
	
	
	@Column(name="amount",nullable=false, length = 20)
	private Double Amount;
	
	
	@Column(name="requestedAmount", nullable=false, length = 20)
	private Double Requestedamount;
    
	@Column(nullable=true, length = 20)
	private Double adminRate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public Double getAmount() {
		return Amount;
	}

	public void setAmount(Double amount) {
		this.Amount = amount;
	}

	public Double getRequestedAmount() {
		return Requestedamount;
	}

	public void setRequestedAmount(Double requestedAmount) {
		this.Requestedamount = requestedAmount;
	}

	public Double getAdminRate() {
		return adminRate;
	}

	public void setAdminRate(Double adminRate) {
		this.adminRate = adminRate;
	}
	
	
	
	
	
}
