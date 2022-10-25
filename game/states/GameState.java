package game.states;

import java.awt.Graphics;

import game.entities.creatures.Player;
import game.handler.Handler;
import game.worlds.World;
import game.*;

public class GameState extends State {

    private Player player;
    private World world;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"/home/dima/Documents/GitHub/java-game/game/world1.txt"); //WORLD LOAD PATH
        handler.setWorld(world);
        player = new Player(handler,100, 100);
    }


    @Override
    public void tick() {
        world.tick();
        player.tick();


        
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);   
        
    }
    
}
