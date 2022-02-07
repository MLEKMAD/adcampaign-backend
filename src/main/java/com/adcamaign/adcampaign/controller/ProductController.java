package com.adcamaign.adcampaign.controller;

import com.adcamaign.adcampaign.business.Campaign;
import com.adcamaign.adcampaign.business.Company;
import com.adcamaign.adcampaign.business.Product;
import com.adcamaign.adcampaign.service.CampaignService;
import com.adcamaign.adcampaign.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private ProductService productService;
    private CampaignService campaignService;

    public ProductController(ProductService productService, CampaignService campaignService) {
        this.productService = productService;
        this.campaignService = campaignService;
    }


    @GetMapping(value="/products")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Product> getProducts(){
        return productService.findAllProducts();
    }

    @GetMapping(value="/products/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getProductsOfCampaign(@PathVariable long id){
        Campaign campaign = campaignService.getCampaign(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.getProductOfCampaign(campaign));
    }
    @PostMapping(value="/products/search")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getProducts(@RequestBody String filter){
        System.out.println("called " + filter);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.getProductsBySearch(filter));
    }

    @PostMapping(value="/products")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
    }


    @DeleteMapping(value="/products/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity deleteCampaign(@PathVariable long id){
        productService.deleteProduct(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PostMapping(value="/products/link/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity linkProductToCampaign(@PathVariable long id,  @RequestBody Campaign campaign){
        productService.linkProductToCampaign(campaign, id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PostMapping(value="/products/campaign/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Campaign> addProductToCampaign(@PathVariable long id,  @RequestBody Campaign campaign){
        productService.addProductToCampaign(id, campaign);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
