package nl.tychoengberink;

import java.awt.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class Info {

    public static BigInteger calculationcounter = BigInteger.valueOf(0);

    public static void addToCalculationCounter(){
        calculationcounter = calculationcounter.add(BigInteger.valueOf(1));
    }


    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawString( "Calculations: " + calculationcounter.toString(), 10, 10);
    }
}
