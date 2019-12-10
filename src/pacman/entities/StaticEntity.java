package pacman.entities;

import pacman.Handler;
import pacman.entities.Entity;

public abstract class  StaticEntity extends Entity{

	public StaticEntity(Handler handler, float x, float y,int width, int height) {
		super( handler , x , y ,width, height  );
		
	}
}
