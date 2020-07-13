package com.airlinebooking.airlinebookingsystem.controller;

import com.airlinebooking.airlinebookingsystem.entity.Flight;
import com.airlinebooking.airlinebookingsystem.repository.AirlineCompanyRepository;
import com.airlinebooking.airlinebookingsystem.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirlineCompanyRepository airlineCompanyRepository;

    @GetMapping("/companies/{companyId}/flights/{flightId}")
    public Flight getFlightById(@PathVariable(value = "flightId") int flightId,
                                @PathVariable(value = "companyId") int companyId) {

        return flightRepository.findByIdAndAirlineCompanyId(flightId, companyId)
                                .orElseThrow(() -> new EntityNotFoundException("Id not found: " + flightId));
    }

    @PostMapping("/companies/{companyId}/flights")
    public Flight createComment(@PathVariable(value = "companyId") int companyId,
                                @RequestBody Flight flight) {

        return airlineCompanyRepository.findById(companyId).map(company -> {
            flight.setAirlineCompany(company);
            return flightRepository.save(flight);
        }).orElseThrow(() -> new EntityNotFoundException("Id not found: " + companyId));
    }
}
