package com.lymar.aviasales;

import com.lymar.aviasales.dto.Flight;
import com.lymar.aviasales.service.FlightService;
import com.lymar.aviasales.util.Reader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.util.HashMap;

@SpringBootApplication
public class AviasalesApplication {

    public static void main(String[] args) {
        SpringApplication.run(AviasalesApplication.class, args);
    }
    @Bean
    public CommandLineRunner runner(FlightService service) {
        return args -> {
            ResponseEntity<Flight> responseEntity = service.findFlight(1);


        };
    }
}
