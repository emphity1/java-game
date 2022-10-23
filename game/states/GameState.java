package game.states;

import java.awt.Graphics;

import game.Assets;
import game.entities.creatures.Creatures;
import game.entities.creatures.Player;
import game.tile.Tile;
import game.*;

public class GameState extends State {

    private Player player;

    public GameState(Game game){
        super(game);
        player = new Player(game,100, 100);
    }


    @Override
    public void tick() {
        player.tick();


        
    }

    @Override
    public void render(Graphics g) {
        player.render(g);   
        
        Tile.tiles[0].render(g,0,0);
        Tile.tiles[0].render(g,8,8);
        Tile.tiles[0].render(g,16,16);
        Tile.tiles[0].render(g,24,24);
        
        Tile.tiles[1].render(g, 0, 0);
    }
    
}
