package pacman.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


import pacman.Handler;
import pacman.gfx.Animation;
import pacman.gfx.Assets;

public class Player extends Creature{
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight, animStill;

	
	
	protected int  score,lives;
	private final static int LIVES = 3;
	private Font font = new Font("Helvetica",Font.BOLD,12);
	
	public Player(Handler handler,float x, float y) {
		
		super(handler, x, y,Creature.DEFAULT_WIDTH,Creature.DEFAULT_HEIGHT);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 13;
		bounds.height = 13;
		this.lives = LIVES;
		
		
		//Animation 
		animDown =   new Animation (Assets.player_down, 50);
		animLeft =   new Animation (Assets.player_left, 50);
		animRight =   new Animation (Assets.player_right, 50);
		animUp =   new Animation (Assets.player_up, 50);
		animStill =   new Animation (Assets.p, 0);
		score = 0;
	}


	@Override
	public void update() {
		//Animation
		animDown.update();
		animUp.update();
		animLeft.update();
		animRight.update();
		
		
		//Movement
		getInput();
		
		calculateScore();
		
		
		
	}
	
			
	public void getInput() {
		xMove=0;
		yMove=0;
		
		
		if(handler.getKeyManager().up) 
		{		yMove=-speed;
				ty = yMove;
		}
		
		else if(handler.getKeyManager().down) 
		{	yMove=speed;
			ty = yMove;
			
		
		}
		
		else if(handler.getKeyManager().left) 
			{		xMove=-speed;
					tx = xMove;
			}
		
		else if(handler.getKeyManager().right) 
		{	xMove=speed;
			tx = xMove;
		
		}
		else
		{
			xMove = tx;
			yMove = ty;
		}
				
		
	}
	
	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}
	
	
	
	
	
	public void calculateScore() {
		if(checkEntityCollision(0f,0f ))
			score++;
		
		
		
	}
	
	
	
	

	@Override
	public void render(Graphics g) {
		
		
		
		g.drawImage(getCurrentAnimationFrame(), (int)x,(int) y,width,height,null);
		move();
		drawLives(g);
		drawScore(g);

		
		
		
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
    
	public  int getScore() {
		return score;
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0) 
			return animLeft.getCurrentFrame();
		else if ( xMove >0)
			return animRight.getCurrentFrame();
		else if (yMove >0 )
			return animDown.getCurrentFrame();
		else if (yMove <0 )
			return animUp.getCurrentFrame();
		else
			return animStill.getCurrentFrame();
			
		
	}

}
;