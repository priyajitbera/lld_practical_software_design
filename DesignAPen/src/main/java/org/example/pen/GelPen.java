package org.example.pen;

import org.example.refillable.GelRefillable;
import org.example.refill.GelRefill;

public class GelPen extends Pen implements GelRefillable {

    GelRefill gelRefill;

    void write() {

    }

    public void refill(GelRefill gelRefill) {
        this.gelRefill = gelRefill;
    }
}
