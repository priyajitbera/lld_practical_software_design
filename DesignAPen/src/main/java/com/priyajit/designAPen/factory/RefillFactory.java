package com.priyajit.designAPen.factory;

import com.priyajit.designAPen.strategy.BallRefill;
import com.priyajit.designAPen.strategy.CartridgeRefill;
import com.priyajit.designAPen.strategy.GelRefill;
import com.priyajit.designAPen.strategy.IntegratedRefill;

public class RefillFactory {
    public static CartridgeRefill cartridgeRefill() {
        return new CartridgeRefill("Cartridge Refill", 200);
    }

    public static BallRefill ballRefill() {
        return new BallRefill("Ball Refill", 500);
    }

    public static GelRefill gelRefill() {
        return new GelRefill("Gel Refill", 450);
    }

    public static IntegratedRefill integratedRefill() {
        return new IntegratedRefill("Integrated Refill", 500);
    }
}
