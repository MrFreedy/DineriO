package com.dineriO.DineriO.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="USERNAME")
    private String username;

    @Column(name="CITY")
    private String city;

    @Column(name="STATE")
    private String state;

    @Column(name="ZIP")
    private String zip;

    @Column(name="PEANUT")
    private boolean hasPeanutAllergies;

    @Column(name="EGG")
    private boolean hasEggAllergies;

    @Column(name="DAIRY")
    private boolean hasDairyAllergies;
}
