package com.bvc.app.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bvc.app.entity.Campaign;

public interface CampaignService {
	
	public Iterable<Campaign> findAll();
	
	public Page<Campaign> findAll(Pageable pageable);
	
	public Optional<Campaign> findById(Long id);
	
	public Campaign save(Campaign campaign);
	
	public void deleteById(Long id);
	
	public void serchColunmMenorAmayor(String column);
	
	public void serchColunmMayorAmenor(String column);

	public Collection<String>returnList(String typeOrder) throws Exception;

}
