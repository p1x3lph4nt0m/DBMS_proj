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
@Table(name = "SalesBook")
public class SalesBook {

    @Id
    @Column(name = "Bill_Number")
    private Long billNumber;

    @Column(name = "Order_Day", nullable = false)
    private int orderDay;

    @Column(name = "Order_Month", nullable = false)
    private int orderMonth;

    @Column(name = "Order_Year", nullable = false)
    private int orderYear;

    @Column(name = "Carrier", nullable = false)
    private String carrier;

    @Column(name = "Customer", nullable = false)
    private String customer;
}
