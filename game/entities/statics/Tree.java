package game.entities.statics;

import game.Assets;
import game.handler.Handler;
import game.items.Item;

import java.awt.Graphics;

public class Tree extends StaticEntity {

    public Tree(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        bounds.x = 10;
        bounds.y=(int)(height /1.5f);
        bounds.width = width -20;
        bounds.height = (int)(height-height/1.5f);
    }


    public void tick(){
        
    }
    @Override
    public void die(){
        handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int)x+16,(int)y+72));
    }
    
    
    public void render(Graphics g){
        g.drawImage(Assets.tree1,(int)(x - handler.getGameCamera().getxOffset()),
                    (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
        //g.drawImage(Assets.tree2,(int)(x - handler.getGameCamera().getxOffset()),
           //         (int)(y - handler.getGameCamera().getyOffset()), width, height, null);            

    }
    
    
    
}
