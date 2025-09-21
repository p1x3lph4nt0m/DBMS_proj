package com.distributor.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @Column(name = "gst")
    private String gst;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "building")
    private String building;

    @Column(name = "area")
    private String area;

    @Column(name = "city")
    private String city;

    @Column(name = "zip")
    private String zip;
}
