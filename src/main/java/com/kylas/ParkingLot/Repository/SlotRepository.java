package com.kylas.ParkingLot.Repository;

import com.kylas.ParkingLot.Entity.ParkingLot;
import com.kylas.ParkingLot.Entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SlotRepository extends JpaRepository<Slot,Long> {
    Optional<Slot> findFirstByStatusFalseAndFloor_ParkingLotOrderBySlotNumberAsc(ParkingLot parkingLot);

    Optional<Slot> findByStatusTrueAndVehicle_LicensePlate(String licensePlate);

    Optional<Slot> findAllByStatusFalse();

}
