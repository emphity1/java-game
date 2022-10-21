package game.states;

import java.awt.Graphics;

import game.Assets;
import game.entities.creatures.Player;
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
    }
    
}
