package com.bvc.app.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bvc.app.entity.Campaign;


import com.bvc.app.repository.CampaignRepository;


@Service
public class CampaignServiceImpl implements CampaignService {
	
	@Autowired
	private CampaignRepository campaignRepository;
	EntityManager em;
	String data =" ";
	Collection<String> order = null;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Campaign> findAll() {
		
		return campaignRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Campaign> findAll(Pageable pageable) {
		
		return campaignRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Campaign> findById(Long id) {
		
		return campaignRepository.findById(id);
	}

	@Override
	@Transactional
	public Campaign save(Campaign campaign) {
		
		return campaignRepository.save(campaign);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		campaignRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
    public List<Campaign> descendentRequestedAmount() throws Exception{
		campaignRepository.RequestedamountDESC();
		List<Campaign> inst = campaignRepository.RequestedamountDESC();
		return inst;
	}
	
	@Transactional(readOnly = true)
	public List<Campaign> descendentAmount () throws Exception {
		campaignRepository.amountDESC();
		List<Campaign> inst = campaignRepository.amountDESC();
		return inst;
	}
	
	
	@Transactional(readOnly = true)
    public List<Campaign> ascendentRequestedAmount() throws Exception{
		campaignRepository.RequestedamountASC();
		List<Campaign> inst = campaignRepository.RequestedamountASC();
		return inst;
	}
	

	@Transactional(readOnly = true)
	public List<Campaign> ascendentAmount () throws Exception{
		campaignRepository.amountASC();
		List<Campaign> inst = campaignRepository.amountASC();
		/*Collection<String> res = new ArrayList();
		while(inst.listIterator().hasNext() == true) {
			String resp = inst.listIterator().next().getName();
			res.add(resp);} 
		
		SummaryCampaign.setNmount(res);*/ //se esta desarrollando en las consultas solo muestre un elemento y no todo la fila de la db.
		return inst;
	}
	

}
