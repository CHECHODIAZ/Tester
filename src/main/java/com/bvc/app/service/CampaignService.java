package com.bvc.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bvc.app.entity.Campaign;

public interface CampaignService {
	
	public Iterable<Campaign> findAll();
	
	public Page<Campaign> findAll(Pageable pageable);   //It will be implement with a front framework end
	
	public Optional<Campaign> findById(Long id);  
	
	public Campaign save(Campaign campaign);
	
	public void deleteById(Long id);
	
	public List<Campaign> descendentRequestedAmount() throws Exception;
	
	public List<Campaign> descendentAmount () throws Exception;
	
	public List<Campaign> ascendentRequestedAmount() throws Exception;
	 
	public List<Campaign> ascendentAmount () throws Exception;
	
}
