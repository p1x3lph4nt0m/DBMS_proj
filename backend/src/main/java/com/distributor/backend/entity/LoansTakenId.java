package com.distributor.backend.entity;

import java.io.Serializable;
import java.util.Objects;

public class LoansTakenId implements Serializable {
    private Long Id;
    private String supplier;

    public LoansTakenId(){}

    public LoansTakenId(Long Id, String supplier){
        this.Id = Id;
        this.supplier = supplier;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof LoansTakenId that)) return false;
        return Objects.equals(Id,that.Id) && Objects.equals(supplier,that.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id,supplier);
    }
}
