package pacman.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import pacman.entities.Creature;

public class KeyManager implements KeyListener{
	
	
	private boolean []keys;
	public boolean up, down, left, right;
	
	public KeyManager()
	{
		keys=new boolean[256];
	}
	
	public void update() {
		
		if(keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_RIGHT])
		{
			Creature.tx = 0;
			Creature.ty = 0;
			
		}
		
		up=keys[KeyEvent.VK_UP];
		down=keys[KeyEvent.VK_DOWN];
		left=keys[KeyEvent.VK_LEFT];
		right=keys[KeyEvent.VK_RIGHT];
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]=true;
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()]=false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
		
	}

}
