package nl.tychoengberink;

import java.awt.*;

abstract class Shape {
    double mass, x, y, width, height, speedX, speedY, bx, by;
    Color color;

    Shape(double x, double y, double width, double height, Color color, double bx, double by, double mass) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.speedY = (Math.random() * 10) + 1;
        this.speedX = (Math.random() * 10) + 1;
        this.bx = bx;
        this.by = by;
        this.mass = mass;
    }

    Shape(double x, double y, double width, double height, Color color, double bx, double by, double speedY, double speedX, double mass) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.speedY = speedY;
        this.speedX = speedX;
        this.bx = bx;
        this.by = by;
        this.mass = mass;
    }

    public abstract void draw(Graphics g);

    public abstract void drawShape(Graphics g);

    public double getMass() {
        return this.mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSpeedX() {
        return this.speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return this.speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public double getBX() {
        return this.bx;
    }

    public void setBX(double bx) {
        this.bx = bx;
    }

    public double getBY() {
        return this.by;
    }

    public void setBY(double by) {
        this.by = by;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    void checkHorizontalCollision() {
        if (this.x - this.width < 0) {
            this.speedX = -this.speedX;
            this.x = this.width;
        } else if (this.x + this.width > this.bx) {
            this.speedX = -this.speedX;
            this.x = this.bx - this.width;
        }
    }

    void checkVerticalCollision() {
        if (this.y - this.width < 0) {
            this.speedY = -this.speedY;
            this.y = this.width;
        } else if (this.y + this.width > this.by) {
            this.speedY = -this.speedY;
            this.y = this.by - this.width;
        }
    }

    void move () {
        this.x = this.x + this.speedX;
        this.y = this.y + this.speedY;
    }
}
