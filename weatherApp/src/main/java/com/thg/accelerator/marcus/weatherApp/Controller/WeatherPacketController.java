package com.thg.accelerator.marcus.weatherApp.Controller;


import com.thg.accelerator.marcus.weatherApp.Service.WeatherPacketService;
import com.thg.accelerator.marcus.weatherApp.WeatherPacket.WeatherPacket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/weather")
@CrossOrigin(origins = "http://31.24.224.144")
public class WeatherPacketController {
    private final WeatherPacketService weatherPacketService;

    WeatherPacketController(WeatherPacketService weatherPacketService){
        this.weatherPacketService = weatherPacketService;
    }

    @GetMapping
    public ResponseEntity<List<WeatherPacket>> findWeatherPackets(){
        return ResponseEntity.ok(weatherPacketService.getWeatherPackets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeatherPacket> findWeatherPacketById(@PathVariable final Long id){

        var optionalWP = weatherPacketService.getWeatherPacketId(id);

        if(optionalWP.isPresent()) {
            var WP = optionalWP.get();
            return ResponseEntity.ok(WP);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<WeatherPacket> postWeatherPacket(@RequestBody WeatherPacket weatherPacket){

        weatherPacketService.saveWeatherPacket(weatherPacket);
        var location = MvcUriComponentsBuilder
                .fromMethodName(WeatherPacketController.class, "findWeatherPacketById", weatherPacket.getId())
                .buildAndExpand(weatherPacket.getId())
                .toUri();

        return ResponseEntity.created(location).body(weatherPacket);

    }
}
