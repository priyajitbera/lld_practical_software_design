package com.priyajit.dto.parkingTicket;

import com.priyajit.entitiy.vehicle.VehicleType;

public class ParkingTicketRequestDTO {
    private String vehicleRegNo;
    private VehicleType vehicleType;
    private Boolean isEV;

    public String getVehicleRegNo() {
        return vehicleRegNo;
    }

    public void setVehicleRegNo(String vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Boolean getEV() {
        return isEV;
    }

    public void setEV(Boolean EV) {
        isEV = EV;
    }
}
