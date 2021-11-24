package PongV2;

import java.awt.*;

public class Ball {

    double x, y , xVel, yVel;
    int score;


    public Ball(){
        x = 350;
        y = 250;
        xVel = 2 * getRandomDirection();
        yVel = 2 * getRandomDirection();
        score = 0;
    }

    public void stopBall (){
        xVel = 0;
        yVel = 0;
    }

    public int getRandomDirection(){
        int rand = (int) (Math.random() * 2);
        if(rand == 1){
            return 1;
        }
        else{
            return -1;
        }
    }

    public void draw (Graphics g){
        g.setColor(Color.white);
        g.fillOval((int) x - 10, (int) y - 10, 20, 20);
    }

    public void checkPaddleCollision(Paddle p1, Paddle p2){
        boolean hit = false;
        if(x == 50){
            if(y >= p1.getY() && y <= p1.getY() + 80){
                xVel = -xVel;
                hit = true;
//                xVel += 0.25;
//                yVel += 0.25;
            }
        }
        else if(x == 650){
            if(y >= p2.getY() && y <= p2.getY() + 80){
                xVel = -xVel;

            }
        }
        if(hit==true) score++;
    }

    public void move(){
        x += xVel;
        y += yVel;

        if(y < 10){
            yVel = -yVel;
        }
        if( y > 490){
            yVel = -yVel;
        }

        if(x < -10 || x > 710){
            stopBall();
        }
    }

    public int getX(){
        return (int)x;
    }
    public int getY(){
        return (int)y;
    }
    public int getScore() {return  score;}
}
