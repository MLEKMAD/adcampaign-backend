package com.adcamaign.adcampaign.controller;

import com.adcamaign.adcampaign.business.Campaign;
import com.adcamaign.adcampaign.business.Company;
import com.adcamaign.adcampaign.service.CampaignService;
import com.adcamaign.adcampaign.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CampaignController {
    private CampaignService campaignService;
    private CompanyService companyService;

    public CampaignController(CampaignService campaignService, CompanyService companyService) {
        this.campaignService = campaignService;
        this.companyService = companyService;
    }

    @GetMapping("/campaigns")
    public List<Campaign> getCampaigns(){
        return campaignService.getAllCampaigns();
    }
    @GetMapping("/campaigns/company/{id}")
    public List<Campaign> getCampaignsOfCompany(@PathVariable Long id){
        Company company = companyService.getCompany(id);
        return campaignService.getCampaigns(company);
    }

    @PostMapping(value="/campaigns", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Campaign> addCampaign(@RequestBody Campaign campaign){
        return ResponseEntity.status(HttpStatus.CREATED).body(campaignService.addCampaign(campaign));
    }
    @PutMapping(value="/campaigns/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Campaign> updateCampaign(@PathVariable long id, @RequestBody Campaign campaign){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(campaignService.updateCampaign(id, campaign));
    }

}
