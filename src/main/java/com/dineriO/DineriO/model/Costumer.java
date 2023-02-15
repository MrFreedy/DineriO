package com.dineriO.DineriO.model;

import jakarta.persistence.*;


@Entity
@Table(name = "COSTUMER")
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="USERNAME")
    private String username;

    @Column(name="CITY")
    private String city;

    @Column(name="State")
    private String state;

    @Column(name="ZIP")
    private int zip;

    @Column(name="PEANUT")
    private boolean hasPeanutAllergies;

    @Column(name="EGG")
    private boolean hasEggAllergies;

    @Column(name="DAIRY")
    private boolean hasDairyAllergies;
}
