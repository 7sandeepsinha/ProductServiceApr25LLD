package dev.sandeep.ProductServiceApr25.service;

import dev.sandeep.ProductServiceApr25.client.FakeStoreClient;
import dev.sandeep.ProductServiceApr25.dto.FakeStoreProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    public FakeStoreProductDTO[] getAllProductsFromFakeStore(){
        return fakeStoreClient.getAllProducts();
    }

    public FakeStoreProductDTO getProductById(int productId){
        return fakeStoreClient.getProduct(productId);
    }

}
