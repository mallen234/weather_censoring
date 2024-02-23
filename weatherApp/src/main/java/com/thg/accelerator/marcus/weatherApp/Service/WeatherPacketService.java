package com.thg.accelerator.marcus.weatherApp.Service;

import com.thg.accelerator.marcus.weatherApp.Repository.WeatherPacketRepository;
import com.thg.accelerator.marcus.weatherApp.WeatherPacket.WeatherPacket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherPacketService {
    private final WeatherPacketRepository weatherPacketRepository;

    @Autowired
    public WeatherPacketService(WeatherPacketRepository weatherPacketRepository){
        this.weatherPacketRepository = weatherPacketRepository;
    }


    public List<WeatherPacket> getWeatherPackets(){
        return weatherPacketRepository.findAll();
    }

    public Optional<WeatherPacket> getWeatherPacketId(Long id){
        return weatherPacketRepository.findById(id);
    }

    public WeatherPacket saveWeatherPacket(WeatherPacket weatherPacket) {

        return weatherPacketRepository.save(weatherPacket);

    }
}
