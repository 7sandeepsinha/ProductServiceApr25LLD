package dev.sandeep.ProductServiceApr25.service;

import dev.sandeep.ProductServiceApr25.client.FakeStoreClient;
import dev.sandeep.ProductServiceApr25.dto.FakeStoreProductDTO;
import dev.sandeep.ProductServiceApr25.exception.ProductNotFoundException;
import dev.sandeep.ProductServiceApr25.model.Product;
import dev.sandeep.ProductServiceApr25.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private FakeStoreClient fakeStoreClient;
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    public boolean deleteProduct(int productId){
        productRepository.deleteById(productId);
        return true;
    }

    public Product getProduct(int productId){
        Optional<Product> productOptional =
                productRepository.findById(productId);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        } else {
            return productOptional.get();
        }
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product updateProduct(Product newProduct, int productId){
        Product savedProduct = getProduct(productId);
        newProduct.setId(productId);
        Product updatedProduct = productRepository.save(newProduct);
        return updatedProduct;
    }

    public FakeStoreProductDTO[] getAllProductsFromFakeStore(){
        return fakeStoreClient.getAllProducts();
    }

    public FakeStoreProductDTO getProductById(int productId){
        return fakeStoreClient.getProduct(productId);
    }

}
