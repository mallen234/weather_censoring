package com.thg.accelerator.marcus.weatherApp.WeatherPacket;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "weather")
public class WeatherPacket {
    @Id
    @SequenceGenerator(
            name = "weather_sequence",
            sequenceName = "weather_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "weather_sequence")
    private Long id;
    private Double temperature;
    private Double humidity;
    private Double pressure;

    private LocalDate localDate;


    public WeatherPacket(Double temperature,
                         Double humidity,
                         Double pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.localDate = LocalDate.now();
    }

    public WeatherPacket(){}


}
