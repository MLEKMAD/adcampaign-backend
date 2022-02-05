package com.adcamaign.adcampaign.service;

import com.adcamaign.adcampaign.business.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAllProducts();
    public Product addProduct(String image, String name, String brand, Integer quantity, Double price);
    public List<Product> getProductsBySearch(String filter);
}
