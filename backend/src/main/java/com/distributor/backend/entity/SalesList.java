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
@IdClass(SalesListId.class) // Composite Key Class
public class SalesList {

    @Id
    @Column(name = "Bill_Number")
    private Long billNumber;

    @Id
    @Column(name = "Item_Id")
    private Long itemId;

    @Column(name = "Discount")
    private Double discount;

    @Column(name = "Quantity")
    private Long quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Bill_Number", insertable = false, updatable = false )
    private SalesBook salesBook;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Item_Id", insertable = false, updatable = false)
    private Items item;
}
