package com.kylas.ParkingLot.Service;

import com.kylas.ParkingLot.Dto.ParkingLotResponseDto;
import com.kylas.ParkingLot.Dto.ParkingLotRequestDto;

public interface ParkingLotService {
    ParkingLotResponseDto createParkingLot(ParkingLotRequestDto parkingLotRequestDto);
}
