package com.sam.weatherBackend.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class WeatherDetails {
    @JsonProperty("id")
    @Id
    private int idw;
    private String main;
    private String description;
    private String icon;
}
