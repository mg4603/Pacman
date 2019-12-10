package pacman.entities;

import java.awt.Graphics;

import pacman.Handler;
import pacman.gfx.Assets;

public class Dots extends StaticEntity{

	
	
	
	public Dots(Handler handler, float x, float y) {
		super(handler, x, y, 3, 3);
		
	}

	@Override
	public void update() {

		
	}
	
	

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.dots, ( int ) x, ( int ) y, width, height, null);
		
	}
	

}
