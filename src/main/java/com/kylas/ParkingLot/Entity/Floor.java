package com.kylas.ParkingLot.Entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int floorNumber;

    @OneToMany(mappedBy = "floor",cascade = CascadeType.ALL)
    private List<Slot> slots;

    @ManyToOne
    private ParkingLot parkingLot;

    public static List<Floor> initializeFloors(int numberOfFloors, int numberOfSlots, ParkingLot parkingLot) {
        List<Floor> floors = new ArrayList<>();

        for (int i = 1; i <= numberOfFloors; i++) {
            Floor floor = new Floor();
            floor.setFloorNumber(i);
            floor.setParkingLot(parkingLot);
            floor.setSlots(Slot.initializeSlots(numberOfSlots, floor));

            floors.add(floor);
        }
        return floors;
    }

}
