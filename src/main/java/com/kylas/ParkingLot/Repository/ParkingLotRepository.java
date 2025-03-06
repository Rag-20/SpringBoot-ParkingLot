package com.kylas.ParkingLot.Repository;

import com.kylas.ParkingLot.Entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot,Long> {
    public ParkingLot findByName(String name);
}
