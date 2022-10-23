package game.tile;

import java.awt.image.BufferedImage;
import java.awt.Graphics;



public class Tile {

    //static vars
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile fenceTile = new FenceTile(1);

    




    //The Class
    public static final int TILEWIDTH = 48, TILEHEIGHT = 48;


    protected BufferedImage texture;
    protected final int id;

    //every id is specific to unique tile
    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
        

    }

    public void tick(){

    }
    public void render(Graphics g, int x,int y){
        g.drawImage(texture, x, y,TILEWIDTH,TILEHEIGHT,null);

    }

    public int getId(){
        return id;
    }

    public  boolean isSolid(){
        return false;
    }
    
}
