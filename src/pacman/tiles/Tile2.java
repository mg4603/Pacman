package pacman.tiles;

import pacman.gfx.Assets;

public class Tile2 extends Tile{

	public Tile2(int id) {
		super(Assets.tile2,id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
		
	}
	
}
