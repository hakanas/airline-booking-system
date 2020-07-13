package com.airlinebooking.airlinebookingsystem.controller;

import com.airlinebooking.airlinebookingsystem.entity.Airport;
import com.airlinebooking.airlinebookingsystem.entity.Flight;
import com.airlinebooking.airlinebookingsystem.entity.Ticket;
import com.airlinebooking.airlinebookingsystem.repository.FlightRepository;
import com.airlinebooking.airlinebookingsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("tickets/{ticketId}")
    public Ticket getTicketById(@PathVariable int ticketId) {
        return ticketRepository.findById(ticketId).orElseThrow(() -> new EntityNotFoundException("Id not found: " + ticketId));
    }

    @DeleteMapping("tickets/{ticketId}")
    public String deleteTicket(@PathVariable int ticketId) {
        return ticketRepository.findById(ticketId).map(ticket -> {
            ticket.getFlight().increaseSeatCapacity(1);
            ticketRepository.deleteById(ticketId);
            return "Ticket is canceled!";
        }).orElseThrow(() -> new EntityNotFoundException("Id not found: " + ticketId));
    }

    @PostMapping("/flights/{flightId}/buyticket")
    public Ticket createTicket(@PathVariable int flightId, @RequestBody Ticket ticket) {
        return flightRepository.findById(flightId).map(flight -> {
            if (flight.getSeatCapacity() > 0) {
                flight.decreaseSeatCapacity(1);
                String theCardNumber = ticket.getCardNumber().replaceAll("[^a-zA-Z0-9]", "");
                theCardNumber = theCardNumber.substring(0, Math.min(theCardNumber.length(), 16));
                theCardNumber = new StringBuilder(theCardNumber).replace(6, 12, "******").toString();
                if (theCardNumber.length() == 16)
                    ticket.setCardNumber(theCardNumber);
                else
                    throw new RuntimeException("card number is not correct!");
                ticket.setFlight(flight);
                return ticketRepository.save(ticket);
            }
            else {
                throw new RuntimeException("Seat capacity is FULL!");
            }
        }).orElseThrow(() -> new EntityNotFoundException("Id not found: " + flightId));
    }
}
