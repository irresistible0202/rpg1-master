package entity;

import window.Game;

import java.awt.*;

public class GameObject {

    public Game game;

    int x, y;
    int id;

    int deltX = 0, deltY = 0;

    public GameObject(Game game, int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;
    }

    public  void move() {
        x = x + deltX;
        y = y + deltY;
    }
    public void render(Graphics g) {

    }

}
