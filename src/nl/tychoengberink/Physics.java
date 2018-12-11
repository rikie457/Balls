package nl.tychoengberink;

import java.util.ArrayList;

public class Physics {
    public static void checkCollision(Shape shape, ArrayList<Shape> shapes) {
        for (Shape shape1 : shapes) {
            if (shape == shape1) {
                continue;
            }
            Shape A = shape;
            Shape B = shape1;
            double xd = shape.getX() - shape1.getX();
            double yd = shape.getY() - shape1.getY();
            double distSqr = (xd * xd) + (yd * yd);
            if (distSqr <= (A.getWidth() + B.getWidth()) * (A.getWidth() + B.getWidth())) {
                double xVelocity = B.getSpeedX() - A.getSpeedX();
                double yVelocity = B.getSpeedY() - A.getSpeedY();
                double dotProduct = xd * xVelocity + yd * yVelocity;
                if (dotProduct > 0) {
                    double collisionScale = dotProduct / distSqr;
                    double xCollision = xd * collisionScale;
                    double yCollision = yd * collisionScale;
                    double combinedMass = A.getMass() + B.getMass();
                    double collisionWeightA = 2 * B.getMass() / combinedMass;
                    double collisionWeightB = 2 * A.getMass() / combinedMass;
                    A.speedX += collisionWeightA * xCollision;
                    A.speedY += collisionWeightA * yCollision;
                    B.speedX -= collisionWeightB * xCollision;
                    B.speedY -= collisionWeightB * yCollision;
                }
            }
        }
    }
}