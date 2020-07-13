package com.airlinebooking.airlinebookingsystem.controller;

import com.airlinebooking.airlinebookingsystem.entity.AirlineCompany;
import com.airlinebooking.airlinebookingsystem.repository.AirlineCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class AirlineCompanyController {

    @Autowired
    private AirlineCompanyRepository airlineCompanyRepository;

    @GetMapping("/companies")
    public List<AirlineCompany> getAirlineCompanies() {
        return airlineCompanyRepository.findAll();
    }

    @PostMapping("/companies")
    public AirlineCompany createAirlineCompanies(@RequestBody AirlineCompany airlineCompany) {
        return airlineCompanyRepository.save(airlineCompany);
    }

    @GetMapping("/companies/{companyId}")
    public AirlineCompany getAirlineCompanyById(@PathVariable int companyId) {
        return airlineCompanyRepository.findById(companyId).orElseThrow(() -> new EntityNotFoundException("Id not found: " + companyId));
    }
}
