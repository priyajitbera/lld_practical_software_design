package com.priyajit.entitiy.parkinglot;

import com.priyajit.entitiy.parkinglot.Slot;

import java.util.List;

public class Floor {
    private Long floorId;
    private String floorCode;
    private List<Slot> slots;

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public String getFloorCode() {
        return floorCode;
    }

    public void setFloorCode(String floorCode) {
        this.floorCode = floorCode;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorId=" + floorId +
                ", floorCode='" + floorCode + '\'' +
                ", slots=" + slots +
                '}';
    }
}
