package com.priyajit.designAPen.pen;

import com.priyajit.designAPen.strategy.BallRefill;
import com.priyajit.designAPen.refillable.Refillable;

public class BallPen extends Pen implements Refillable {
    @Override
    public void doRefill() {
        this.refillStrategy = new BallRefill();
    }
}
