package com.priyajit.factory.parkingLot;

import com.priyajit.dto.parkingLot.ParkingLotResponseDTO;
import com.priyajit.entitiy.parkinglot.ParkingLot;

public interface ParkingLotResponseDTOFactory {

    ParkingLotResponseDTO parkingLotResponseDTO(ParkingLot parkingLot);
}
