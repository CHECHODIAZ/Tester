package com.bvc.app.entity;

import java.sql.Array;
import java.util.Collection;






public class SummaryCampaign extends Campaign {
	
	private static Collection<String> Nmount;
	
	private static Collection<String> NrequestedAmount;
     
	
	
	

	public SummaryCampaign(Array array) {
		
	}

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
