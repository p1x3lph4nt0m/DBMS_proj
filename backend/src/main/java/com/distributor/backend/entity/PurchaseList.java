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
@Table(name = "PurchaseList")
@IdClass(PurchaseListId.class) // Composite Key Class
public class PurchaseList {

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

    // Foreign key to PurchaseBook
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Bill_Number", insertable = false, updatable = false)
    private PurchaseBook purchaseBook;

    // Foreign key to Items
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Item_Id", insertable = false, updatable = false)
    private Items item;
}
