package nl.tychoengberink;

import java.awt.*;
import java.util.ArrayList;

public class Physics {
    public static void checkCollisionBall(Ball ball, ArrayList<Ball> balls) {
        for (Ball ball1 : balls) {
            if (ball == ball1) {
                continue;
            }
            Ball A = ball;
            Ball B = ball1;
            double xd = ball.getX() - ball1.getX();
            Info.addToCalculationCounter();
            double yd = ball.getY() - ball1.getY();
            Info.addToCalculationCounter();
            double distSqr = (xd * xd) + (yd * yd);
            Info.addToCalculationCounter();
            if (distSqr <= (A.getRadius() + B.getRadius()) * (A.getRadius() + B.getRadius())) {
                double xVelocity = B.getSpeedX() - A.getSpeedX();
                Info.addToCalculationCounter();
                double yVelocity = B.getSpeedY() - A.getSpeedY();
                Info.addToCalculationCounter();
                double dotProduct = xd * xVelocity + yd * yVelocity;
                Info.addToCalculationCounter();

                if (dotProduct > 0) {
                    double collisionScale = dotProduct / distSqr;
                    Info.addToCalculationCounter();
                    double xCollision = xd * collisionScale;
                    Info.addToCalculationCounter();
                    double yCollision = yd * collisionScale;
                    Info.addToCalculationCounter();
                    double combinedMass = A.getMass() + B.getMass();
                    Info.addToCalculationCounter();
                    double collisionWeightA = 2 * B.getMass() / combinedMass;
                    Info.addToCalculationCounter();
                    double collisionWeightB = 2 * A.getMass() / combinedMass;
                    Info.addToCalculationCounter();
                    A.speedX += collisionWeightA * xCollision;
                    Info.addToCalculationCounter();
                    A.speedY += collisionWeightA * yCollision;
                    Info.addToCalculationCounter();
                    B.speedX -= collisionWeightB * xCollision;
                    Info.addToCalculationCounter();
                    B.speedY -= collisionWeightB * yCollision;
                    Info.addToCalculationCounter();

                }
            }
        }

    }

}
