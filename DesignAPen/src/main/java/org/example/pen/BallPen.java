package org.example.pen;

import org.example.refillable.BallRefillable;
import org.example.refill.BallRefill;

public class BallPen extends Pen implements BallRefillable {

    BallRefill ballRefill;

    public void refill(BallRefill ballRefill) {
        this.ballRefill = ballRefill;
    }

    void write() {
    }
}
