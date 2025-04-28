package dev.sandeep.ProductServiceApr25.repository;

import dev.sandeep.ProductServiceApr25.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByDescription(String description);
    List<Product> findAllByDescriptionIgnoreCase(String description);
    Product findFirstByDescriptionIgnoreCase(String description);

}
/*
    Extending JpaRepository adds all fundamental CRUD operation methods in ProductRepository interface
    we dont need to implement those methods, Spring Data JPA will do that for us
    We will just use them directly

    Templates
    findAll
    findBy
    findFirst
    findLast

    findAllBy<ATTRIBUTENAME>IgnoreCase
    findAllByDescriptionIgnoreCase

    findAll     description     ignorecase
    SELECT * FROM TABLE WHERE <ATTRIBUTENAME> = "" IGNORE CASE;
    SELECT * FROM TABLE WHERE <Description> = "" IGNORE CASE;
 */