package com.priyajit.entitiy.parkinglot;

public class EVSlot extends Slot implements SupportCharging {
    private Charger charger;

    public void setCharger(Charger charger) {
        this.charger = charger;
    }

    @Override
    public Charger getCharger() {
        return charger;
    }
}
