package entity;

import window.Game;

import java.awt.*;

public class Player extends GameObject {
    int width, height;

    public Player(Game game, int x, int y) {
        super(game,x,y);
        this.width = 32;
        this.height = 32;
    }

    @Override
    public void move() {

        this.deltX = 0;

        if (game.keyManager.isRight) {
            this.deltX = 3;
        }else
            if (game.keyManager.isLeft) {
                this.deltX = -3;
            }

            x = x + deltX;
            y = y + deltY;
    }

    public void render(Graphics g){
        g.fillRect(x, y, width, height);
    }

}
