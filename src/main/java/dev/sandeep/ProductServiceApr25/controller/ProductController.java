package dev.sandeep.ProductServiceApr25.controller;

import dev.sandeep.ProductServiceApr25.dto.*;
import dev.sandeep.ProductServiceApr25.model.Product;
import dev.sandeep.ProductServiceApr25.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/v1/product") // every API on this controller would be /v1/API
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/create/{n}")
    public ResponseEntity<Boolean> createProduct(@PathVariable("n") Integer n) {
        return ResponseEntity.ok(productService.createNProducts(n));
    }

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody ProductReqDTO productReqDTO){
        Product savedProduct = productService.saveProduct(productReqDTO);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/all/product/{pageNumber}/{ascFilter}/{descFilter}")
    public ResponseEntity<Page<Product>> getAllProducts(@PathVariable("pageNumber") int pageNumber,
                                                        @PathVariable("ascFilter") String ascFilter,
                                                        @PathVariable("descFilter") String descFilter ){
        Page<Product> products = productService.getAllProductsPaginated(pageNumber, ascFilter, descFilter);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/all/product/{pageNumber}")
    public ResponseEntity<Page<Product>> getAllProducts(@PathVariable("pageNumber") int pageNumber,
                                                        @RequestBody List<SortDTO> sortDTOs){
        Page<Product> products = productService.getAllProductsPaginated(pageNumber, sortDTOs);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/all/product")
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

//    @GetMapping("/product/category/{categoryId}")
//    public ResponseEntity<List<ProductResponseDTO>> getProductByCategory(@PathVariable("categoryId") int categoryId) {
//        List<Product> products = productService.getProductByCategoryId(categoryId);
//        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
//        for (Product product : products) {
//            ProductResponseDTO productResponseDTO = new ProductResponseDTO(
//                    product.getName(),
//                    product.getDescription(),
//                    product.getPrice(),
//                    product.getRating()
//            );
//            );
//            productResponseDTOS.add(productResponseDTO);
//        }
//        return ResponseEntity.ok(productResponseDTOS);
//    }
}