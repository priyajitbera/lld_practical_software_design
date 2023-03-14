package com.priyajit.controller;

import com.priyajit.dto.parkingLot.ParkingLotRequestDTO;
import com.priyajit.dto.parkingLot.ParkingLotResponseDTO;
import com.priyajit.factory.parkingLot.ParkingLotFactory;
import com.priyajit.factory.parkingLot.ParkingLotResponseDTOFactory;
import com.priyajit.service.ParkingLotService;
import com.priyajit.service.ParkingTicketService;

public class ParkingLotController {

    private ParkingLotResponseDTOFactory parkingLotResponseDTOFactory;

    private ParkingLotService parkingLotService;

    // GET
    public ParkingLotResponseDTO getParkingLot(Long id) {
        var parkingLot = parkingLotService.getParkingLot(id);
        return parkingLotResponseDTOFactory.parkingLotResponseDTO(parkingLot);
    }

    // POST
    public ParkingLotResponseDTO createParkingLot(ParkingLotRequestDTO requestDTO) {
        var parkingLot = parkingLotService.createParkingLot(requestDTO.getAddress());
        return parkingLotResponseDTOFactory.parkingLotResponseDTO(parkingLot);
    }

    // POST
    public ParkingLotResponseDTO addFloor(Long id) {
        var parkingLot = parkingLotService.addFloor(id);
        return parkingLotResponseDTOFactory.parkingLotResponseDTO(parkingLot);
    }

    // POST
    public ParkingLotResponseDTO addSlot(Long id, Long floorId, Boolean supportsCharging) {
        var parkingLot = parkingLotService.addSlot(id, floorId, supportsCharging);
        return parkingLotResponseDTOFactory.parkingLotResponseDTO(parkingLot);
    }
}
