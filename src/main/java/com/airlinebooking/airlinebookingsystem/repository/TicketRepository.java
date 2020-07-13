package com.airlinebooking.airlinebookingsystem.repository;

import com.airlinebooking.airlinebookingsystem.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
