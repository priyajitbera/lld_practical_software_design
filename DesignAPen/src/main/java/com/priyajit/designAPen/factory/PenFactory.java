package com.priyajit.designAPen.factory;

import com.priyajit.designAPen.pen.BallPen;
import com.priyajit.designAPen.pen.FountainPen;
import com.priyajit.designAPen.pen.GelPen;
import com.priyajit.designAPen.pen.UserNThrowPen;

public class PenFactory {

    public static GelPen celloGelPen() {
        GelPen pen = new GelPen();
        pen.setName("Cello Gel Pen");
        pen.setBrand("Cello");
        pen.setPrice(15);
        return pen;
    }

    public static FountainPen parkerFountainPen() {
        FountainPen pen = new FountainPen();
        pen.setName("Parker Fountain Pen");
        pen.setBrand("Parker");
        pen.setPrice(550);
        return pen;
    }

    public static UserNThrowPen agniUseNThrowPen() {
        UserNThrowPen pen = new UserNThrowPen();
        pen.setName("Agni UseNThrow Pen");
        pen.setBrand("Agni");
        pen.setPrice(5);
        return pen;
    }

    public static BallPen lincBallPen() {
        BallPen pen = new BallPen();
        pen.setName("Linc Ball Pen");
        pen.setBrand("Linc");
        pen.setPrice(10);
        return pen;
    }
}
