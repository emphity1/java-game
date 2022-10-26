package game;

import game.GameCamera.GameCamera;
import game.handler.Handler;
import game.input.KeyManager;
import game.states.GameState;
//import game.states.MenuState;
import game.states.State;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;



public class Game implements Runnable {

	private Display display;
	private int width, height;
	public String title;
	
	

	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	

	//States
	private State gameState;
	//private State menuState;
	//input
	private KeyManager keyManager;

	//camera istance
	private GameCamera gameCamera;

	//Hanlder
	Handler handler;
	


	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler,0, 0);
		

		Assets.init();
		gameState = new GameState(handler);
		//menuState = new MenuState(handler);
		
		State.setState(gameState);

        
    }

	

	
	private void tick(){
		keyManager.tick();
		
		if(State.getState() != null){
			State.getState().tick();
		}
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
		//Draw stuff
		if(State.getState() != null){
			State.getState().render(g);
		}

		//End 
		bs.show();
		g.dispose();
	}
	

    //threads stuff...
	public void run(){
		//let's make the game run smooth at 60fps
		init();
		int fps = 60;
		double timePerTick = 1000000000 /fps; //nano sec. Max time we allow to render tick method
		double delta = 0;
		long now;
		long lastTime = System.nanoTime(); //current time of PC in nano sec.
		long timer = 0;
		int ticks = 0;

		
		while(running){
			now = System.nanoTime();
			delta += (now-lastTime)/timePerTick; //how much time we have untill we have to call tick() and render()
			timer += now-lastTime;
			lastTime = now;

			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000){
				System.out.println("Ticks/Frames:" + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}

	public GameCamera getGameCamera(){
		return gameCamera;
	}

	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}

	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}














