package pacman.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import pacman.Handler;
import pacman.entities.EntityManager;
import pacman.tiles.screenoutput.Maze;



public class GameState extends State{
	
	private Font font = new Font("Helvetica",Font.BOLD,12);
	private static int score;
	private int lives;
	private Maze maze;
	private int width,height;
	
	private EntityManager entityManager;
	

	
	public GameState(Handler handler) {
		super(handler);
	
		maze=new Maze(handler,"res/screen/Maze.txt");
		handler.setMaze(maze);

		
		
	
		
			
		}
	

	
	
private void drawLives(Graphics g) {

        
        String s;

        g.setFont(font);
        g.setColor(Color.BLACK);
        //lives = entityManager.getPlayer().getLives();
        s = "LIVES: " + lives;
        g.drawString(s, 10, 15);

        
    }
    private void drawScore(Graphics g) {

        
        String s;

        g.setFont(font);
        g.setColor(Color.BLACK);
        s = "SCORE: " + score;
        g.drawString(s,700,15);

        
    }
    
	public static int getScore() {
		return score;
	}
	

	@Override
	public void update() {
		maze.update();


		
	}

	@Override
	public void render(Graphics g) {
		
		maze.render(g);
		drawLives(g);
		drawScore(g);

		

		
		
		}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
	
	

}
