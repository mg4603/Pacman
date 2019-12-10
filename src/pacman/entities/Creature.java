package pacman.entities;

import pacman.Handler;
import pacman.tiles.Tile;

public abstract class Creature extends Entity{

	public static final int  DEFAULT_LIVES=3;
	public static final float DEFAULT_SPEED = 1.5f;
	public static final int DEFAULT_WIDTH=13;	public static final int DEFAULT_HEIGHT=13;
	protected int lives;
	public float speed;
	public static float xMove,yMove,tx,ty;
	
	
	//Constructor
	
	public Creature(Handler handler,float x, float y,int width,int height) {
		super(handler,x, y,width,height);
		lives=DEFAULT_LIVES;
		speed=DEFAULT_SPEED;
		
		
	}
	
	
	
	
	
	public void move() {
		
		moveX();
		
		moveY();
		
	}
	
	public void moveX() {
		if (xMove > 0)
		{ //Moving Right
			int tx = (int) (x + xMove + bounds.x + bounds.width)/Tile.width;
			if( !collisionWithTile(tx , (int) (y + bounds.y) / Tile.height ) && 
					!collisionWithTile( tx , (int) ( y + bounds.y + bounds.height )/Tile.height))
				x += xMove;
			else
				x = tx * Tile.width - bounds.x - bounds.width - 1;
			
			
			
			
		}
		else if(xMove < 0)
		{
			//Move left
			int tx = (int) (x + xMove + bounds.x )/Tile.width;
			if( !collisionWithTile(tx , (int) (y + bounds.y) / Tile.height ) && 
					!collisionWithTile( tx , (int) ( y + bounds.y + bounds.height )/Tile.height))
				x += xMove;
			else 
				x = tx * Tile.width + Tile.width -bounds.x; 
			
		}
		
		
	}
	
	
	public void moveY() {
		if (yMove > 0)
		{ //Moving down
			int ty = (int) (y + yMove + bounds.y + bounds.height)/Tile.height;
			if( !collisionWithTile( (int) ( x + bounds.x) / Tile.width , ty) && 
					!collisionWithTile(  (int) ( x + bounds.x + bounds.width )/Tile.width , ty))
				y += yMove;
			else
				y = ty * Tile.height - bounds.y - bounds.height - 1;
			
			
			
			
		}
		else if(yMove < 0)
		{
			//Move up
			int ty = (int) (y + yMove + bounds.y )/Tile.height;
			if( !collisionWithTile( (int) (x + bounds.x) / Tile.width, ty) && 
					!collisionWithTile(  (int) ( x + bounds.x + bounds.width)/Tile.width,ty))
				y += yMove;
			else
				y = ty * Tile.height +Tile.height - bounds.y;
		}
	}
	
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getMaze().getTile(x,y).isSolid();
	}
	
	
	//GETTERS , SETTERS
	
	
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	public Creature() {
		lives=DEFAULT_LIVES;
		
	}
	

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	 

}
