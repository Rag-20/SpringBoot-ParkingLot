package com.kylas.ParkingLot.Service.impl;

import com.kylas.ParkingLot.Dto.VehicleEntryRequestDto;
import com.kylas.ParkingLot.Dto.VehicleEntryResponseDto;
import com.kylas.ParkingLot.Dto.VehicleExitRequestDto;
import com.kylas.ParkingLot.Entity.ParkingLot;
import com.kylas.ParkingLot.Entity.Slot;
import com.kylas.ParkingLot.Entity.Ticket;
import com.kylas.ParkingLot.Entity.Vehicle;
import com.kylas.ParkingLot.Mapper.TicketMapper;
import com.kylas.ParkingLot.Mapper.VehicleMapper;
import com.kylas.ParkingLot.Repository.ParkingLotRepository;
import com.kylas.ParkingLot.Repository.SlotRepository;
import com.kylas.ParkingLot.Repository.TicketRepository;
import com.kylas.ParkingLot.Repository.VehicleRepository;
import com.kylas.ParkingLot.Service.VehicleParkingService;
import com.kylas.ParkingLot.exception.ErrorCode;
import com.kylas.ParkingLot.exception.ParkingLotException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VehicleParkingServiceImpl implements VehicleParkingService {
    private final ParkingLotRepository parkingLotRepository;
    private final SlotRepository slotRepository;
    private final VehicleRepository vehicleRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public VehicleParkingServiceImpl(ParkingLotRepository parkingLotRepository, SlotRepository slotRepository, VehicleRepository vehicleRepository, TicketRepository ticketRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.slotRepository = slotRepository;
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository=ticketRepository;
    }

    public VehicleEntryResponseDto vehicleEntry(VehicleEntryRequestDto requestDto) {
        // Find the parking lot
        ParkingLot parkingLot = parkingLotRepository.findById(requestDto.getParkingLotId())
                .orElseThrow(() -> new ParkingLotException(ErrorCode.PARKING_LOT_NOT_FOUND));

        //check for duplicate
        if (slotRepository.findByStatusTrueAndVehicle_LicensePlate(requestDto.getLicensePlate()).isPresent()) {
            throw  new ParkingLotException(ErrorCode.VEHICLE_ALREADY_PRESENT);
        }
        // Find an available slot
        Slot availableSlot = slotRepository.findFirstByStatusFalseAndFloor_ParkingLotOrderBySlotNumberAsc(parkingLot)
                .orElseThrow(() ->  new ParkingLotException(ErrorCode.NO_AVAILABLE_SLOTS));

        // Create and save vehicle
        Vehicle vehicle = VehicleMapper.mapToVehicle(requestDto,availableSlot);
        Vehicle savedVehicle=vehicleRepository.saveAndFlush(vehicle);

        // Update slot status
        availableSlot.setStatus(true);
        availableSlot.setVehicle(vehicle);
        slotRepository.saveAndFlush(availableSlot);

        //Update ticket
        Ticket ticket = TicketMapper.maptoTicket(vehicle,availableSlot);
        Ticket savedTicket = ticketRepository.saveAndFlush(ticket);

        return VehicleMapper.mapToVehicleResponseDto(savedTicket,savedVehicle);
    }

    @Override
    public String vehicleExit(VehicleExitRequestDto requestDto) {
        ParkingLot parkingLot = parkingLotRepository.findById(requestDto.getParkingLotId())
                .orElseThrow(() ->  new ParkingLotException(ErrorCode.PARKING_LOT_NOT_FOUND));

        Slot presentSlot = slotRepository.findByStatusTrueAndVehicle_LicensePlate(requestDto.getLicensePlate())
                .orElseThrow(() ->  new ParkingLotException(ErrorCode.VEHICLE_NOT_FOUND));

        Ticket ticket = ticketRepository.findByVehicle_LicensePlateAndExitTimeIsNull(requestDto.getLicensePlate())
                .orElseThrow(() ->  new ParkingLotException(ErrorCode.TICKET_NOT_FOUND));

        presentSlot.setStatus(false);
        presentSlot.setVehicle(null);
        slotRepository.saveAndFlush(presentSlot);

        ticket.setExitTime(LocalDateTime.now());
        ticketRepository.saveAndFlush(ticket);

        return "Vehicle Exited";
    }


    public boolean validateNumberPlateFormat(String numberPlate){
        if(numberPlate.length()==10) {
            boolean stateInitials = (Character.isUpperCase(numberPlate.charAt(0)) && Character.isUpperCase(numberPlate.charAt(1)));
            boolean stateNumber = (Character.isDigit(numberPlate.charAt(2)) && Character.isDigit(numberPlate.charAt(3)));
            boolean numberPlateInitals = (Character.isUpperCase(numberPlate.charAt(4)) && Character.isUpperCase(numberPlate.charAt(5)));
            boolean digitsAtEnd = (Character.isDigit(numberPlate.charAt(6)) && Character.isDigit(numberPlate.charAt(7)) &&
                    Character.isDigit(numberPlate.charAt(8)) && Character.isDigit(numberPlate.charAt(9)));

            if (stateInitials && stateNumber && numberPlateInitals && digitsAtEnd) {
                return true;
            } else {
                return false;
            }

        }else{
            return false;
        }
    }
}
