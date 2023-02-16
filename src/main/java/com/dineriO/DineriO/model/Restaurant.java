package com.dineriO.DineriO.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "RESTAURANT")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE")
    private String phone;

    @Column(name="RATING")
    private String rating;
}
