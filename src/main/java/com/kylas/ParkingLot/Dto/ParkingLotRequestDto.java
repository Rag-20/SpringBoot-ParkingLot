package com.kylas.ParkingLot.Dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class ParkingLotRequestDto {
    private String name;
    private int numberOfFloors;
    private int numberOfSlots;
}
