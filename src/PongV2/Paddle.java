package PongV2;

import java.awt.*;

public interface Paddle {
    void draw(Graphics g);
    void move();
    int getY();
}
