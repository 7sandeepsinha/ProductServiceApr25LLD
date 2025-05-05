package dev.sandeep.ProductServiceApr25.controller;

import dev.sandeep.ProductServiceApr25.dto.FakeStoreProductDTO;
import dev.sandeep.ProductServiceApr25.dto.ProductProjection;
import dev.sandeep.ProductServiceApr25.dto.ProductResponseDTO;
import dev.sandeep.ProductServiceApr25.model.Product;
import dev.sandeep.ProductServiceApr25.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/v1/product") // every API on this controller would be /v1/API
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/category/{id}")
    public ResponseEntity<List<ProductResponseDTO>> getAllProductsByCategory(@PathVariable("id") int categoryId) {
        List<Product> savedProducts = productService.getAllProductByCategoryId(categoryId);
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        for (Product product : savedProducts) {
            ProductResponseDTO responseDTO = new ProductResponseDTO(
                    product.getName(),
                    product.getDescription(),
                    product.getPrice(),
                    product.getRating()
            );
            productResponseDTOS.add(responseDTO);
        }
        return ResponseEntity.ok(productResponseDTOS);
    }

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/v1/product")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}") // localhost:8080/product/something
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id){
        Product savedProduct = productService.getProduct(id);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/product/desc/{description}") // localhost:8080/product/desc/something
    public ResponseEntity<List<Product>> getProductByDescription(@PathVariable("description") String description){
        List<Product> matchedProducts = productService.getProductByDescription(description);
        return ResponseEntity.ok(matchedProducts);
    }

    @GetMapping("/product/projection/{name}") // localhost:8080/product/desc/something
    public ResponseEntity<ProductProjection> getProductProjectionByName(@PathVariable("name") String name){
        ProductProjection projection = productService.getProductProjection(name);
        return ResponseEntity.ok(projection);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Boolean> deleteProductById(@PathVariable("id") int productId){
        boolean response = productService.deleteProduct(productId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/fake")
    public FakeStoreProductDTO[] getAllProductsFromFakeStore() {
        return productService.getAllProductsFromFakeStore();
    }

    @GetMapping("/product/{id}/fake")
    public FakeStoreProductDTO getProductFromFakeStore(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }
}
// break -> 10:08 PM
// localhost:8080/ ---> all APIs
// tunnelURL/api