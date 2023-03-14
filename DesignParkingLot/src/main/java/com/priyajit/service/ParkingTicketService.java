package com.priyajit.service;

import com.priyajit.entitiy.billing.ParkingTicket;
import com.priyajit.entitiy.vehicle.VehicleType;

public interface ParkingTicketService {

    ParkingTicket createParkingTicket(String vehicleRegNo, VehicleType vehicleType, Boolean isEv);

    ParkingTicket getParkingTicket(Long id);
}