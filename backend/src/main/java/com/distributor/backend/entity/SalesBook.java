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
    private Long bill_number;

    @Column(name = "Order_Day", nullable = false)
    private int order_day;

    @Column(name = "Order_Month", nullable = false)
    private int order_month;

    @Column(name = "Order_Year", nullable = false)
    private int order_year;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "Carrier", referencedColumnName = "license")
    private Driver carrier;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "Customer", referencedColumnName = "gst")
    private Buyer customer;
}
