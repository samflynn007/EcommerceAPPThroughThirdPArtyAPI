package dev.venky.productservice.services;

import dev.venky.productservice.dtos.GenericProductDto;
import dev.venky.productservice.models.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {
    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }


    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public List<GenericProductDto> getProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }
}
