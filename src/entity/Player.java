package entity;

import game.GamePanel;
import game.KeyHandler;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keys;

    public Player(GamePanel gp, KeyHandler keys){
        this.gp = gp;
        this.keys = keys;
        setDefaultValues();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }
    public void update(){
        if(keys.wPressed){
            y -= speed;
        }
        else if(keys.sPressed) {
            y += speed;
        }
        else if(keys.aPressed) {
            x -= speed;
        }
        else if(keys.dPressed) {
            x += speed;
        }
        else if(keys.enterPressed) {
            setDefaultValues();
        }
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(x, y, gp.TILE_SIZE, gp.TILE_SIZE);
    }
}
