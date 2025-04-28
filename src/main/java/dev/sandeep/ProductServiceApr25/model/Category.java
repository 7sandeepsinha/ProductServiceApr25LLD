package dev.sandeep.ProductServiceApr25.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Category extends BaseModel {
//    @OneToMany // @OneToOne // @ManyToMany
//    @JoinColumn(name = "category_id")
//    private List<Product> products;

//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }
}
