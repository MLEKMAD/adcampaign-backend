package com.adcamaign.adcampaign.service.serviceImpl;

import com.adcamaign.adcampaign.business.Campaign;
import com.adcamaign.adcampaign.business.Company;
import com.adcamaign.adcampaign.dao.CampaignRepository;
import com.adcamaign.adcampaign.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    private CampaignRepository campaignRepository;

    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Campaign addCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    @Override
    public Campaign addCampaign(String name, LocalDateTime startingDate, LocalDateTime endingDate, Company company, String description, Double budget) {
        Campaign campaign = new Campaign();
        campaign.setName(name);
        campaign.setCompany(company);
        campaign.setStartingDate(startingDate);
        campaign.setEndingDate(endingDate);
        campaign.setDescription(description);
        campaign.setBudget(budget);
        campaignRepository.save(campaign);
        return campaign;
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        List<Campaign> campaigns = campaignRepository.findAll();
        return campaigns;
    }

    @Override
    public List<Campaign> getCampaigns(Company company) {
        List<Campaign> campaigns = campaignRepository.findByCompany(company);
        return campaigns;
    }

    @Override
    public Campaign updateCampaign(long id, Campaign newCampaign) {
        Campaign campaign = campaignRepository.findById(id).orElse(null);
        if (campaign != null) {
            campaign.setName(newCampaign.getName());
            campaign.setCompany(newCampaign.getCompany());
            campaign.setEndingDate(newCampaign.getEndingDate());
            campaign.setDescription(newCampaign.getDescription());
            campaign.setBudget(newCampaign.getBudget());
            campaignRepository.save(campaign);
        }
        return campaign;
    }

    @Override
    public Campaign updateCampaign(long id, String name, LocalDateTime endingDate, Company company, String description, Double budget) {
        Campaign campaign = campaignRepository.findById(id).orElse(null);
        if (campaign != null) {
            campaign.setName(name);
            campaign.setCompany(company);
            campaign.setEndingDate(endingDate);
            campaign.setDescription(description);
            campaign.setBudget(budget);
            campaignRepository.save(campaign);
        }
        return campaign;
    }
}
