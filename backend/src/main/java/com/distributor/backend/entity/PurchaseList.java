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
// @IdClass(PurchaseListId.class) // Composite Key Class
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
}
