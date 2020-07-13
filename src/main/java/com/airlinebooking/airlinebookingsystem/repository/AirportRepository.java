package com.airlinebooking.airlinebookingsystem.repository;

import com.airlinebooking.airlinebookingsystem.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Integer> {
}
