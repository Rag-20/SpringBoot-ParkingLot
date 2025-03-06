package com.kylas.ParkingLot.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private boolean status;

    private int slotNumber;

    @ManyToOne
    private Floor floor;

    @OneToOne
    private Vehicle vehicle;

    @OneToMany(mappedBy = "slot",cascade = CascadeType.ALL)
    private List<Ticket> ticket;

    public Slot(Long id, int slotNumber, boolean status) {
        this.id = id;
        this.status = status;
        this.slotNumber = slotNumber;
    }

    public static List<Slot> initializeSlots(int numberOfSlots, Floor floor) {
        List<Slot> slots = new ArrayList<>();

        for (int j = 1; j <= numberOfSlots; j++) {
            Slot slot = new Slot();
            slot.setSlotNumber(j);
            slot.setStatus(false);
            slot.setFloor(floor);
            slots.add(slot);
        }
        return slots;
    }
}
