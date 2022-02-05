package com.adcamaign.adcampaign.service;

import com.adcamaign.adcampaign.business.Company;

import java.util.List;

public interface CompanyService {
    Company addCompany(Company company);
    List<Company> getCompanies();
    Company getCompany(long id);
    void deleteCompany(long id);
}
