package com.kylas.ParkingLot.Mapper;

import com.kylas.ParkingLot.Entity.Slot;
import com.kylas.ParkingLot.Entity.Ticket;
import com.kylas.ParkingLot.Entity.Vehicle;

public class TicketMapper {
    public static Ticket maptoTicket(Vehicle vehicle, Slot availableSlot) {
        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setSlot(availableSlot);
        ticket.setTicketNumber(vehicle.getLicensePlate()+"-"+availableSlot.getSlotNumber());

        return ticket;
    }
}
