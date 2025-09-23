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
@Table(name = "SalesList")
@IdClass(SalesListId.class)
public class SalesList {

    @Id
    @Column(name = "Bill_Number")
    private Long bill_number;

    @Id
    @Column(name = "Item_Id")
    private Long item_id;

    @Column(name = "Discount")
    private Double discount;

    @Column(name = "Quantity")
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "Bill_Number", insertable = false, updatable = false )
    private SalesBook salesBook;

    @ManyToOne
    @JoinColumn(name = "Item_Id", insertable = false, updatable = false)
    private Items item;
}
