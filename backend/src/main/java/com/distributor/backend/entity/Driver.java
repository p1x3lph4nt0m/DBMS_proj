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
@Table(name = "driver")

public class Driver {
    @Id
    @Column(name = "license")
    private String license;

    @Column(name = "aadhaar", nullable = false, unique = true)
    private String aadhaar;

    @Column(name = "fname", nullable = false)
    private String fname;

    @Column(name = "lname")
    private String lname;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "house")
    private String house;

    @Column(name = "locality")
    private String locality;

    @Column(name = "city")
    private String city;

    @Column(name = "zip")
    private String zip;
}
