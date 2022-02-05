package com.adcamaign.adcampaign.business;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company {
    private @Id
    @GeneratedValue
    long id;
    private String name;


    @OneToMany(mappedBy = "company", orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Campaign> campaigns;

    public Company() {
        this.campaigns = new HashSet<Campaign>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addCampaign(Campaign campaign){
        campaigns.add(campaign);
    }
}



