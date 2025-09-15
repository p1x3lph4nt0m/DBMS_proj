package com.distributor.backend.entity;

import java.io.Serializable;
import java.util.Objects;

public class SalesListId implements Serializable {

    private Long billNumber;
    private Long itemId;

    public SalesListId() {}

    public SalesListId(Long billNumber, Long itemId) {
        this.billNumber = billNumber;
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesListId)) return false;
        SalesListId that = (SalesListId) o;
        return Objects.equals(billNumber, that.billNumber) &&
                Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billNumber, itemId);
    }
}
