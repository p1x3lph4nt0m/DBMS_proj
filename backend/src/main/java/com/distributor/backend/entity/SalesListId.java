package com.distributor.backend.entity;

import java.io.Serializable;
import java.util.Objects;

public class SalesListId implements Serializable {

    private Long bill_number;
    private Long item_id;

    public SalesListId() {
    }

    public SalesListId(Long bill_number, Long item_id) {
        this.bill_number = bill_number;
        this.item_id = item_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof SalesListId))
            return false;
        SalesListId that = (SalesListId) o;
        return Objects.equals(bill_number, that.bill_number) && Objects.equals(item_id, that.item_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bill_number, item_id);
    }
}
