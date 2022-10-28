package game.entities.statics;

import game.Assets;
import game.handler.Handler;
import java.awt.Graphics;


public class Fence extends StaticEntity {

    public Fence(Handler handler, float x, float y) {
        super(handler, x, y, Assets.fenceWidth*2, Assets.fenceHeight*2);
        //TODO Auto-generated constructor stub
    }

    public void render(Graphics g){
        g.drawImage(Assets.fence,(int)(x - handler.getGameCamera().getxOffset()),
                    (int)(y - handler.getGameCamera().getyOffset()), width, height, null);

    }

    @Override
    public void die(){
        
    }
    
    
}
