package game.entities;

import java.awt.Graphics;

import game.Game;
import game.handler.Handler;

/*Entity -> Creatures -> player
 */



public abstract class Entity {


	protected Handler handler;

	protected float x;
	protected float y;
	protected int width;
	protected int height;

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




	


	
	public Entity(Handler handler,float x, float y,int width,int height){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;

		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}