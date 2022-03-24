package com.bvc.app.entity;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;






public class SummaryCampaign  {
	
	private static Collection<String> Nmount;
	
	private static Collection<String> NrequestedAmount;
     
	
	
	

	public static Collection<String> getNmount() {
		return Nmount;
	}

	public static void setNmount(Collection<String> string) {
		
		Nmount = string;
	}

	public static Collection<String> getNrequestedAmount() {
		return NrequestedAmount;
	}

	public static void setNrequestedAmount(Collection<String> nrequestedAmount) {
		NrequestedAmount = nrequestedAmount;
	}
	
	
	
	
	

}
