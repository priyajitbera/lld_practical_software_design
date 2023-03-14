package com.priyajit.entitiy.parkinglot;

import com.priyajit.entitiy.Entity;

import java.util.List;

public class ParkingLot extends Entity {
    private String name;
    private List<Floor> floors;
    private List<Gate> gates;
    private String address;
}
