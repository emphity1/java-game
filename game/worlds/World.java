package game.worlds;


import java.awt.Graphics;

import game.Game;
import game.tile.Tile;
import game.utils.Utils;



public class World {

	private Game game;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	public World(Game game, String path){
		this.game = game;
		loadWorld(path);
		
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				getTile(x, y).render(g, (int)(x * Tile.TILEWIDTH - game.getGameCamera().getXOffset()),
									(int) (y * Tile.TILEHEIGHT - game.getGameCamera().getYOffset()));
			}
		}

	}
	
	public Tile getTile(int x, int y){
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
	
}







