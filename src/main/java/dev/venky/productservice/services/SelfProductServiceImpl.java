package dev.venky.productservice.services;

import dev.venky.productservice.dtos.GenericProductDto;
import dev.venky.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {
    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }
}
