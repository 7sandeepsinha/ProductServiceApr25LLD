package dev.sandeep.ProductServiceApr25.controller;

import dev.sandeep.ProductServiceApr25.dto.FakeStoreProductDTO;
import dev.sandeep.ProductServiceApr25.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public FakeStoreProductDTO[] getAllProducts() {
        return productService.getAllProductsFromFakeStore();
    }

    @GetMapping("/product/{id}")
    public FakeStoreProductDTO getProduct(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }
}
