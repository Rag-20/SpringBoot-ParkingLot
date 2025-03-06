package com.kylas.ParkingLot.Mapper;

import com.kylas.ParkingLot.Dto.VehicleEntryRequestDto;
import com.kylas.ParkingLot.Dto.VehicleEntryResponseDto;
import com.kylas.ParkingLot.Entity.Slot;
import com.kylas.ParkingLot.Entity.Ticket;
import com.kylas.ParkingLot.Entity.Vehicle;

public class VehicleMapper {
    public static VehicleEntryResponseDto mapToVehicleResponseDto(Ticket ticket, Vehicle vehicle){
        VehicleEntryResponseDto vehicleEntryResponseDto = new VehicleEntryResponseDto(ticket.getTicketNumber(),
                vehicle.getLicensePlate(),
                ticket.getSlot().getSlotNumber(),
                ticket.getSlot().getFloor().getFloorNumber(),
                ticket.getEntryTime()
        );

        return vehicleEntryResponseDto;
    }

    public static Vehicle mapToVehicle(VehicleEntryRequestDto requestDto, Slot availableSlot) {
        Vehicle vehicle=new Vehicle();
        vehicle.setLicensePlate(requestDto.getLicensePlate());
        vehicle.setVehicleType(requestDto.getVehicleType());
        vehicle.setSlotId(availableSlot);

        return vehicle;
    }
}
