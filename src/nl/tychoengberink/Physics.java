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
            double yd = ball.getY() - ball1.getY();
            double distSqr = (xd * xd) + (yd * yd);

//            if (distSqr <= (A.getRadius() + B.getRadius()) * (A.getRadius() + B.getRadius())) {
//                double xVelocity = B.getSpeedX() - A.getSpeedX();
//                double yVelocity = B.getSpeedY() - A.getSpeedY();
//                double dotProduct = xd * xVelocity + yd * yVelocity;
//                if (dotProduct > 0) {
//                    double collisionScale = dotProduct / distSqr;
//                    double xCollision = xd * collisionScale;
//                    double yCollision = yd * collisionScale;
//                    double combinedMass = A.getMass() + B.getMass();
//                    double collisionWeightA = 2 * B.getMass() / combinedMass;
//                    double collisionWeightB = 2 * A.getMass() / combinedMass;
//                    A.speedX += collisionWeightA * xCollision;
//                    A.speedY += collisionWeightA * yCollision;
//                    B.speedX -= collisionWeightB * xCollision;
//                    B.speedY -= collisionWeightB * yCollision;
//
//                }
//            }
        }

    }

}
