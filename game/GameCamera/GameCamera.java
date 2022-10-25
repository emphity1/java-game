package game.GameCamera;

import game.Game;
import game.entities.Entity;

public class GameCamera {

    private float xOffset;
    private float yOffset;

    private Game game;


    //center the camera
    public void centerOnEntity(Entity e){
        xOffset = e.getX() - game.getWidth() / 2 + e.getWidth() / 2; //center the camera on CENTER of our player
        yOffset = e.getY() - game.getHeight() / 2 + e.getHeight() / 2;
    }


    public void move(Game game,float xAmt, float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
        this.game = game;

    }


    


    
    public float getXOffset() {
        return this.xOffset;
    }

    public void setXOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getYOffset() {
        return this.yOffset;
    }

    public void setYOffset(float yOffset) {
        this.yOffset = yOffset;
    }

    public GameCamera(Game game,float xOffset,float yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.game = game;

    }
    
}
