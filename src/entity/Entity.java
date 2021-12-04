package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int speed;
    BufferedImage p1, p2;
    boolean moving = false;

    int spriteNum = 1;
    int spriteCounter = 0;
    int spriteInterval;
}
