package game;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Color;



public class Game implements Runnable {

	private Display display;
	public int width, height;
	public String title;
	
	

	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	

	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init(){
		display = new Display(title, width, height);
		Assets.init();
        
    }

	int x = 0;

	
	private void tick(){
		x += 1;
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
		g.drawImage(Assets.grass, x, 10, null);
		g.drawImage(Assets.player,50,50,null);
		g.drawImage(Assets.fence, 30, 30, null);

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














