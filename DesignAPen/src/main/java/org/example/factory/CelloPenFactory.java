package org.example.factory;

import org.example.pen.BallPen;
import org.example.pen.GelPen;

public class CelloPenFactory {
    public static BallPen celloGriper(){
        BallPen pen = PenFactory.ballPen();
        pen.setBrand("Cello");
        pen.setName("Cello Gripper");
        pen.setPrice(10);
        return pen;
    }

    public static GelPen celloMyGel(){
        GelPen pen = PenFactory.gelPen();
        pen.setBrand("Cello");
        pen.setName("Cello My Gel");
        pen.setPrice(15);
        return pen;
    }
}
