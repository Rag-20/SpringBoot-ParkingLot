package com.kylas.ParkingLot.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SlotDto {
    private long id;
    private int slotNumber;
    private boolean occupied;
}
