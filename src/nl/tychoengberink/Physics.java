package nl.tychoengberink;

import java.awt.*;
import java.util.ArrayList;

public class Physics {
    public boolean checkCollisionBall(Ball ball, ArrayList<Ball> balls){
        for(int i = 0; i < balls.size(); i++){
            if(ball == balls.get(i)){
                continue;
            }
            double xd = ball.getX() - balls.get(i).getX();
            double yd = ball.getY() - balls.get(i).getY();

            double sumRadius = ball.getRadius() + balls.get(i).getRadius();
            double sqrRadius = sumRadius * sumRadius;

            double distSqr = (xd * xd) + (yd * yd);


            if (distSqr <= sqrRadius)
            {
                ball.setX(ball.getSpeedX() + ball.getX());
                ball.setY(ball.getSpeedY() + ball.getY());
                ball.setSpeedX(ball.getSpeedY() - ball.getSpeedX());
                ball.setSpeedY(ball.getSpeedY() - ball.getSpeedY());
                ball.setColor(Color.red);
                return true;
            }
            ball.setColor(Color.green);
        }


        return false;
        }

}
