package com.priyajit.designAPen.pen;

import com.priyajit.designAPen.strategy.NoRefill;
import com.priyajit.designAPen.refillable.Refillable;

public class UserNThrowPen extends Pen implements Refillable {
    @Override
    public void doRefill() {
        this.refillStrategy = new NoRefill();
    }
}
