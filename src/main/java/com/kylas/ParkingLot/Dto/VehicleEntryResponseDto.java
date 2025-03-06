package com.kylas.ParkingLot.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleEntryResponseDto {
        private String ticketNumber;
        private String licensePlate;
        private int slotNumber;
        private int floorNumber;
        private LocalDateTime entryTime;
}
