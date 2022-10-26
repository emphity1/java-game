package game.entities;

import java.awt.Graphics;

import game.handler.Handler;
import java.awt.Rectangle;

/*Entity -> Creatures -> player
 */



public abstract class Entity {


	protected Handler handler;

	protected float x;
	protected float y;
	protected int width;
	protected int height;

	protected Rectangle bounds;

	//checking for collisions
	public boolean checkEntityCollisions(float xOffset, float yOffset){
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}


	//helper
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle((int) (x + bounds.x + xOffset), 
				(int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}

	public Entity(Handler handler,float x, float y,int width,int height){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;

		this.handler = handler;

		bounds = new Rectangle(0,0,width,height);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);



	public float getX() {
		return this.x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return this.y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
}