package pacman;


import pacman.input.KeyManager;
import pacman.input.MouseManager;
import pacman.tiles.screenoutput.Maze;
import pacman.states.*;
public class Handler {
	

	private Game game;
	private Maze maze;
	
	
	
	


	public static State getState() {
		return State.getState();
	}

	public Handler(Game game ) {
		this.game = game ;
		
		
	}

	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
		
	}

	public Game getGame() {
		return game;
	}


	public void setGame(Game game) {
		this.game = game;
	}


	public Maze getMaze() {
		return maze;
	}


	public void setMaze(Maze maze) {
		this.maze = maze;
	}
	
	
	
}
