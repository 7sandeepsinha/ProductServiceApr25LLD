package dev.sandeep.ProductServiceApr25.repository;

import dev.sandeep.ProductServiceApr25.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
/*
    Extending JpaRepository adds all fundamental CRUD operation methods in ProductRepository interface
    we dont need to implement those methods, Spring Data JPA will do that for us
    We will just use them directly
 */