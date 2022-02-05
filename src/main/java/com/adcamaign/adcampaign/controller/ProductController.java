package com.adcamaign.adcampaign.controller;

import com.adcamaign.adcampaign.business.Campaign;
import com.adcamaign.adcampaign.business.Company;
import com.adcamaign.adcampaign.business.Product;
import com.adcamaign.adcampaign.service.CampaignService;
import com.adcamaign.adcampaign.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    private CampaignService campaignService;

    public ProductController(ProductService productService, CampaignService campaignService) {
        this.productService = productService;
        this.campaignService = campaignService;
    }


    @GetMapping(value="/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProducts(){
        return productService.findAllProducts();
    }

    @GetMapping(value="/products/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProductsOfCampaign(@PathVariable long id){
        Campaign campaign = campaignService.getCampaign(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.getProductOfCampaign(campaign));
    }

    @PostMapping(value="/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
    }


    @DeleteMapping(value="/products/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCampaign(@PathVariable long id){
        productService.deleteProduct(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
