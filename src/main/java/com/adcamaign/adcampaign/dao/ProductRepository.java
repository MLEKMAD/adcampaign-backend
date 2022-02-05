package com.adcamaign.adcampaign.dao;

import com.adcamaign.adcampaign.business.Campaign;
import com.adcamaign.adcampaign.business.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String filtre);

    List<Product> findByCampaign(Campaign campaign);


}
