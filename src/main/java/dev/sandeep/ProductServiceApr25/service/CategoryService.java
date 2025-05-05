package dev.sandeep.ProductServiceApr25.service;

import dev.sandeep.ProductServiceApr25.dto.CategoryRequestDTO;
import dev.sandeep.ProductServiceApr25.exception.CategoryNotFoundException;
import dev.sandeep.ProductServiceApr25.exception.DuplicateCategoryNameException;
import dev.sandeep.ProductServiceApr25.model.Category;
import dev.sandeep.ProductServiceApr25.model.Product;
import dev.sandeep.ProductServiceApr25.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductService productService;

    public Category createCategory(CategoryRequestDTO categoryRequestDTO){
        Optional<Category> categoryOptional = categoryRepository.findByName(categoryRequestDTO.getCategoryName());
        if(categoryOptional.isPresent()){
            throw new DuplicateCategoryNameException("Duplicate category name " + categoryRequestDTO.getCategoryName());
        }
        Category category = new Category();
        category.setName(categoryRequestDTO.getCategoryName());
        category.setDescription(categoryRequestDTO.getCategoryDescription());
        return categoryRepository.save(category);
    }

    public Category getCategory(int categoryId){
        Category savedCategory = categoryRepository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException("Category not found, categoryID : " + categoryId)
        );
        return savedCategory;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public List<Product> getAllProductsByCategory(int categoryId){
        Category savedCategory = getCategory(categoryId);
        List<Product> products = savedCategory.getProducts();
        return products;
    }

    public Category getCategoryFromProduct(int productId){
        Product product = productService.getProduct(productId);
        Category category = categoryRepository.findByProductsIn(List.of(product)).orElseThrow(
                () -> new CategoryNotFoundException("Category Not found")
        );
        return category;
    }
}

