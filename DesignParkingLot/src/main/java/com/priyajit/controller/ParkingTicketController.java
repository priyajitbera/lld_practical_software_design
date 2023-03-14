package com.priyajit.controller;

import com.priyajit.dto.parkingTicket.ParkingTicketRequestDTO;
import com.priyajit.dto.parkingTicket.ParkingTicketResponseDTO;
import com.priyajit.factory.parkingTicket.ParkingTicketResponseDTOFactory;
import com.priyajit.service.ParkingTicketService;

public class ParkingTicketController {

    private ParkingTicketService parkingTicketService;

    private ParkingTicketResponseDTOFactory parkingTicketResponseDTOFactory;

    // GET
    public ParkingTicketResponseDTO getParkingTicket(Long id) {
        var parkingTicket = parkingTicketService.getParkingTicket(id);
        return parkingTicketResponseDTOFactory
                .parkingTicketResponseDTOFactory(parkingTicket);
    }

    // POST
    public ParkingTicketResponseDTO createParkingTicket(ParkingTicketRequestDTO requestDTO) {
        var parkingTicket = parkingTicketService
                .createParkingTicket(
                        requestDTO.getVehicleRegNo(),
                        requestDTO.getVehicleType(),
                        requestDTO.getEV());
        return parkingTicketResponseDTOFactory
                .parkingTicketResponseDTOFactory(parkingTicket);
    }
}
