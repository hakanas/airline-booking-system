package com.airlinebooking.airlinebookingsystem.repository;

import com.airlinebooking.airlinebookingsystem.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Optional<Flight> findByIdAndAirlineCompanyId(Integer flightId, Integer companyId);
}
