package com.priyajit.designAPen.factory;

import com.priyajit.designAPen.pen.BallPen;
import com.priyajit.designAPen.pen.FountainPen;
import com.priyajit.designAPen.pen.GelPen;
import com.priyajit.designAPen.pen.UserNThrowPen;

public class PenFactory {

    public static GelPen celloGelPen() {
        return new GelPen("Cello Gel Pen", "Cello", 20, RefillFactory.gelRefill());
    }

    public static FountainPen parkerFountainPen() {
        return new FountainPen("Parker Fountain Pen", "Parker", 500, RefillFactory.cartridgeRefill());
    }

    public static UserNThrowPen agniUseNThrowPen() {
        return new UserNThrowPen("Agni UseNThrow Pen", "Agni", 5, RefillFactory.integratedRefill());
    }

    public static BallPen lincBallPen() {
        return new BallPen("Linc Ball Pen", "Linc", 15, RefillFactory.ballRefill());
    }
}
