package com.telusko.SpringEcom.repo;

import com.telusko.SpringEcom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
     //extending this jpa repositories because it has lots of
    //default methods to work with in database
     @Query("SELECT p from Product p WHERE " +
             "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
             "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
             "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
             "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))") //this is known as JPQL, this query annotation
     //is used to search the products using JPQL language.
     List<Product> searchProducts(String keyword);
}
