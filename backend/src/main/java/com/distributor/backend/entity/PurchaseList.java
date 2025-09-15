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
    private Long billNumber;

    @Id
    @Column(name = "Item_Id")
    private Long itemId;

    @Column(name = "Discount")
    private Double discount;

    @Column(name = "Quantity")
    private Long quantity;

    // Foreign key to PurchaseBook
    @ManyToOne
    @JoinColumn(name = "Bill_Number", insertable = false, updatable = false)
    private PurchaseBook purchaseBook;

    // Foreign key to Items
    @ManyToOne
    @JoinColumn(name = "Item_Id", insertable = false, updatable = false)
    private Items item;
}
