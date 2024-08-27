package com.sam.weatherBackend.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table()
public class Weather {
    @JsonProperty("name")
    public String city;
    @Id
    public String id;
    @JsonProperty("weather")
    @OneToMany
    private List<WeatherDetails> weather = new ArrayList<>();

}   
