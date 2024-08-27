package com.sam.weatherBackend.Models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
@Embeddable
public class WeatherDetails {
    @Id
    private int id;
    private String main;
    private String description;
    private String icon;
}
