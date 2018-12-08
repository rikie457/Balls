package nl.tychoengberink;

import java.awt.*;

public class Ball {
    private double x; // X axle position
    private double y; //Y axle position
    private double width; //width of Ball
    private double height; //height of Ball
    private double radius; //Radius of Ball (width/2)
    private double speedX; //Speed Y
    private double speedY; //Speed X
    private double bx; //boundry X axle
    private double by; //boundry Y axle
    private Color color; //Color of Ball

    public Ball(double x, double y, double width, double height, Color color, double bx, double by , double speedY, double speedX) {
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

    }

    public Ball(double x, double y, double width, double height, Color color, double bx, double by ) {
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


    }

    public void draw(Graphics g) {

        x = x + speedX;
        y = y + speedY;
//        System.out.println("this.width " + this.width);
//        System.out.println("this.height " +this.height);
//        System.out.println("this.radius " +this.radius);
//        System.out.println("this.x " +this.x);
//        System.out.println("this.y " +this.y);
//        System.out.println("this.by " +this.by);
//        System.out.println("this.bx " +this.bx);

        if (this.x - this.radius < 0) {
            this.speedX = -this.speedX;
           // setColor(Color.red);
            this.x = this.radius;
        } else if (this.x + this.radius > this.bx) {
            this.speedX = -this.speedX;
           // setColor(Color.red);
            this.x = this.bx - this.radius;
        }

        if (this.y - this.radius < 0) {
            this.speedY = -this.speedY;
            //setColor(Color.red);
            this.y = this.radius;
        } else if (this.y + this.radius > this.by) {
            this.speedY = -this.speedY;
           // setColor(Color.red);
            this.y = this.by - this.radius;
        }

        g.setColor(this.color);
        g.fillOval((int)this.x, (int)this.y, (int)this.width, (int)this.height);



    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getSpeedX(){ return this.speedX;}

    public double getSpeedY(){return this.speedY;}

    public double getRadius(){
        return this.radius;
    }


}

