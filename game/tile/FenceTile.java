package game.tile;


import game.Assets;

public class FenceTile extends Tile {

    public FenceTile(int id) {
        super(Assets.fence, id);
        
    }

    
    public  boolean isSolid(){
        return true;
    }
    
}
