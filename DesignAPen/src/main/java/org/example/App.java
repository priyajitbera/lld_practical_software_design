package org.example;

import org.example.factory.PenFactory;
import org.example.pen.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        BallPen ballPen = PenFactory.lincBallPen();
        FountainPen fountainPen = PenFactory.parkerFountainPen();
        UserNThrowPen useNThrowPen = PenFactory.agniUseNThrowPen();
        GelPen gelPen = PenFactory.celloGelPen();
        ballPen.refill();

        fountainPen.refill();
        useNThrowPen.refill();
        gelPen.refill();
        System.out.println(ballPen);
        System.out.println(fountainPen);
        System.out.println(useNThrowPen);
        System.out.println(gelPen);
    }
}
/*
std out:
Pen{name='Linc Ball Pen', brand='Linc', price=10, refill=Refill{name='BallRefill'}}
Pen{name='Parker Fountain Pen', brand='Parker', price=550, refill=Refill{name='Cartridge Refill'}}
Pen{name='Agni UseNThrow Pen', brand='Agni', price=5, refill=Refill{name='No Refill'}}
Pen{name='Cello Gel Pen', brand='Cello', price=15, refill=Refill{name='BallRefill'}}
* */
