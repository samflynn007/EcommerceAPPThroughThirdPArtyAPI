package dev.venky.productservice.services;

import dev.venky.productservice.dtos.GenericProductDto;

public interface ProductService {
    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id);
}
