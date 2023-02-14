package org.example.pen;

import org.example.refillable.CatrigeRefillable;
import org.example.refill.CatridgeRefill;

public class FountainPen extends Pen implements CatrigeRefillable {

    CatridgeRefill catridgeRefill;

    void write() {

    }

    public void refill(CatridgeRefill catridgeRefill) {
        this.catridgeRefill = catridgeRefill;
    }
}
