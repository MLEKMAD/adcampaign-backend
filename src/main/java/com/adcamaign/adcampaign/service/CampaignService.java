package com.adcamaign.adcampaign.service;

import com.adcamaign.adcampaign.business.Campaign;
import com.adcamaign.adcampaign.business.Company;

import java.time.LocalDateTime;
import java.util.List;

public interface CampaignService {
    Campaign addCampaign(Campaign campaign);
    List<Campaign> getAllCampaigns();
    Campaign getCampaign(long id);
    List<Campaign> getCampaigns(Company company);
    Campaign updateCampaign(long id, Campaign newCampaign);

    void deleteCampaign(long id);
}
