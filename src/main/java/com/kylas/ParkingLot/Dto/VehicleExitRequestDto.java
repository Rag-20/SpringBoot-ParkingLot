package com.kylas.ParkingLot.Dto;

import com.kylas.ParkingLot.Entity.ParkingLot;
import lombok.Data;

@Data
public class VehicleExitRequestDto {
    private long parkingLotId;
    private String licensePlate;
}
