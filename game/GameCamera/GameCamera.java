package game.GameCamera;

import game.handler.Handler;
import game.tile.Tile;
import game.Game;
import game.entities.Entity;

public class GameCamera {

    private float xOffset;
    private float yOffset;

    private Handler handler;


    //center the camera
    public void centerOnEntity(Entity e){
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2; //center the camera on CENTER of our player
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
        checkBlankSpace();
    }


    public void move(float xAmt, float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
        

    }

    //put limits on what camera can see, like whitespaces out of the map
    public void checkBlankSpace(){
        if(xOffset<0){
            xOffset=0;
        }else if(xOffset> handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()){
            xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
        }
        if(yOffset<0){
            yOffset=0;
        }else if(yOffset> handler.getWorld().getWidth() * Tile.TILEHEIGHT - handler.getHeight()){
            yOffset = handler.getWorld().getWidth() * Tile.TILEHEIGHT - handler.getHeight();
        }



    }


    
    public float getxOffset() {
        return this.xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return this.yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }

    public GameCamera(Handler handler,float xOffset,float yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.handler = handler;

    }
    
}
