package game.inventory;


import game.Assets;
import game.UI.Text;
import game.handler.Handler;
import game.items.Item;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;




public class Inventory {

    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;
   

    public Inventory(Handler handler){
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();

        addItem(Item.woodItem.createNew(5));

    }

    public void tick(){
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
			active = !active;
		if(!active)
			return;

        //System.out.println("Invetory WORKING");

        System.out.println("INVENTORY: ");
        for(Item i:inventoryItems){
            System.out.println(i.getName() + "  " + i.getCount());
        }
	}
    
    public void render(Graphics g){
        if(!active){
            return;
        }
        g.drawImage(Assets.inventoryScreen, 512, 318,232,272, null);

        Text.drawString(g, "Rock", 300, 200, true, Color.WHITE, Assets.font);
    }

    //Invetory methods

    public void addItem(Item item){

        for(Item i : inventoryItems){
            if(i.getId() == item.getId()){
                i.setCount(i.getCount() + item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
    }
    


        //GETTERS AND SETTERS

    public Handler getHandler() {
        return this.handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
		this.active = active;
	} 
}
