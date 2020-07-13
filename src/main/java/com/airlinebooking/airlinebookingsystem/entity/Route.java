package com.airlinebooking.airlinebookingsystem.entity;

import javax.persistence.*;

@Entity
@Table(name="route")
public class Route {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @OneToOne
    @JoinColumn(name="departure_id")
    private Airport departure;

    @OneToOne
    @JoinColumn(name="destination_id")
    private Airport destination;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Airport getDeparture() {
        return departure;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }
}
