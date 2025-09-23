package com.distributor.backend.entity;

import java.io.Serializable;
import java.util.Objects;

public class PurchaseListId implements Serializable {

    private Long bill_number;
    private Long item_id;

    public PurchaseListId() {}

    public PurchaseListId(Long bill_number, Long item_id) {
        this.bill_number = bill_number;
        this.item_id = item_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseListId)) return false;
        PurchaseListId that = (PurchaseListId) o;
        return Objects.equals(bill_number, that.bill_number) &&
               Objects.equals(item_id, that.item_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bill_number, item_id);
    }

}
