package com.telusko.SpringEcom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    @Id
    private int id;

    @ManyToOne
    private Product product;

    private int quantity;

    private BigDecimal totalPrice;

    @ManyToOne(fetch = FetchType.LAZY) //Controls when the related object is loaded.
    // fetch decides when the related entity is loaded.
// FetchType.LAZY  -> Loads the related entity only when it's accessed (better performance).
// FetchType.EAGER -> Loads the related entity immediately with the parent entity.
    private Order order;

}