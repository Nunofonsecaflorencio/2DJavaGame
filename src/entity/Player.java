package entity;

import game.GamePanel;
import game.KeyHandler;

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
}
