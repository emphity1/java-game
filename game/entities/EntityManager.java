package game.entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import game.entities.creatures.Player;
import game.handler.Handler;
import java.awt.Graphics;



public class EntityManager {

    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;
    
    //compare our entities which is higher and which is lower, to render my player properly
    private Comparator<Entity> renderSorter = new Comparator<Entity>(){
        public int compare(Entity a, Entity b){
            if(a.getY()+a.getHeight() < b.getY()+b.getHeight()){
                return -1;
            }else{
                return 1;
            }
            
        }
    };

  
    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);
        
    }
    public void tick(){
        Iterator<Entity> it = entities.iterator();
        while(it.hasNext()){
            Entity e = it.next();
            e.tick();
            if(!e.isActive()){
                it.remove();
            }
        }
        //player.tick();
        //from function compare
        entities.sort(renderSorter);
    }

    public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}
        player.postRender(g);
       // player.render(g);
	}

    public void addEntity(Entity e){
        entities.add(e);
    }

    public Handler getHandler() {
        return this.handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return this.entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

}
