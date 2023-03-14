package com.priyajit.service;

import com.priyajit.entitiy.billing.Bill;
import com.priyajit.entitiy.billing.ParkingTicket;

public interface BillingService {
    Bill generateBill(ParkingTicket parkingTicket);
}
