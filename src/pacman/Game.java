package pacman;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;



import pacman.display.*;
import pacman.gfx.Assets;

import pacman.input.KeyManager;
import pacman.input.MouseManager;
import pacman.states.GameState;
import pacman.states.MenuState;
import pacman.states.GameOverState;
import pacman.states.State;

public class Game implements Runnable {
    
	
	private Thread thread;
    private boolean running=false;
    private BufferStrategy bs;
    private Graphics g;
    
    //STATES
    
    public State gameState;
    public State menuState;
    public State gameOverState;
    //end states declaration
  
    
    
    //INPUT 
    KeyManager keyManager;
    MouseManager mouseManager;
    MouseMotionListener mouseMotionListener;
    //HANDLER
    private Handler handler;
    
    
    
    private Display display;
    
    
    private int w,h;
    public String title;
    
    
    
    public int getWidth() {
    	return w;
    }
    
    
    public int getHeight() {
    	return h;
    }
    
    public Game(String title,int w, int h){
        this.w = w;
        this.h = h;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
        
        
        
    }
    private void init(){
        display=new Display(title,w,h);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        
        
        handler = new Handler(this);
        
        //states initialization
        menuState=new MenuState(handler);
        gameState=new GameState(handler);
        gameOverState=new GameOverState(handler);
        
        State.setState(menuState);
        
        
        
    }
    private void update (){
    	keyManager.update();
        if(State.getState()!=null) 
        	State.getState().update();
        	
        
    }
    private void render(){
        bs=display.getCanvas().getBufferStrategy();
        if(bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        
        g=bs.getDrawGraphics();//making graphics as the drawing tool to the buffer 
        g.clearRect(0,0,w,h);//clear screen before each buffer write cycle
       
        //gameplay
        g.fillRect(0, 0,w,h);
        if(State.getState()!=null) 
        	State.getState().render(g);

        
        
        
        bs.show();//displaying buffer to the screen
        g.dispose();// disposing drawing tool
    }
   
    public void run(){
        init();
        int fps=60;
        double timePerTick=1000000000/fps; 
        double delta=0;
        long now;
        long lastTime=System.nanoTime();
        long timer=0;
        
        int ticks=0;
        
        while(running){
        	now=System.nanoTime();
        	delta+=(now-lastTime)/timePerTick;
        	timer+=now-lastTime;
        	lastTime=now;
        	if(delta>=1)
        	{
        	update();
            render();
            ticks++;
            delta--;
            }
        	if (timer>=1000000000) {
        		
        		ticks=0;
        		timer=0;
        	}
        	
        }
        stop();
        
    }
    
    
    public KeyManager getKeyManager() {
    	return keyManager;
    	
    }
    
    public MouseManager getMouseManager() {
    	return mouseManager;
    }
    
    public synchronized void start(){
        if (running)
            return;
        running =true;
        thread=new Thread(this);
        thread.start();
        
        
    }
    public synchronized void  stop(){
        if (!running)
            return;
        running=false;
        try
        {
            thread.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        
        
        
    }
    
}
