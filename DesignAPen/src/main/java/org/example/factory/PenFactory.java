package org.example.factory;

import org.example.pen.BallPen;
import org.example.pen.FountainPen;
import org.example.pen.GelPen;

public class PenFactory {

    public static BallPen ballPen(){
        BallPen ballPen = new BallPen();
        return ballPen;
    }

    public static GelPen gelPen(){
        GelPen gelPen = new GelPen();
        return gelPen;
    }

    public static FountainPen fountainPen(){
        FountainPen fountainPen = new FountainPen();
        return fountainPen;
    }
}
