package com.telusko.SpringEcom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

//is a JPA (Java Persistence API) annotation that tells Spring Boot/Hibernate: "This Java class represents a table in the database."
@Entity
@Data //is a Lombok annotation that automatically generates boilerplate code like getters, setters, constructors, toString(), equals(), and hashCode().
@NoArgsConstructor //is a Lombok annotation that generates a constructor with no parameters.
@AllArgsConstructor //is a Lombok annotation that generates a constructor with parameters for all fields in the class.
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //is a JPA annotation used with @Id to tell Hibernate:
    // "The database should automatically generate the primary key value."
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;
    private Date releaseDate;
    private boolean productAvailable;
    private int stockQuantity;

}
