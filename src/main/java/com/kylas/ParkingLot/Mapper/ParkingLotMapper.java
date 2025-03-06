package com.kylas.ParkingLot.Mapper;

import com.kylas.ParkingLot.Dto.FloorDto;
import com.kylas.ParkingLot.Dto.ParkingLotRequestDto;
import com.kylas.ParkingLot.Dto.ParkingLotResponseDto;
import com.kylas.ParkingLot.Dto.SlotDto;
import com.kylas.ParkingLot.Entity.Floor;
import com.kylas.ParkingLot.Entity.ParkingLot;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotMapper {
    public static ParkingLot mapToParkingLot(ParkingLotRequestDto parkingLotRequestDto){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName(parkingLotRequestDto.getName());

        List<Floor> floors = Floor.initializeFloors(
                parkingLotRequestDto.getNumberOfFloors(),
                parkingLotRequestDto.getNumberOfSlots(),
                parkingLot
        );

        parkingLot.setFloor(floors);

        return parkingLot;
    }

    public static ParkingLotResponseDto mapToParkingLotDto(ParkingLot parkingLot){
        ParkingLotResponseDto parkingLotResponseDto=new ParkingLotResponseDto(
                parkingLot.getId(),
                parkingLot.getName(),

                parkingLot.getFloor().stream().map(floor ->
                        new FloorDto(
                                floor.getId(),
                                floor.getFloorNumber(),
                                floor.getSlots().stream().map(slot ->
                                        new SlotDto(slot.getId(), slot.getSlotNumber(), slot.isStatus())
                                ).collect(Collectors.toList()),
                                new ParkingLotResponseDto(parkingLot.getId(), parkingLot.getName(), null)
                        )).collect(Collectors.toList())
        );

        return parkingLotResponseDto;
    }
}
