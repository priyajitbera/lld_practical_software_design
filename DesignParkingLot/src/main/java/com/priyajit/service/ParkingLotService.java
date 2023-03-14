package com.priyajit.service;

import com.priyajit.entitiy.parkinglot.ParkingLot;

public interface ParkingLotService {

    ParkingLot createParkingLot(String address);

    ParkingLot getParkingLot(Long id);

    ParkingLot addFloor(Long id);

    ParkingLot addSlot(Long id, Long floorId, Boolean supportsCharging);
}
