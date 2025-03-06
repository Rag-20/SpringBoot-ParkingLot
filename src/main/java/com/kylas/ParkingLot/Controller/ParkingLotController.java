package com.kylas.ParkingLot.Controller;

import com.kylas.ParkingLot.Dto.ParkingLotResponseDto;
import com.kylas.ParkingLot.Dto.ParkingLotRequestDto;
import com.kylas.ParkingLot.Service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/parkinglot")
public class ParkingLotController {

    private final ParkingLotService parkingLotService;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PostMapping
    public ResponseEntity<ParkingLotResponseDto> createParkingLot(@RequestBody ParkingLotRequestDto request) {
        return new ResponseEntity<>(parkingLotService.createParkingLot(request), HttpStatus.CREATED);
    }
}