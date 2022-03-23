package com.bvc.app.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bvc.app.entity.Campaign;
import com.bvc.app.service.CampaignService;

@RestController
@RequestMapping("/api/campaign")
public class CampaignControlller {
    @Autowired
    private CampaignService campaignService;
    
    //Create new campaign
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Campaign campaign){
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(campaignService.save(campaign));
    	
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable(value = "id") Long campaignId){
    	Optional<Campaign> opCompaign = campaignService.findById(campaignId);
    	
    	if(!opCompaign.isPresent()) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	return ResponseEntity.ok(opCompaign);
    }
    // Update an campaign
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody Campaign campaignDatails, @PathVariable (value = "id") Long campaignId){
    	 Optional<Campaign> campaign = campaignService.findById(campaignId);
    	 
    	 if(!campaign.isPresent()) {
    		 return ResponseEntity.notFound().build();
    	 }
    	 
    	 campaign.get().setName(campaignDatails.getName());
    	 campaign.get().setAdminRate(campaignDatails.getAdminRate());
    	 campaign.get().setAmount(campaignDatails.getAmount());
    	 campaign.get().setRequestedAmount(campaignDatails.getRequestedAmount());
    	 
    	 return ResponseEntity.status(HttpStatus.CREATED).body(campaignService.save(campaign.get()));
    	 
    }
    
    //Delete an campaign
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value = "id") Long campaignId) {
    	if(!campaignService.findById(campaignId).isPresent()) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	campaignService.deleteById(campaignId);
    	return ResponseEntity.ok().build();
    }
    
    // Read all campaigns
    @GetMapping
    public List<Campaign> readAll(){
    	List<Campaign> campaigns = StreamSupport
    			.stream(campaignService.findAll().spliterator(), false)
    			.collect(Collectors.toList());
    	
    	return campaigns;
    }

    @GetMapping("/amount/{order}")
    public Collection<String> readOrderedColunm(@PathVariable String order){
    	Collection<String> result = null;
    	try {
    		campaignService.serchColunmMenorAmayor("amount");
    		result = campaignService.returnList(order);
		} catch (Exception e) {
		  e.printStackTrace();
		}
      return result;
    }
    
    @GetMapping("/requestedAmount/{order}")
    public Collection<String> readOrderedColunm2(@PathVariable String order){
    	Collection<String> result2 = null;
    	try {
    		campaignService.serchColunmMenorAmayor("requestedAmount");
    		result2 = campaignService.returnList(order);
		} catch (Exception e) {
		  e.printStackTrace();
		}

      return result2;
    }
    
    
    
   
    
}
