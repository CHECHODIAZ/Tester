package com.bvc.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bvc.app.entity.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign,Long> {
     
}
