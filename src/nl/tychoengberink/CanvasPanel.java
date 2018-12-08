package nl.tychoengberink;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CanvasPanel extends JPanel {
    private double x, y, wh, speedX, speedY, maxwidth, maxheight;
    public ArrayList<Ball> balls = new ArrayList<Ball>();
    public Physics physics = new Physics();

    public CanvasPanel(double maxwidth, double maxheight) {
        this.maxwidth = maxwidth;
        this.maxheight = maxheight;
    }

    public void initialize() {
        this.x = getWidth() / 2;
        this.y = getHeight() / 2;

        for (int i = 0; i < 100; i++) {
            wh = (Math.random() * 100) + 1;
            //new Color((int) (Math.random() * 0x1000000))
            balls.add(new Ball(this.x, this.y, wh, wh, Color.green, this.maxwidth, this.maxheight));
        }

    }


    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i).draw(g);

            for (int j = 0; j < balls.size(); j++) {
                    if(physics.checkCollisionBall(balls.get(i), balls)){
                        balls.get(i).setColor(Color.red);
                        balls.get(i).setSpeedX(-balls.get(i).getSpeedX());
                        balls.get(i).setSpeedY(-balls.get(i).getSpeedY());
                    }else{
                        balls.get(i).setColor(Color.green);
                    }

            }

        }


    }
}