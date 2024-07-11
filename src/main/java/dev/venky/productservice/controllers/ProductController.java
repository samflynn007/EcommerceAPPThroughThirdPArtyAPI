package dev.venky.productservice.controllers;

import dev.venky.productservice.dtos.GenericProductDto;
import dev.venky.productservice.exceptions.NotFoundException;
import dev.venky.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<GenericProductDto> getAllProducts() {
       return productService.getProducts();
    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") long id) throws NotFoundException {
        return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") long id) {
//        ResponseEntity<GenericProductDto> response = new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.NOT_FOUND);

//        return response;
        return productService.deleteProduct(id);
    }


    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        return productService.createProduct(product);
    }

    @PutMapping("{id}")
    public void updateProductById() {}
}
