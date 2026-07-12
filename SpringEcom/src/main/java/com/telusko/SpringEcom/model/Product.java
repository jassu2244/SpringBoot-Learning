package com.telusko.SpringEcom.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy") //this tells how to show date in frontend
    private Date releaseDate;
    private boolean productAvailable;
    private int stockQuantity;
    private String imageName;
    private String imageType;
    @Lob //this means LargeObject
    private byte[] imageData;

    public Product(int id) {
        this.id = id;
    }
}
