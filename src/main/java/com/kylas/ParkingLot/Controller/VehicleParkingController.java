package com.kylas.ParkingLot.Controller;

import com.kylas.ParkingLot.Dto.VehicleEntryRequestDto;
import com.kylas.ParkingLot.Dto.VehicleEntryResponseDto;
import com.kylas.ParkingLot.Dto.VehicleExitRequestDto;
import com.kylas.ParkingLot.Service.VehicleParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/parking")
public class VehicleParkingController {
    private final VehicleParkingService vehicleParkingService;

    @Autowired
    public VehicleParkingController(VehicleParkingService vehicleParkingService) {
        this.vehicleParkingService = vehicleParkingService;
    }

    @PostMapping("/vehicle-entry")
    public ResponseEntity vehicleEntry(@RequestBody VehicleEntryRequestDto requestDto) {
        if (!vehicleParkingService.validateNumberPlateFormat(requestDto.getLicensePlate())) {
            return ResponseEntity.badRequest().body("Invalid license plate format!");
        }
        VehicleEntryResponseDto responseDto = vehicleParkingService.vehicleEntry(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/vehicle-exit")
    public ResponseEntity vehicleExit(@RequestBody VehicleExitRequestDto requestDto) {
        if(!vehicleParkingService.validateNumberPlateFormat(requestDto.getLicensePlate())){
            return ResponseEntity.badRequest().body("Invalid license plate format!");
        }
        String response=vehicleParkingService.vehicleExit(requestDto);

        return ResponseEntity.ok(response);
    }
}