package com.adcamaign.adcampaign.controller;

import com.adcamaign.adcampaign.business.Company;
import com.adcamaign.adcampaign.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping(value="/companies", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    @GetMapping(value="/companies/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Company> getCampaign(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.getCompany(id));
    }

    @PostMapping(value="/companies", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Company> addCampaign(@RequestBody Company company){
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.addCompany(company));
    }


    @DeleteMapping(value="/companies/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCampaign(@PathVariable long id){
        companyService.deleteCompany(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
