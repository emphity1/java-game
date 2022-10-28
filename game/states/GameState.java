package game.states;

import java.awt.Graphics;

import game.handler.Handler;
import game.worlds.World;

public class GameState extends State {

    private World world;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"/home/dima/Documents/GitHub/java-game/game/world1.txt"); //WORLD LOAD PATH
        handler.setWorld(world);
    }


    @Override
    public void tick() {
        world.tick();


        
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        
    }
    
}
