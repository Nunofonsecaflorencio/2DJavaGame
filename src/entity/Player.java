package entity;

import game.GamePanel;
import game.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keys;

    public Player(GamePanel gp, KeyHandler keys){
        this.gp = gp;
        this.keys = keys;
        spriteInterval =20;
        setDefaultValues();
        getPlayerImage();
    }

    private void getPlayerImage() {
        try{
            p1 = ImageIO.read(new File("res/player/player1.png"));
            p2 = ImageIO.read(new File("res/player/player2.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }
    public void update(){
        moving = false;
        if(keys.wPressed){
            y -= speed;
            moving = true;
        }
        else if(keys.sPressed) {
            y += speed;
            moving = true;
        }
        else if(keys.aPressed) {
            x -= speed;
            moving = true;
        }
        else if(keys.dPressed) {
            x += speed;
            moving = true;
        }
        else if(keys.enterPressed) {
            setDefaultValues();
        }

        if (moving){
            spriteCounter++;

            if(spriteCounter > spriteInterval){
                if (spriteNum == 2)
                    spriteNum = 1;
                else if (spriteNum == 1)
                    spriteNum = 2;

                spriteCounter = 0;
            }
        }else {
            spriteNum = 1;
        }

    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;

        if (spriteNum == 1)
            image = p1;
        else if (spriteNum == 2)
            image = p2;

       g2.drawImage(image, x, y, gp.TILE_SIZE, gp.TILE_SIZE, null);
    }
}
