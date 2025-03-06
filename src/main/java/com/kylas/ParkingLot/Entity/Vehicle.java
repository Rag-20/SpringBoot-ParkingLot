package com.kylas.ParkingLot.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String licensePlate;
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    @OneToOne(mappedBy = "vehicle")
    private Slot slotId;

    @OneToOne(mappedBy = "vehicle")
    private Ticket ticket;
}
