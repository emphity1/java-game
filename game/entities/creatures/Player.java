package game.entities.creatures;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import game.Assets;
import game.animations.Animation;
import game.entities.Entity;
import game.handler.Handler;
import game.input.KeyManager;
import game.inventory.Inventory;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Rectangle;




public class Player extends Creatures {

	//animations
	private Animation animDown;
	private Animation animUp;
	private Animation animRight;
	private Animation animLeft;
	private Animation animStop;
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;

	private Animation attRight, attLeft, attUp,attDown;

	private Inventory inventory;

	
	
	

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

		attUp = new Animation(500, Assets.att_up);
		attDown = new Animation(500,	Assets.att_down);
		attLeft = new Animation(500, Assets.att_left);
		attRight = new Animation(500, Assets.att_right);

		inventory = new Inventory(handler);

	}



	@Override
	public void tick() {
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		animStop.tick();
		attUp.tick();
		attDown.tick();
		attRight.tick();
		attLeft.tick();
		//movements
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		//attack
		checkAttacks();
		//inventory
		inventory.tick();

	}


	//attack stuff
	private void checkAttacks(){
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer  = System.currentTimeMillis();
		if(attackTimer <attackCooldown){
			return;
		}


		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize  = 24;
		ar.width = arSize;
		ar.height = arSize;

		if(handler.getKeyManager().aUp){
			ar.x = cb.x + cb.width/2 - arSize/2;
			ar.y = cb.y - arSize;
		}else if(handler.getKeyManager().aDown){
			ar.x = cb.x + cb.width/2 - arSize/2;
			ar.y = cb.y + cb.height;
		}else if(handler.getKeyManager().aLeft){
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height/2 - arSize/2;
		}else if(handler.getKeyManager().aRight){
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height/2 - arSize/2;
		}else{
			return;
		}

		attackTimer = 0;

		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this)){
				continue;
			}
			if(e.getCollisionBounds(0, 0).intersects(ar)){
				e.hurt(1);
				return;
			}
		}
	}

	public void die(){
		System.out.println("You died!");
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
		if(handler.getKeyManager().up || handler.getKeyManager().down || handler.getKeyManager().left || handler.getKeyManager().right){
			g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),  //centering our player as well
					(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}else if(handler.getKeyManager().aUp || handler.getKeyManager().aDown || handler.getKeyManager().aLeft || handler.getKeyManager().aRight){
			g.drawImage(getCurrentAttack(), (int) (x - handler.getGameCamera().getxOffset()),  //centering our player as well
					(int) (y - handler.getGameCamera().getyOffset()), 32, 32, null);
		}else{
			g.drawImage(animStop.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),  //centering our player as well
					(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}
		
		
		
		
		//g.setColor(Color.red);
		//g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()), 
		//(int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}

	public void postRender(Graphics g){
		inventory.render(g);
	}

	
	private BufferedImage getCurrentAttack(){
		if(handler.getKeyManager().aUp){
			return attUp.getCurrentFrame();
		}else if(handler.getKeyManager().aDown){
			return attDown.getCurrentFrame();
		}else if(handler.getKeyManager().aLeft){
			return attLeft.getCurrentFrame();
		}else{
			return attRight.getCurrentFrame();
		}
		
	}


	
	private BufferedImage getCurrentAnimationFrame(){
		
		if(xMove>0){
			return animLeft.getCurrentFrame();

		}else if(xMove<0){
			return animRight.getCurrentFrame();
		}else if(yMove<0){
			return animUp.getCurrentFrame();

		}else if(yMove>0){
			return animDown.getCurrentFrame();

		}else{
			return animStop.getCurrentFrame();

		}
	}


	//GETTERS AND SETTERS

	public Inventory getInventory() {
		return this.inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	};
	
}