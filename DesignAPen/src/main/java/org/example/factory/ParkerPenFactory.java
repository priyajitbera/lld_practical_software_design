package org.example.factory;

import org.example.pen.FountainPen;
import org.example.pen.Pen;

public class ParkerPenFactory {

    public static FountainPen parkerFrontier(){
        FountainPen pen = PenFactory.fountainPen();
        pen.setBrand("Parker");
        pen.setName("Parker Frontier");
        pen.setPrice(600);
        return pen;
    }
}
