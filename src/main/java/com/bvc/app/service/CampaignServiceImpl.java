package com.bvc.app.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bvc.app.entity.Campaign;
import com.bvc.app.entity.SummaryCampaign;
import com.bvc.app.helpers.ConexionDb;
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
	 //mayor a menor
	@Transactional(readOnly = true)
	public void serchColunmMayorAmenor(String column) {
		ConexionDb conex = new ConexionDb();
		SummaryCampaign Scampaign = null;
		ResultSet res = null;
		try {
			
			PreparedStatement consult = conex.getConnection().prepareStatement("SELECT name, "+column+" FROM campaign ORDER BY "+column+" DESC;");
			consult.setString(1, column);
			consult.setString(2, column);
			res = consult.executeQuery();
			if(column.equalsIgnoreCase("amount")) {
				Scampaign.setNmount((Collection<String>) res.getArray(column));
				data = "amount";
			}else if(column.equalsIgnoreCase("requestedAmount")) {
				Scampaign.setNrequestedAmount((Collection<String>) res.getArray(column));
				data = "requestedAmount";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
			try {
				conex.getConnection().close();
				if (res != null)
					res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
	}
	// menor a mayor
	@Transactional(readOnly = true)
	public void serchColunmMenorAmayor(String column) {
		ConexionDb conex = new ConexionDb();
		SummaryCampaign Scampaign = null;
		ResultSet res = null;
		try {
			
			PreparedStatement consult = conex.getConnection().prepareStatement("SELECT name, "+column+" FROM campaign ORDER BY "+column+" ASC;");
			consult.setString(1, column);
			consult.setString(2, column);
			res = consult.executeQuery();
			if(column.equalsIgnoreCase("amount")) {
				Scampaign.setNmount((Collection<String>) res.getArray(column));
				data = "amount";
			}else if(column.equalsIgnoreCase("requestedAmount")) {
				Scampaign.setNrequestedAmount((Collection<String>) res.getArray(column));
				data = "requestedAmount";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
			try {
				conex.getConnection().close();
				if (res != null)
					res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
	}
	
	@Transactional(readOnly = true)
	public Collection<String> returnList(String typeOrder) throws Exception {
        
		if((typeOrder.equalsIgnoreCase("mayor-menor")) && (data == "amount")) {
			order = SummaryCampaign.getNmount();
		}else if((typeOrder.equalsIgnoreCase("mayor-menor")) && (data == "requestedAmount")) {
			order = SummaryCampaign.getNrequestedAmount();	
		}else if((typeOrder.equalsIgnoreCase("menor-mayor"))&& (data == "amount")) {
			order = SummaryCampaign.getNmount();
		}else if((typeOrder.equalsIgnoreCase("menor-mayor"))&& (data == "requestedAmount")) {
			order = SummaryCampaign.getNrequestedAmount();
		}else {
			throw new Exception("Ingrese un orden valido "+ typeOrder);
		}
		return order;
	}
	
	

	
	
	

}
