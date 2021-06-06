package com.lymar.aviasales.service;

import com.lymar.aviasales.util.DataFormat;
import com.lymar.aviasales.util.Reader;
import com.lymar.aviasales.dto.Flight;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {
    private HashMap<Integer, String> flightMap = Reader.getFlight(new File("src/main/info.csv"));

    public ResponseEntity<Flight> findFlight(Integer id) {
       if(flightMap.containsKey(id)) {
           Flight flight = new Flight();
           String findFlight = flightMap.get(id);

           List<String> list = Arrays.stream(findFlight.split(" "))
                   .filter(i -> !i.equals(""))
                   .collect(Collectors.toList());
           flight.setNameFlight(list.get(6));
           flight.setDepartureDate(DataFormat.getData(list.get(2) + list.get(3)));
           flight.setArrivalDate(DataFormat.getData(list.get(4) + list.get(5)));
           return new ResponseEntity<>(flight, HttpStatus.OK);
       }
       else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }
}
