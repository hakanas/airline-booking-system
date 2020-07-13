package com.airlinebooking.airlinebookingsystem.repository;

import com.airlinebooking.airlinebookingsystem.entity.AirlineCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany, Integer> {

}
