package game.entities.creatures;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import game.Assets;
import game.animations.Animation;
import game.handler.Handler;;


public class Player extends Creatures {

	//animations
	private Animation animDown;
	private Animation animUp;
	private Animation animRight;
	private Animation animLeft;
	private Animation animStop;
	
	
	public Player(Handler handler, float x, float y) {
		super(handler,x, y, Creatures.DEFAULT_CREATURE_WIDTH, Creatures.DEFAULT_CREATURE_HEIGHT);

		//collisione box for player
		bounds.x = 8;
		bounds.y = 16;
		bounds.width = 16;
		bounds.height = 16;

		animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
		animStop = new Animation(500, Assets.player_stop);

	}

	@Override
	public void tick() {
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		animStop.tick();
		//movements
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
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),  //centering our player as well
					(int) (y - handler.getGameCamera().getyOffset()), width, height, null);

		//g.setColor(Color.red);
		//g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()), 
		//(int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}


	private BufferedImage getCurrentAnimationFrame(){
		if(xMove<0){
			return animRight.getCurrentFrame();
		}else if(xMove>0){
			return animLeft.getCurrentFrame();
		}else if(yMove<0){
			return animUp.getCurrentFrame();
		}else if(yMove>0){
			return animDown.getCurrentFrame();
		}else{
			return animStop.getCurrentFrame();
		}
	}
}