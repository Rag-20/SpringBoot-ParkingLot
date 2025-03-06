package com.kylas.ParkingLot.Repository;

import com.kylas.ParkingLot.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    Optional<Ticket> findByVehicle_LicensePlateAndExitTimeIsNull(String licensePlate);
}
