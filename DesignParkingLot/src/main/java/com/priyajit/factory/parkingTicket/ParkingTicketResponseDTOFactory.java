package com.priyajit.factory.parkingTicket;

import com.priyajit.dto.parkingTicket.ParkingTicketResponseDTO;
import com.priyajit.entitiy.billing.ParkingTicket;

public interface ParkingTicketResponseDTOFactory {

    ParkingTicketResponseDTO parkingTicketResponseDTOFactory(ParkingTicket parkingTicket);
}
