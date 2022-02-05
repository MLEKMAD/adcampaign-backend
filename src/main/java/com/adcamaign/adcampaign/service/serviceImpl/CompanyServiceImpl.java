package com.adcamaign.adcampaign.service.serviceImpl;

import com.adcamaign.adcampaign.business.Company;
import com.adcamaign.adcampaign.dao.CompanyRepository;
import com.adcamaign.adcampaign.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies;
    }

    @Override
    public Company getCompany(long id) {
        Company company = companyRepository.getById(id);
        return company;
    }

    @Override
    public void deleteCompany(long id) {
        Company company = companyRepository.findById(id).orElse(null);
        if (company != null){
            companyRepository.delete(company);
        }

    }

}
