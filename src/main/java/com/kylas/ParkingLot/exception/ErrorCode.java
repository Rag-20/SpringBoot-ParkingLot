package com.kylas.ParkingLot.exception;


public class ErrorCode {
    public static final ErrorResource PARKING_LOT_NOT_FOUND= new ErrorResource("PARKING_LOT_NOT_FOUND","Parking lot with given id does not exists!");
    public static final ErrorResource VEHICLE_ALREADY_PRESENT= new ErrorResource("VEHICLE_ALREADY_PRESENT","Vehicle with same license plate already exists!");
    public static final ErrorResource NO_AVAILABLE_SLOTS= new ErrorResource("NO_AVAILABLE_SLOTS","Parking Lot is full!");
    public static final ErrorResource VEHICLE_NOT_FOUND= new ErrorResource("VEHICLE_NOT_FOUND","Vehicle with given License plate does not exists!");
    public static final ErrorResource TICKET_NOT_FOUND= new ErrorResource("TICKET_NOT_FOUND","Ticket does not exists!");

}
