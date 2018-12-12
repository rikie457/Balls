package nl.tychoengberink;

import java.awt.*;
import java.util.ArrayList;

public class Ball {
    private double mass;
    private double x; // X axle position
    private double y; //Y axle position
    private double width; //width of Ball
    private double height; //height of Ball
    private double radius; //Radius of Ball (width/2)
    public double speedX; //Speed Y
    public double speedY; //Speed X
    private double bx; //boundry X axle
    private double by; //boundry Y axle
    private Color color; //Color of Ball
    private ArrayList<Ball> balls;

    public Ball(double x, double y, double width, double height, Color color, double bx, double by, double speedY, double speedX, double mass, ArrayList<Ball> balls) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.radius = width / 2;
        this.speedY = speedY;
        this.speedX = speedX;
        this.bx = bx;
        this.by = by;
        this.mass = mass;
        this.balls = balls;
    }

    public Ball(double x, double y, double width, double height, Color color, double bx, double by, double mass, ArrayList<Ball> balls) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.radius = width / 2;
        this.speedY = (Math.random() * 10) + 1;
        this.speedX = (Math.random() * 10) + 1;
        this.bx = bx;
        this.by = by;
        this.mass = mass;
        this.balls = balls;

    }

    public void checkCollisionBall( ArrayList<Ball> balls) {
        for (int i = 0; i < balls.size(); i++) {
            if (this == balls.get(i)) {
                continue;
            }
            double xd = this.getX() - balls.get(i).getX();
            double yd = this.getY() - balls.get(i).getY();
            double distSqr = (xd * xd) + (yd * yd);
            if (distSqr <= (this.getRadius() + balls.get(i).getRadius()) * (this.getRadius() + balls.get(i).getRadius())) {
                Info.addToBallCollisionCounter();
                double xVelocity = balls.get(i).getSpeedX() - this.getSpeedX();
                double yVelocity = balls.get(i).getSpeedY() - this.getSpeedY();
                double dotProduct = xd * xVelocity + yd * yVelocity;

                if (dotProduct > 0) {
                    double collisionScale = dotProduct / distSqr;
                    double xCollision = xd * collisionScale;
                    double yCollision = yd * collisionScale;
                    double combinedMass = this.getMass() + balls.get(i).getMass();
                    double collisionWeightA = 2 * balls.get(i).getMass() / combinedMass;
                    double collisionWeightB = 2 * this.getMass() / combinedMass;
                    this.speedX += collisionWeightA * xCollision;
                    this.speedY += collisionWeightA * yCollision;
                    balls.get(i).speedX -= collisionWeightB * xCollision;
                    balls.get(i).speedY -= collisionWeightB * yCollision;

                }
            }
        }

    }

    public void draw(Graphics g) {

        this.x = x + speedX;
        this.y = y + speedY;

        if (this.x - this.radius < 0) {
            this.speedX = -this.speedX;
            Info.addToWallCollisionCounter();
            this.x = this.radius;
        } else if (this.x + this.radius > this.bx) {
            Info.addToWallCollisionCounter();
            this.speedX = -this.speedX;

            this.x = this.bx - this.radius;
        }

        if (this.y - this.radius < 0) {
            Info.addToWallCollisionCounter();
            this.speedY = -this.speedY;
            //setColor(Color.red);
            this.y = this.radius;
        } else if (this.y + this.radius > this.by) {
            Info.addToWallCollisionCounter();
            this.speedY = -this.speedY;
            // setColor(Color.red);
            this.y = this.by - this.radius;
        }
        checkCollisionBall(balls);
        g.setColor(this.color);
        g.fillOval((int) this.x, (int) this.y, (int) this.width, (int) this.height);


    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getMass() {
        return this.mass;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getSpeedX() {
        return this.speedX;
    }

    public double getSpeedY() {
        return this.speedY;
    }

    public double getRadius() {
        return this.radius;
    }


}


