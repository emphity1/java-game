package game.entities.creatures;

import game.entities.Entity;

public abstract class Creatures extends Entity {
	
	protected int health;

	public Creatures(float x, float y) {
		super(x, y);
		health = 10;
	}
	
}