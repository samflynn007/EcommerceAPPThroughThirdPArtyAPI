package dev.venky.productservice.services;

import dev.venky.productservice.dtos.GenericProductDto;
import dev.venky.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {
    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id) throws NotFoundException;

    List<GenericProductDto> getProducts();

    GenericProductDto deleteProduct(Long id);
}
