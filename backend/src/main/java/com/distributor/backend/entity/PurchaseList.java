package com.distributor.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@IdClass(PurchaseListId.class)
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

    @ManyToOne
    @JoinColumn(name = "Bill_Number", insertable = false, updatable = false)
    private PurchaseBook purchaseBook;

    @ManyToOne
    @JoinColumn(name = "Item_Id", insertable = false, updatable = false)
    private Items item;
}
