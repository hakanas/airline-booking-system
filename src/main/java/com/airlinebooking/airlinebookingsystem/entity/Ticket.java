package com.airlinebooking.airlinebookingsystem.entity;

import javax.persistence.*;

@Entity
@Table(name="ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="card_number")
    private String cardNumber;

    @ManyToOne()
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
