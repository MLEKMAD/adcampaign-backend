package com.adcamaign.adcampaign.dao;

import com.adcamaign.adcampaign.business.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {


}
