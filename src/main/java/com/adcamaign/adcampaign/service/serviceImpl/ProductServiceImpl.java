package com.adcamaign.adcampaign.service.serviceImpl;

import com.adcamaign.adcampaign.business.Campaign;
import com.adcamaign.adcampaign.business.Product;
import com.adcamaign.adcampaign.dao.ProductRepository;
import com.adcamaign.adcampaign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProductsBySearch(String filter) {
        List<Product> products = new ArrayList<>();
        products = productRepository.findByNameContaining(filter);
        System.out.println("products " + products.toString());
        return products;
    }

    @Override
     public void linkProductToCampaign(Campaign campaign, long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setCampaign(campaign);
            productRepository.save(product);
        }
    }

    @Override
    public List<Product> getProductOfCampaign(Campaign campaign) {
        return productRepository.findByCampaign(campaign);
    }

    @Override
    public void deleteProduct(long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            productRepository.delete(product);
        }
    }

    @Override
    public void addProductToCampaign(long id, Campaign campaign) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setCampaign(campaign);
            productRepository.save(product);
        }
    }
}
