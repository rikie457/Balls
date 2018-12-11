package nl.tychoengberink;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CanvasPanel extends JPanel {
    private double maxwidth;
    private double maxheight;
    public ArrayList<Ball> balls = new ArrayList<Ball>();
    private Info info = new Info();
    private Physics physics = new Physics();

    public CanvasPanel(double maxwidth, double maxheight) {
        this.maxwidth = maxwidth;
        this.maxheight = maxheight;
    }

    public void initialize() {
        double wh, mass;
        super.setBackground(Color.black);

        for (int i = 0; i < 200; i++) {
            wh = (Math.random() * 25) + 10;
            mass = ((wh / 2) *  (wh / 2)) * Math.PI;
            balls.add(new Ball((Math.random() * 1920), (Math.random() * 1080), wh, wh, new Color((int) (Math.random() * 0x1000000)), this.maxwidth, this.maxheight, (Math.random() * 2), (Math.random() * 2), mass));
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

            for (int j = 0; j < balls.size(); j++) {
               physics.checkCollisionBall(balls.get(i), balls);
            }

        }


    }
}