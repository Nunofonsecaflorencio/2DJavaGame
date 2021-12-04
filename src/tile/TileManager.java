package tile;

import game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class TileManager {

    GamePanel gp;
    Tile[] tiles;
    int[][] mapTile;

    public  TileManager(GamePanel gp){
        this.gp = gp;

        tiles = new Tile[3];
        mapTile = new int[gp.WORLD_ROW][gp.WORLD_ROW];

        getTileImage();
        loadMap("res/maps/world01.txt");
    }
    public void getTileImage(){
        try{
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(new File("res/tiles/sky.png"));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(new File("res/tiles/wall1.png"));

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(new File("res/tiles/wall2.png"));
            //System.out.println(new File("res/tiles/sky.png").getCanonicalPath());

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String path){
        try{
            FileReader fr = new FileReader(path);
            BufferedReader bfr = new BufferedReader(fr);

            try{
                for (int i = 0; i< gp.WORLD_ROW; i++) {
                    String[] line = bfr.readLine().split(" ");
                    for (int j = 0; j < gp.WORLD_COL; j++) {
                        mapTile[i][j] = Integer.parseInt(line[j]);
                    }
                }

            }catch(IOException ex){
                System.out.println("Erro ao ler arquivo.");
            }
        }catch(FileNotFoundException ex){
            System.out.println("Arquivo não encontrado.");
        }
    }
    public void draw(Graphics2D g2){
        for (int i = 0; i< gp.WORLD_ROW; i++){
            for(int j = 0; j< gp.WORLD_COL; j++){
                int x = j* gp.TILE_SIZE;
                int y = i* gp.TILE_SIZE;
                int inScreenX = x - gp.player.x + gp.player.screenX;
                int inScreenY = y - gp.player.y + gp.player.screenY;

                if(x + gp.TILE_SIZE> gp.player.x - gp.player.screenX &&
                    x - gp.TILE_SIZE< gp.player.x + gp.player.screenX &&
                    y + gp.TILE_SIZE> gp.player.y - gp.player.screenY &&
                    y - gp.TILE_SIZE< gp.player.y + gp.player.screenY) {
                    g2.drawImage(tiles[mapTile[i][j]].image, inScreenX, inScreenY, gp.TILE_SIZE, gp.TILE_SIZE, null);
                }

            }
        }
    }
}
