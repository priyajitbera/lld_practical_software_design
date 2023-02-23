package com.priyajit.designAPen;

import com.priyajit.designAPen.pen.BallPen;
import com.priyajit.designAPen.pen.FountainPen;
import com.priyajit.designAPen.pen.GelPen;
import com.priyajit.designAPen.factory.PenFactory;
import com.priyajit.designAPen.pen.UserNThrowPen;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Create Pens using Pen Factory
        BallPen ballPen = PenFactory.lincBallPen();
        FountainPen fountainPen = PenFactory.parkerFountainPen();
        UserNThrowPen useNThrowPen = PenFactory.agniUseNThrowPen();
        GelPen gelPen = PenFactory.celloGelPen();

        // do initial refill
        ballPen.doRefill();
        fountainPen.doRefill();
        useNThrowPen.doRefill();
        gelPen.doRefill();

        // Print Pen details
        System.out.println(ballPen);
        System.out.println(fountainPen);
        System.out.println(useNThrowPen);
        System.out.println(gelPen);
    }
}
/*
std out:
Pen{name='Linc Ball Pen', brand='Linc', price=10, refillStrategy=Refill{name='BallRefill'}}
Pen{name='Parker Fountain Pen', brand='Parker', price=550, refillStrategy=Refill{name='Cartridge Refill'}}
Pen{name='Agni UseNThrow Pen', brand='Agni', price=5, refillStrategy=Refill{name='No Refill'}}
Pen{name='Cello Gel Pen', brand='Cello', price=15, refillStrategy=Refill{name='BallRefill'}}
* */
