package com.lymar.aviasales.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Flight {
    private String nameFlight;
    private String departureDate;
    private String arrivalDate;
}
