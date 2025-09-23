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
@Table(name = "loans_taken")
@IdClass(LoansTakenId.class)
public class LoansTaken {

    @Id
    private Long Id;

    @Column(name = "Rate")
    private Double rate = (double) 0;

    @Column(name = "Amount", nullable = false)
    private Double amt;

    @Column(name = "Day", nullable = false)
    private Integer day;

    @Column(name = "Month", nullable = false)
    private Integer month;

    @Column(name = "Year", nullable = false)
    private Integer year;

    @Column(name = "Duration")
    private Integer duration;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "gst", nullable = false)
    private Supplier supplier;
}
