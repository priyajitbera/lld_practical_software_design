package com.priyajit.factory.parkingLot;


import com.priyajit.dto.parkingLot.ParkingLotResponseDTO;
import com.priyajit.entitiy.billing.ParkingTicket;
import com.priyajit.entitiy.parkinglot.ParkingLot;

public interface ParkingLotFactory {

    ParkingLot parkingLot(String address);
}
