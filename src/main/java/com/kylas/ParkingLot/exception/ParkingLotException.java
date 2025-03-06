package com.kylas.ParkingLot.exception;

import lombok.Getter;

@Getter
public class ParkingLotException extends RuntimeException{

    private ErrorResource errorResource;

    public ParkingLotException(ErrorResource errorResource) {
        super(errorResource.getMessage());
        this.errorResource = errorResource;
    }
}
