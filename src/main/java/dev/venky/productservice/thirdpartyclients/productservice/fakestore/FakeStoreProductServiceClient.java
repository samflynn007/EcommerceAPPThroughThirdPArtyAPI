package dev.venky.productservice.thirdpartyclients.productservice.fakestore;

import dev.venky.productservice.dtos.GenericProductDto;
import dev.venky.productservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreProductServiceClient  {

    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.url}")
    private String fakeApiBaseUrl;

    @Value("${fakestore.api.paths.product}")
    private String fakeStoreProductApiPath;

    private String specificProductRequestUrl = fakeApiBaseUrl + fakeStoreProductApiPath + "/{id}";
    private String productRequestBaseUrl = fakeApiBaseUrl + fakeStoreProductApiPath;


    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(
                productRequestBaseUrl, product, FakeStoreProductDto.class
        );
        return response.getBody();
    }

    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        if (fakeStoreProductDto == null) {
            throw new NotFoundException("Product with id: " + id + " doesn't exist. ");
        }
        return fakeStoreProductDto;
    }

    public List<FakeStoreProductDto> getProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        Class<FakeStoreProductDto> List;
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productRequestBaseUrl, FakeStoreProductDto[].class);
        List<GenericProductDto> answer = new ArrayList<>();
        return Arrays.stream(response.getBody()).toList();
    }

    public FakeStoreProductDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(GenericProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return response.getBody();
    }

}
