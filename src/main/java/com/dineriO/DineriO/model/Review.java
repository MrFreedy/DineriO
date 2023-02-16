package com.dineriO.DineriO.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name= "REVIEW")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="CUSTOMER_USERNAME")
    private String customerUsername;

    @Column(name="COMMENTARY")
    private String commentary;

    @Column(name="RATE")
    private String rate;

    @Column(name="RESTAURANT")
    private String restaurant;



}
