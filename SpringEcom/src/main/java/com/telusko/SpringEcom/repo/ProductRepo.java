package com.telusko.SpringEcom.repo;

import com.telusko.SpringEcom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> { //extending this jpa repositories because it has lots of
    //default methods to work with in database
}
