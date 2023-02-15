package org.example.pen;

import org.example.refill.BallRefill;
import org.example.refillable.Refillable;

public class BallPen extends Pen implements Refillable {
    @Override
    public void refill() {
        this.refill = new BallRefill();
    }
}
