package dev.venky.productservice.services;


import dev.venky.productservice.dtos.GenericProductDto;
import dev.venky.productservice.exceptions.NotFoundException;
import dev.venky.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductDto;
import dev.venky.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

   private FakeStoreProductServiceClient fakeStoreProductServiceClient;


    private GenericProductDto convertFakeStoreProductIntoGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto product =  new GenericProductDto();
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setId(fakeStoreProductDto.getId());

        return  product;
    }

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return convertFakeStoreProductIntoGenericProductDto(fakeStoreProductServiceClient.createProduct(product));
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
       return convertFakeStoreProductIntoGenericProductDto(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getProducts() {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductServiceClient.getProducts()) {
            genericProductDtos.add(convertFakeStoreProductIntoGenericProductDto(fakeStoreProductDto));
        }


        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
       return convertFakeStoreProductIntoGenericProductDto(fakeStoreProductServiceClient.deleteProduct(id));
    }
}
