package world;

import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Level1 {

    public int count_tile_width = 13;
    public int count_tile_height = 10;

    BufferedImage image;

    public Tile[] tiles = new Tile[256];

    public int [] [] map = {
            {0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1},
            {0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
            {0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
    };

    public Level1(){

        try {
            image = ImageIO.read(new File("images/Tiles.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }

        tiles[0] = new Tile(image.getSubimage(0, 64, 64, 64), 0, false);
        tiles[1] = new Tile(image.getSubimage(64, 0, 64, 64), 1, true);

    }
    public void move() {

    }
    public void render(Graphics g) {
        for (int y = 0; y <count_tile_height; y++) {
            for (int x = 0; x <count_tile_width ; x++) {
                tiles[map[y][x]].render(g, x*64, y*64);

            }

        }

    }
}
