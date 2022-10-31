package game.items;



import java.awt.image.BufferedImage;
import game.Assets;
import game.handler.Handler;
import java.awt.Graphics;
import java.awt.Rectangle;




public class Item {

    //class stuff
    public static final int ITEMWIDTH = 16, ITEMHEIGHT = 16;
    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected int x;
    protected int y;
    protected int count;
    protected final int id;
    protected Rectangle bounds;
    protected boolean pickedUp = false;

    
    

    



    //handler
    public static Item[] items = new Item[256];
    public static Item woodItem = new Item(Assets.wood,"Wood",0);

    
    
    public Item(BufferedImage texture, String name, int id){

        this.texture = texture;
        this.name = name;
        this.id = id;
        count = 1;
        items[id] = this;
        bounds = new Rectangle(x,y,ITEMWIDTH,ITEMHEIGHT);


    }

    public void tick(){
        if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)){
            pickedUp = true;
            handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
        }


    }

    //Item draw in world
    public void render(Graphics g){

        if(handler==null){
            return;
        }
        render(g,(int) (x-handler.getGameCamera().getxOffset()),
                 (int) (y-handler.getGameCamera().getyOffset()));
    }



    //Items draw in invetory
    public void render(Graphics g,int x,int y){

        g.drawImage(texture, x, y,ITEMWIDTH,ITEMHEIGHT, null);       
    }

    //debugging
    public Item createNew(int count){
        Item i = new Item(texture,name,id);
        i.setPickedUp(true);
        i.setCount(count);
        return i;
    }

    public Item createNew(int x, int y){
        Item i = new Item(texture,name,id);
        i.setPosition(x, y);
        return i;
    }



    public void setPosition(int x,int y){
        this.x =x;
        this.y = y;
        bounds.x = x;
        bounds.y = y;
    }






    //GETTERS AND SETTERS

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public  int getId() {
		return id;
	}

    public boolean isPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	} 


}
