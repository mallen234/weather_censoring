package com.thg.accelerator.marcus.weatherApp.Config;

import com.thg.accelerator.marcus.weatherApp.Repository.WeatherPacketRepository;
import com.thg.accelerator.marcus.weatherApp.WeatherPacket.WeatherPacket;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            WeatherPacketRepository repository
    ) {
        return args -> {
            WeatherPacket weather1 = new WeatherPacket(
                    17.,
                    124.,
                    1212.
            );

            WeatherPacket weather2 = new WeatherPacket(
                    18.,
                    124.,
                    1212.
            );

            WeatherPacket weather3 = new WeatherPacket(
                    19.,
                    124.,
                    1212.
            );

            repository.saveAll(List.of(weather1,weather2,weather3));
        };
    }
}
