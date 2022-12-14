package game.worlds;


import java.awt.Graphics;

import game.entities.EntityManager;
import game.entities.creatures.Player;
import game.entities.statics.Fence;
import game.entities.statics.Tree;
import game.handler.Handler;
import game.items.ItemManager;
import game.tile.Tile;
import game.utils.Utils;



public class World {

	private Handler handler;


	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;

	//Entities
	private EntityManager entityManager;

	//Item
	private ItemManager itemManager;

	

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public World(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		itemManager = new ItemManager(handler);
		//draw fence
		entityManager.addEntity((new Fence(handler, 50, 50)));
		entityManager.addEntity((new Fence(handler, 50, 50+32)));
		entityManager.addEntity((new Fence(handler, 50, 50+32*2)));
		//draw trees
		entityManager.addEntity(new Tree(handler, 100, 100, 50, 100) );
		entityManager.addEntity(new Tree(handler, 250, 250, 50, 100) );
		entityManager.addEntity(new Tree(handler, 400, 250, 50, 100) );


		
		loadWorld(path);

		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick(){
		entityManager.tick();
		itemManager.tick();
	}
	
	/* --PERFORMACE:
	 * Rendering func rendering our tiles just when we are moving around and not all TILES.
	 * In case map is big.
	 */
	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//Items
		itemManager.render(g);
		//Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.grassTile;
		return t;
	}



	/*
	 * Thanks to Utils and function loadFileAsString i'm taking my world file i created
	 * splitting my numbers, first 4 i indicated in my file will me my world setup
	 * others will be my tile placement.
	 */
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}

	///GETTERS AND SETTERS

	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}

	public ItemManager getItemManager() {
		return this.itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public Handler getHandler() {
		return this.handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
}







