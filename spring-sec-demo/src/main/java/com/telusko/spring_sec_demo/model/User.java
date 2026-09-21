package com.telusko.spring_sec_demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //is used to automatically generate the primary key (id)
    // value when a new entity is inserted into the database.
    private int id;
    private String username;
    private String password;

}