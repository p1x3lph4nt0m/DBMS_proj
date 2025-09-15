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
@Table(name = "buyer")
public class Buyer {
    @Id
    @Column(name = "gst_number")
    private String gstNumber;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "building_name")
    private String buildingName;

    @Column(name = "area")
    private String area;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private String zipCode;

}
