package nl.tychoengberink;

import java.awt.*;

public class Square extends Shape {

    Square(double x, double y, double width, double height, Color color, double bx, double by, double speedY, double speedX, double mass) {
        super(x, y, width, height, color, bx, by, speedY, speedX, mass);
    }

    Square(double x, double y, double width, double height, Color color, double bx, double by, double mass) {
        super(x, y, width, height, color, bx, by, mass);
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
        g.fillRect((int) this.x, (int) this.y, (int) this.width, (int) this.height);
    }
}
