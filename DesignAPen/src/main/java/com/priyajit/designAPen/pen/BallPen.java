package com.priyajit.designAPen.pen;

import com.priyajit.designAPen.factory.RefillFactory;
import com.priyajit.designAPen.strategy.BallRefill;
import com.priyajit.designAPen.refillable.Refillable;
import com.priyajit.designAPen.strategy.Refill;

public class BallPen extends Pen implements Refillable {
    public BallPen(String name, String brand, int price, Refill refill) {
        super(name, brand, price, refill);
    }

    @Override
    public void doRefill() {
        this.refill = RefillFactory.ballRefill();
    }
}
