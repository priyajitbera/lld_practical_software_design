package com.priyajit.designAPen;

import com.priyajit.designAPen.pen.*;
import com.priyajit.designAPen.factory.PenFactory;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Create Pens using Pen Factory
        List<Pen> pens = List.of(PenFactory.lincBallPen(), PenFactory.parkerFountainPen(), PenFactory.agniUseNThrowPen(), PenFactory.celloGelPen());

        // Print Pen details
        System.out.println("Added Pens(before writing) \n" + pens);

        String paraToWrite = "This is being written using a pen";

        // Write using pen
        for(Pen pen : pens){
            pen.write(paraToWrite);
        }

        // Print Pen details
        System.out.println("Added Pens(after writing) \n" + pens);
    }
}
/*
std out:
Pen{name='Linc Ball Pen', brand='Linc', price=10, refillStrategy=Refill{name='BallRefill'}}
Pen{name='Parker Fountain Pen', brand='Parker', price=550, refillStrategy=Refill{name='Cartridge Refill'}}
Pen{name='Agni UseNThrow Pen', brand='Agni', price=5, refillStrategy=Refill{name='No Refill'}}
Pen{name='Cello Gel Pen', brand='Cello', price=15, refillStrategy=Refill{name='BallRefill'}}
* */
