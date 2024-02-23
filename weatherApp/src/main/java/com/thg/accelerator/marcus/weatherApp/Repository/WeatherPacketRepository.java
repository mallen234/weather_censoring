package com.thg.accelerator.marcus.weatherApp.Repository;

import com.thg.accelerator.marcus.weatherApp.WeatherPacket.WeatherPacket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WeatherPacketRepository extends JpaRepository<WeatherPacket, Long> {


}

