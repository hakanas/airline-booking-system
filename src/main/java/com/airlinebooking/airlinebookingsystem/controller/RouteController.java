package com.airlinebooking.airlinebookingsystem.controller;

import com.airlinebooking.airlinebookingsystem.entity.Route;
import com.airlinebooking.airlinebookingsystem.repository.AirportRepository;
import com.airlinebooking.airlinebookingsystem.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Map;

@RestController
public class RouteController {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private AirportRepository airportRepository;

    @GetMapping("/routes/{routeId}")
    public Route getRouteById(@PathVariable int routeId) {
        return routeRepository.findById(routeId).orElseThrow(() -> new EntityNotFoundException("Id not found: " + routeId));
    }

    @PostMapping("/routes")
    public Route createRoute(@RequestBody Map<String,Object> body) {
        Route route = new Route();

        route.setDeparture(airportRepository.findById((int)body.get("departureId")).orElse(null));
        route.setDestination(airportRepository.findById((int)body.get("destinationId")).orElse(null));

        return routeRepository.save(route);
    }
}
