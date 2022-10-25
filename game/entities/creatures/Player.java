package game.entities.creatures;

import java.awt.Graphics;
import java.awt.Color;
import game.Assets;
import game.Game;
import game.handler.Handler;;

public class Player extends Creatures {

	
	
	public Player(Handler handler, float x, float y) {
		super(handler,x, y, Creatures.DEFAULT_CREATURE_WIDTH, Creatures.DEFAULT_CREATURE_HEIGHT);

		//collisione box for my player
		bounds.x = 8;
		bounds.y = 16;
		bounds.width = 16;
		bounds.height = 16;
	}

	@Override
	public void tick() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getXOffset()),  //centering our player as well
					(int) (y - handler.getGameCamera().getYOffset()), width, height, null);

		g.setColor(Color.red);
		g.fillRect((int)(x + bounds.x - handler.getGameCamera().getXOffset()), 
		(int)(y + bounds.y - handler.getGameCamera().getYOffset()), bounds.width, bounds.height);
	}

}