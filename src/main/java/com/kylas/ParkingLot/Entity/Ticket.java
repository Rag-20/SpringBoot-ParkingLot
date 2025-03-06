package com.kylas.ParkingLot.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ticketNumber;
    private LocalDateTime entryTime;

    private LocalDateTime exitTime;

    @OneToOne(cascade = CascadeType.ALL)
    private  Vehicle vehicle;

    @ManyToOne
    private Slot slot;


    public Ticket() {
        this.entryTime = LocalDateTime.now();
    }

}
