package game.entities.creatures;

import java.awt.Graphics;

import game.Assets;
import game.Game;;

public class Player extends Creatures {

	
	
	public Player(Game game, float x, float y) {
		super(game,x, y, Creatures.DEFAULT_CREATURE_WIDTH, Creatures.DEFAULT_CREATURE_HEIGHT);
	}

	@Override
	public void tick() {
		getInput();
		move();
		game.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up)
			yMove = -speed;
		if(game.getKeyManager().down)
			yMove = speed;
		if(game.getKeyManager().left)
			xMove = -speed;
		if(game.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (x - game.getGameCamera().getXOffset()),  //centering our player as well
					(int) (y - game.getGameCamera().getYOffset()), width, height, null);
	}

}