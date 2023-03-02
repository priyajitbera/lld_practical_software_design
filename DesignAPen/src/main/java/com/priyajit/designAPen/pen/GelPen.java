package com.priyajit.designAPen.pen;

import com.priyajit.designAPen.factory.RefillFactory;
import com.priyajit.designAPen.strategy.BallRefill;
import com.priyajit.designAPen.refillable.Refillable;
import com.priyajit.designAPen.strategy.Refill;

public class GelPen extends Pen implements Refillable {
    public GelPen(String name, String brand, Integer price, Refill refill) {
        super(name, brand, price, refill);
    }

    @Override
    public void doRefill() {
        this.refill = RefillFactory.gelRefill();
    }
}
