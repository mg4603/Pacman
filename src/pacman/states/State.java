package pacman.states;

import java.awt.Graphics;


import pacman.Handler;

public abstract class State {
	
	//Game State manager
	protected Handler handler;
	
	
	public State (Handler handler) {
		this.handler = handler;
		
	}
	private static State currentState=null;
	
	public static void setState(State state) {
		currentState = state;
		
	}
	
	public static State getState() 
	{
		return currentState;
		
	}
	
	
	
	//abstract methods
	public abstract void update();
	
	public abstract void render(Graphics g);
	
}
