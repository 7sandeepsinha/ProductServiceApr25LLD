package dev.sandeep.ProductServiceApr25.repository;

import dev.sandeep.ProductServiceApr25.model.Category;
import dev.sandeep.ProductServiceApr25.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByName(String name);
    Optional<Category> findByProductsIn(List<Product> products);
}
