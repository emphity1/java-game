package game.entities.creatures;

import java.awt.Graphics;

import game.Assets;
import game.Game;;

public class Player extends Creatures {
	private Game game;

	public Player(Game game,float x, float y) {
		super(x, y);
		this.game = game;
	}

	//handling input
	public void tick() {
		if(game.getKeyManager().up){
			y-=3;
		}
		if(game.getKeyManager().down){
			y+=3;
		}
		if(game.getKeyManager().left){
			x-=3;
		}
		if(game.getKeyManager().right){
			x+=3;
		}

	}

	
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, null);
	}

}