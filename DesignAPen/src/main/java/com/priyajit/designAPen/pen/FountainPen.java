package com.priyajit.designAPen.pen;

import com.priyajit.designAPen.strategy.CartridgeRefill;
import com.priyajit.designAPen.refillable.Refillable;

public class FountainPen extends Pen implements Refillable {

    @Override
    public void doRefill() {
        this.refillStrategy = new CartridgeRefill();
    }
}
