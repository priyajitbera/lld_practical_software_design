package com.priyajit.strategy;

import com.priyajit.entitiy.vehicle.VehicleType;

import java.util.Date;

public interface FareCalculationStrategy {
    Double calculate(VehicleType vehicleType, Date entry, Date exit);
}
