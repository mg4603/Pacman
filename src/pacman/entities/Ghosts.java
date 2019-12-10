
package pacman.entities;

import java.awt.Graphics;

import pacman.Handler;
import pacman.gfx.Assets;
import pacman.tiles.Tile;

public abstract  class Ghosts extends Creature{
	
	


	
	public Ghosts(Handler handler,float x, float y) {
		
		super(handler, x, y,Creature.DEFAULT_WIDTH,Creature.DEFAULT_HEIGHT);
		bounds.x=0;
		bounds.y=0;
		bounds.width=13;
		bounds.height=13;
		
	}


	
	public abstract   void update();
		
		
		
	


	
	public abstract  void render(Graphics g);
	
// code needs to be ammended and called in each ghost class render
	
	
	
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
	
	
}