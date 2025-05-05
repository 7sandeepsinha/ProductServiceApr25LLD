package dev.sandeep.ProductServiceApr25.controller;

import dev.sandeep.ProductServiceApr25.dto.CategoryRequestDTO;
import dev.sandeep.ProductServiceApr25.dto.CategoryResponseDTO;
import dev.sandeep.ProductServiceApr25.model.Category;
import dev.sandeep.ProductServiceApr25.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO){
        Category savedCategory = categoryService.createCategory(categoryRequestDTO);
        CategoryResponseDTO categoryResponseDTO =
                new CategoryResponseDTO(savedCategory.getName(), savedCategory.getDescription());
        return ResponseEntity.ok(categoryResponseDTO);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable("id") int id){
        Category savedCategory = categoryService.getCategory(id);
        CategoryResponseDTO categoryResponseDTO =
                new CategoryResponseDTO(savedCategory.getName(), savedCategory.getDescription());
        return ResponseEntity.ok(categoryResponseDTO);
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        List<CategoryResponseDTO> categoryResponseDTOS = new ArrayList<>();
        for(Category category : categories){
            CategoryResponseDTO responseDTO = new CategoryResponseDTO(
                    category.getName(), category.getDescription()
            );
            categoryResponseDTOS.add(responseDTO);
        }
        return ResponseEntity.ok(categoryResponseDTOS);
    }

    @GetMapping("/category/product/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryFromProduct(@PathVariable("id") int productId){
        Category category = categoryService.getCategoryFromProduct(productId);
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO(
                category.getName(), category.getDescription()
        );
        return ResponseEntity.ok(categoryResponseDTO);
    }

}
