package com.lymar.aviasales.controller;

import com.lymar.aviasales.dto.Flight;
import com.lymar.aviasales.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/flights")
public class FlightController {
    private FlightService flightService;

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlight(@PathVariable Integer id) {
        return flightService.findFlight(id);
    }

    @ExceptionHandler(Exception.class)
    public String getException(Exception e) {
        return e.getMessage();
    }
}
