package com.sam.weatherBackend.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sam.weatherBackend.Models.Weather;

@Repository
public interface WeatherRepo extends JpaRepository<Weather, String> {

    @Query("SELECT u FROM Weather u WHERE u.city = city")
     public List<Weather> findByCity(String city);
    
}
