package dev.venky.productservice.controllers;

import dev.venky.productservice.dtos.GenericProductDto;
import dev.venky.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    public  ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
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
    public String createProduct() {
        return "Create New product:  " + UUID.randomUUID();
    }

    @PutMapping("{id}")
    public void updateProductById() {}
}
