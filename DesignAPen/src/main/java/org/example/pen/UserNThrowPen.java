package org.example.pen;

import org.example.refill.NoRefill;
import org.example.refillable.Refillable;

public class UserNThrowPen extends Pen implements Refillable {
    @Override
    public void refill() {
        this.refill = new NoRefill();
    }
}
