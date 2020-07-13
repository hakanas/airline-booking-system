package com.airlinebooking.airlinebookingsystem.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="flights")
public class Flight {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="seat_capacity")
    private int seatCapacity;

    @Column(name="price")
    private int price;

    @ManyToOne()
    @JoinColumn(name = "airline_company_id", nullable = false)
    private AirlineCompany airlineCompany;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public AirlineCompany getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(AirlineCompany airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public void increaseSeatCapacity(int n) {
        this.seatCapacity += n;
    }

    public void decreaseSeatCapacity(int n) {
        this.seatCapacity -= n;
    }

}
