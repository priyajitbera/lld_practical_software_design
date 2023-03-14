package com.priyajit.service;

import com.priyajit.entitiy.billing.Bill;
import com.priyajit.entitiy.billing.PaymentStatus;

public interface PaymentService {
    PaymentStatus doPayment(Long billId);
}
