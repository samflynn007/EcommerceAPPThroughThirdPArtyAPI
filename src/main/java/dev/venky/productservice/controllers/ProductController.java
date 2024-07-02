package dev.venky.productservice.controllers;

import dev.venky.productservice.dtos.GenericProductDto;
import dev.venky.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final RestTemplateBuilder restTemplateBuilder;
    private ProductService productService;

    public  ProductController(@Qualifier("fakeStoreProductService") ProductService productService, RestTemplateBuilder restTemplateBuilder){
        this.productService = productService;
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @GetMapping
    public void getAllProducts() {}

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public void deleteProductById(long id) {}

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        return productService.createProduct(product);
    }

    @PutMapping("{id}")
    public void updateProductById() {}
}
