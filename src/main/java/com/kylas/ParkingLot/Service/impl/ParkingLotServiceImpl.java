package com.kylas.ParkingLot.Service.impl;

import com.kylas.ParkingLot.Dto.ParkingLotResponseDto;
import com.kylas.ParkingLot.Dto.ParkingLotRequestDto;
import com.kylas.ParkingLot.Entity.Floor;
import com.kylas.ParkingLot.Entity.ParkingLot;
import com.kylas.ParkingLot.Mapper.ParkingLotMapper;
import com.kylas.ParkingLot.Repository.ParkingLotRepository;
import com.kylas.ParkingLot.Service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    public ParkingLotServiceImpl(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ParkingLotResponseDto createParkingLot(ParkingLotRequestDto parkingLotRequestDto) {
        ParkingLot parkingLot = ParkingLotMapper.mapToParkingLot(parkingLotRequestDto);

        ParkingLot savedParkingLot = parkingLotRepository.saveAndFlush(parkingLot);
        return ParkingLotMapper.mapToParkingLotDto(savedParkingLot);
    }
}
