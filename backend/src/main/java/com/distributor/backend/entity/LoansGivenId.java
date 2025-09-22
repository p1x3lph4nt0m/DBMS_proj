package com.distributor.backend.entity;

import java.io.Serializable;
import java.util.Objects;

public class LoansGivenId implements Serializable {
    private Long Id;
    private String buyer;

    public LoansGivenId(){}

    public LoansGivenId(Long Id, String buyer){
        this.Id = Id;
        this.buyer = buyer;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof LoansGivenId that)) return false;
        return Objects.equals(Id,that.Id) &&
                Objects.equals(buyer,that.buyer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id,buyer);
    }
}
