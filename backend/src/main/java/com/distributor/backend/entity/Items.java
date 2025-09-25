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
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Tax_Rate")
    private Double tax;

    @Column(name = "Company", nullable = false)
    private String company;

    @Column(name = "Available_Quantity")
    private Long stock;

    @Column(name = "Cost_Price")
    private Double c_price;

    @Column(name = "Selling_Price")
    private Double s_price;

    @Column(name = "Max_Retail_Price")
    private Double mrp;

    @Column(name = "Weight")
    private String weight;
}
