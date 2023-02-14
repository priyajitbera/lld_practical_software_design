package org.example;

import org.example.factory.CelloPenFactory;
import org.example.pen.BallPen;
import org.example.refill.BallRefill;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BallPen ballPen = CelloPenFactory.celloGriper();
        System.out.println(ballPen);
    }
}
