package com.kylas.ParkingLot.Dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

public class FloorDto {
    private long id;
    private int floorNumber;
    private List<SlotDto> slots;
    @JsonIgnore
    private ParkingLotResponseDto parkingLotDto;
}
