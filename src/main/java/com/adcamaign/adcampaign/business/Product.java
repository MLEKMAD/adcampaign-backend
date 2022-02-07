package com.adcamaign.adcampaign.business;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Téo BERARD
 * This class manages the product model
 */

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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNb_clicks(Integer nb_clicks) {
        this.nb_clicks = nb_clicks;
    }

    public void setNb_views(Integer nb_views) {
        this.nb_views = nb_views;
    }

    public void setNb_sales(Integer nb_sales) {
        this.nb_sales = nb_sales;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

