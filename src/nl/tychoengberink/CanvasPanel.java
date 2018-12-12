package nl.tychoengberink;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CanvasPanel extends JPanel {
    public ArrayList<Ball> balls = new ArrayList<Ball>();
    private double maxwidth;
    private double maxheight;
    private double amountofballs;
    private Info info = new Info();

    public CanvasPanel(double maxwidth, double maxheight, int amountofballs) {
        this.maxwidth = maxwidth;
        this.maxheight = maxheight;
        this.amountofballs = amountofballs;
    }

    public void initialize() {
        double wh, mass;
        super.setBackground(Color.black);
        for (int i = 0; i < amountofballs; i++) {
            wh = (Math.random() * 25) + 10;
            mass = ((wh / 2) * (wh / 2)) * Math.PI;
            balls.add(new Ball(Utility.randomDoubleFromRange(0, this.maxwidth), Utility.randomDoubleFromRange(0, this.maxheight), wh, wh, new Color((int) (Math.random() * 0x1000000)), this.maxwidth, this.maxheight, Utility.randomDoubleFromRange(-2, 2), Utility.randomDoubleFromRange(-2, 2), mass, balls, "fill"));
        }

        info.getLowestMass(balls);
        info.getHighestMass(balls);
        info.getBallCount(balls);

    }


    public void paint(Graphics g) {
        Info.addToRefreshCounter();
        Info.updateHighestSpeedX(balls);
        Info.updateHighestSpeedY(balls);


        super.paint(g);
        info.draw(g);
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i).draw(g);

        }


    }
}