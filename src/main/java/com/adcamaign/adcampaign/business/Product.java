package com.adcamaign.adcampaign.business;


import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
public class Product {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String image;
    private String name;
    private String brand;
    private Integer quantity;
    private double price;
    private Integer nb_clicks;
    private Integer nb_views;
    private Integer nb_sales;

    @ManyToOne()
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Campaign campaign;


    public void setPrice(double price1) {
        this.price = price1;

    }

    public void setName(String name1) {
        this.name = name1;
    }

    public Integer getNb_clicks() {
        return nb_clicks;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Integer getNb_views() {
        return nb_views;
    }

    public Integer getNb_sales() {
        return nb_sales;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setQuantity(Integer quantity1) {
        this.quantity = quantity1;

    }

}

