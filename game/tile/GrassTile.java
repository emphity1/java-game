package game.tile;

import game.Assets;

public class GrassTile extends Tile {

    public GrassTile(int id) {
        super(Assets.grass,id);
        
    }

    public  boolean isSolid(){
        return false;
    }
    
}
