package game.items;

import java.util.ArrayList;
import java.util.Iterator;
import game.handler.Handler;
import java.awt.Graphics;


public class ItemManager {
    
    private Handler handler;

    

    private ArrayList<Item> items;
    
    public ItemManager(Handler handler){
        this.handler = handler;
        items = new ArrayList<Item>();
    }
    

    public void tick(){
        Iterator<Item> it = items.iterator();
        while(it.hasNext()){
            Item i = it.next();
            i.tick();
            if(i.getCount() == Item.PICKED_UP){
                it.remove();        //FOR NOW JUST REMOVE, BUT IT NEEDS TO GO TO INVENTORY
            }
        }
    }
    

    public void render(Graphics g){
        for(Item i : items){
            i.render(g);
        }
    }

    public void addItem(Item i){
        i.setHandler(handler);
        items.add(i);
    }



    //GETTERS AND SETTERS


    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

}
