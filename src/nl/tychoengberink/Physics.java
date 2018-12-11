package nl.tychoengberink;

import java.awt.*;
import java.util.ArrayList;

public class Physics {
    public void checkCollisionBall(Ball ball, ArrayList<Ball> balls) {
        for (int i = 0; i < balls.size(); i++) {
            if (ball == balls.get(i)) {
                continue;
            }
            double xd = ball.getX() - balls.get(i).getX();
            double yd = ball.getY() - balls.get(i).getY();
            double distSqr = (xd * xd) + (yd * yd);
            if (distSqr <= (ball.getRadius() + balls.get(i).getRadius()) * (ball.getRadius() + balls.get(i).getRadius())) {
                Info.addToBallCollisionCounter();
                double xVelocity = balls.get(i).getSpeedX() - ball.getSpeedX();
                double yVelocity = balls.get(i).getSpeedY() - ball.getSpeedY();
                double dotProduct = xd * xVelocity + yd * yVelocity;

                if (dotProduct > 0) {
                    double collisionScale = dotProduct / distSqr;
                    double xCollision = xd * collisionScale;
                    double yCollision = yd * collisionScale;
                    double combinedMass = ball.getMass() + balls.get(i).getMass();
                    double collisionWeightA = 2 * balls.get(i).getMass() / combinedMass;
                    double collisionWeightB = 2 * ball.getMass() / combinedMass;
                    ball.speedX += collisionWeightA * xCollision;
                    ball.speedY += collisionWeightA * yCollision;
                    balls.get(i).speedX -= collisionWeightB * xCollision;
                    balls.get(i).speedY -= collisionWeightB * yCollision;

                }
            }
        }

    }

}
