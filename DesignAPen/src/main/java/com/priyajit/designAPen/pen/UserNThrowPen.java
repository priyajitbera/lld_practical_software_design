package com.priyajit.designAPen.pen;

import com.priyajit.designAPen.factory.RefillFactory;
import com.priyajit.designAPen.refillable.Refillable;
import com.priyajit.designAPen.strategy.Refill;

public class UserNThrowPen extends Pen {
    public UserNThrowPen(String name, String brand, Integer price, Refill refill) {
        super(name, brand, price, refill);
    }
}
