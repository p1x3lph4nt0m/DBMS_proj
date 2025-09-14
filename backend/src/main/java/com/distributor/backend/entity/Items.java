package com.distributor.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "Name", nullable = false, unique = true)
    private String name;

    @Column(name = "Tax_Rate")
    private Double taxRate;

    @Column(name = "Company", nullable = false)
    private String company;

    @Column(name = "Available_Quantity")
    private Long quantity;

    @Column(name = "Selling_Price")
    private Double sp;

    @Column(name = "Max_Retail_Price")
    private Double mrp;

    @Column(name = "Weight")
    private Double wt;
}
