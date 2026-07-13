package com.telusko.SpringEcom.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    private Long id;
    @Column(unique = true)
    private String orderId;
    private String customerName;
    private String email;
    private String status;
    private LocalDate orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}

// @OneToMany -> One parent can have multiple child entities.
// mappedBy = "order" -> 'order' is the field in the child entity that owns the relationship.
// cascade = CascadeType.ALL -> Operations (save, update, delete, etc.) on the parent are automatically applied to its children.
//mappedBy = "order" refers to the order field in OrderItem.
//CascadeType.ALL means if you save or delete an Order, all its OrderItems are saved or deleted automatically.
