package com.priyajit.entitiy.billing;

import com.priyajit.entitiy.Entity;
import com.priyajit.entitiy.vehicle.Vehicle;
import com.priyajit.entitiy.parkinglot.Slot;

import java.util.Date;

public class ParkingTicket extends Entity {
    private Vehicle vehicle;
    private Date entryTime;
    private Date exitTime;
    private Slot slot;

}
