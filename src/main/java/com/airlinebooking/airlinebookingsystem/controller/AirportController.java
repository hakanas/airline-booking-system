package com.airlinebooking.airlinebookingsystem.controller;

import com.airlinebooking.airlinebookingsystem.entity.Airport;
import com.airlinebooking.airlinebookingsystem.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
public class AirportController {

    @Autowired
    AirportRepository airportRepository;

    @GetMapping("/airports/{airportId}")
    public Airport getAirportById(@PathVariable int airportId) {
        return airportRepository.findById(airportId).orElseThrow(() -> new EntityNotFoundException("Id not found: " + airportId));
    }

    @PostMapping("/airports")
    public Airport createAirport(@RequestBody Airport airport) {
        return airportRepository.save(airport);
    }
}
