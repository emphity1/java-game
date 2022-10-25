package game.entities;

import java.awt.Graphics;

import game.Game;

/*Entity -> Creatures -> player
 */



public abstract class Entity {


	protected Game game;

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




	


	
	public Entity(Game game,float x, float y,int width,int height){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;

		this.game = game;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}