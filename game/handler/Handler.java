package game.handler;

import game.Game;
import game.GameCamera.GameCamera;
import game.input.KeyManager;
import game.worlds.World;

public class Handler {
    private Game game;
    private World world;

    public Handler(Game game){
        this.game = game;
    }


    
    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }
    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }
    public int getWidth(){
        return game.getWidth();
    }
    public int getHeight(){
        return game.getHeight();
    }


    //GETTERS AND SETTERS
    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return this.world;
    }

    public void setWorld(World world) {
        this.world = world;
    }



    
    
}
