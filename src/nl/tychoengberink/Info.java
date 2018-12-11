package nl.tychoengberink;

import java.awt.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class Info {

    public static BigInteger wallcollisionCounter = BigInteger.valueOf(0);
    public static BigInteger ballcollisionCounter = BigInteger.valueOf(0);
    public int minmass, maxmass;


    public static void addToWallCollisionCounter(){
        wallcollisionCounter = wallcollisionCounter.add(BigInteger.valueOf(1));
    }

    public static void addToBallCollisionCounter(){
        ballcollisionCounter = ballcollisionCounter.add(BigInteger.valueOf(1));
    }


    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawString( "Wall Collisions: " + wallcollisionCounter.toString(), 10, 10);
        g.drawString( "Ball Collisions: " + ballcollisionCounter.toString(), 10, 20);
    }
}
