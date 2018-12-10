package nl.tychoengberink;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CanvasPanel extends JPanel {
    private double maxwidth;
    private double maxheight;
    public ArrayList<Ball> balls = new ArrayList<Ball>();

    public CanvasPanel(double maxwidth, double maxheight) {
        this.maxwidth = maxwidth;
        this.maxheight = maxheight;
    }

    public void initialize() {
        double wh, mass;
        super.setBackground(Color.black);
        for (int i = 0; i < 100000; i++) {
            wh = (Math.random() * 25) + 1;
            mass = ((wh / 2) *  (wh / 2)) * Math.PI;
            //   new Color((int) (Math.random() * 0x1000000));
            balls.add(new Ball((Math.random() * 1920), (Math.random() * 1080), wh, wh, new Color((int) (Math.random() * 0x1000000)), this.maxwidth, this.maxheight, (Math.random() * 2), (Math.random() * 2), mass));
        }

    }


    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i).draw(g);

            for (int j = 0; j < balls.size(); j++) {
               // Physics.checkCollisionBall(balls.get(i), balls);
            }

        }


    }
}