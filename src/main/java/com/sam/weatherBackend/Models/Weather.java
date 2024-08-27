package com.sam.weatherBackend.Models;

import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table()
public class Weather {
    @JsonProperty("name")
    public String city;
    @Id
    public String id;
    public String timezone;
    // @JsonProperty("weather[0]")
    // @Embedded
    // public WeatherDetails weather;

    // Setter for city
    public void setCity(String city) {
        this.city = city.toLowerCase();
    }
}   
