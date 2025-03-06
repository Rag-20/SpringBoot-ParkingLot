package com.kylas.ParkingLot.Service;

import com.kylas.ParkingLot.Dto.VehicleEntryRequestDto;
import com.kylas.ParkingLot.Dto.VehicleEntryResponseDto;
import com.kylas.ParkingLot.Dto.VehicleExitRequestDto;
import org.springframework.http.ResponseEntity;

public interface VehicleParkingService {
    VehicleEntryResponseDto vehicleEntry(VehicleEntryRequestDto requestDto);

    String vehicleExit(VehicleExitRequestDto requestDto);

    boolean validateNumberPlateFormat(String numberPlate);
}
