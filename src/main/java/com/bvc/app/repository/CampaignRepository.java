package com.bvc.app.repository;



import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.bvc.app.entity.Campaign;

@Configuration
@EnableJpaRepositories("com.acme.repositories")
@Repository
public interface CampaignRepository extends JpaRepository<Campaign,Long> {
	//mayor a menor requestedamount
	@Query(value = "SELECT name, requested_amount, idcampaign, amount, admin_rate FROM campaign ORDER BY requested_amount DESC;",
			nativeQuery = true)
	List<Campaign>RequestedamountDESC();
	
	//mayor a menor amount
	@Query(value = "SELECT name, requested_amount, idcampaign, amount, admin_rate FROM campaign ORDER BY amount DESC;",
			nativeQuery = true)
	List<Campaign>amountDESC();
	
	//menor a mayor requestedamount
	@Query(value = "SELECT name, requested_amount, idcampaign, amount, admin_rate FROM campaign ORDER BY requested_amount ASC;",
			nativeQuery = true)
	List<Campaign>RequestedamountASC();
	
	//menor a mayor amount
	@Query(value = "SELECT name, requested_amount, idcampaign, amount, admin_rate FROM campaign ORDER BY amount ASC;",
			nativeQuery = true)
	List<Campaign>amountASC();

}
	
	/*@Bean
	List<Campaign>findByNameOrderByAmountDesc(String name);
	@Bean
	List<Campaign>findByNameOrderByAmountAsc(String name);
	@Bean
	List<Campaign>findByNameOrderByRequestedamountDesc(String name);
	@Bean
	List<Campaign>findByNameOrderByRequestedamountAsc(String name);
}*/

//findByAgeOrderByLastnameDesc