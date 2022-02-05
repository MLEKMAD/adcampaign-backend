package com.adcamaign.adcampaign.service;

import com.adcamaign.adcampaign.business.Campaign;
import com.adcamaign.adcampaign.business.Company;

import java.time.LocalDateTime;
import java.util.List;

public interface CampaignService {
    Campaign addCampaign(Campaign campaign);
    Campaign addCampaign(String name, LocalDateTime startingDate, LocalDateTime endingDate, Company company, String description, Double budget);
    List<Campaign> getAllCampaigns();
    List<Campaign> getCampaigns(Company company);
    Campaign updateCampaign(long id, Campaign newCampaign);
    Campaign updateCampaign(long id, String name, LocalDateTime ending_date, Company company, String description, Double budget );
}
