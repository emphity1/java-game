package game.entities.statics;

import java.awt.Graphics;

import game.entities.Entity;
import game.handler.Handler;

//stuff like rocks,trees...

public class StaticEntity  extends Entity{
    public StaticEntity(Handler handler,float x, float y,int width,int height){
        super(handler, x, y, width, height);
    }

    @Override
    public void tick() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void render(Graphics g) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void die() {
        // TODO Auto-generated method stub
        
    }
    

}
