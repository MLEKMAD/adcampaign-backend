package com.adcamaign.adcampaign.service;

import com.adcamaign.adcampaign.business.Campaign;
import com.adcamaign.adcampaign.business.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAllProducts();
    public Product addProduct(Product product);
    public List<Product> getProductsBySearch(String filter);
    public void linkProductToCampaign(Campaign campaign, long id);
    List<Product> getProductOfCampaign(Campaign campaign);
    void deleteProduct(long id);
}
