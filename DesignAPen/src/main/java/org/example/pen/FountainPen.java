package org.example.pen;

import org.example.refill.CartridgeRefill;
import org.example.refillable.Refillable;

public class FountainPen extends Pen implements Refillable {

    @Override
    public void refill() {
        this.refill = new CartridgeRefill();
    }
}
