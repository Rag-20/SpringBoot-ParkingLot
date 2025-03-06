package com.kylas.ParkingLot.Dto;

import com.kylas.ParkingLot.Entity.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleEntryRequestDto {
    private long parkingLotId;
    private String licensePlate;
    private VehicleType vehicleType;
}
