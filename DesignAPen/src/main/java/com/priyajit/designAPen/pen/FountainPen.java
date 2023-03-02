package com.priyajit.designAPen.pen;

import com.priyajit.designAPen.factory.RefillFactory;
import com.priyajit.designAPen.strategy.CartridgeRefill;
import com.priyajit.designAPen.refillable.Refillable;
import com.priyajit.designAPen.strategy.Refill;

public class FountainPen extends Pen implements Refillable {
    public FountainPen(String name, String brand, Integer price, Refill refill) {
        super(name, brand, price, refill);
    }

    @Override
    public void doRefill() {
        this.refill = RefillFactory.cartridgeRefill();
    }
}
