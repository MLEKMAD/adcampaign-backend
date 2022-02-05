package com.adcamaign.adcampaign.service.serviceImpl;

import com.adcamaign.adcampaign.business.Product;
import com.adcamaign.adcampaign.dao.ProductRepository;
import com.adcamaign.adcampaign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Product addProduct(String image, String name, String brand, Integer quantity, Double price) {
        Product product = new Product();
        product.setBrand(brand);
        product.setImage(image);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> getProductsBySearch(String filter) {
        List<Product> products = productRepository.findByNameContaining(filter);
        return products;
    }
}
