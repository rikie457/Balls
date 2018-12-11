package nl.tychoengberink;

import java.awt.*;

public class Ball extends Shape {
    private double radius;

    Ball(double x, double y, double width, double height, Color color, double bx, double by, double speedY, double speedX, double mass) {
        super(x, y, width, height, color, bx, by, speedY, speedX, mass);
        this.radius = width / 2;
    }

    Ball(double x, double y, double width, double height, Color color, double bx, double by, double mass) {
        super(x, y, width, height, color, bx, by, mass);
        this.radius = width / 2;
    }

    public void draw(Graphics g) {
        move();

        checkHorizontalCollision();
        checkVerticalCollision();

        drawShape(g);
    }

    @Override
    public void drawShape(Graphics g) {
        g.setColor(this.color);
        g.fillOval((int) this.x, (int) this.y, (int) this.width, (int) this.height);
    }

}


