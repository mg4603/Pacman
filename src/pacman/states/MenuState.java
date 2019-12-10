package pacman.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


import pacman.Handler;
import pacman.gfx.Assets;
import pacman.ui.ClickListener;
import pacman.ui.UIImageButton;
import pacman.ui.UIManager;



public class MenuState extends State{
	

	
	private UIManager uiManager;
	
	public MenuState(Handler handler){
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.addObjects(new UIImageButton(300.0f , 100.0f, 128 , 64, Assets.start, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
					State.setState(handler.getGame().gameState);
				
			}  }));
		
		
			
		
		}
	@Override
	public void update() {
		uiManager.update();
		
	}

	@Override
	public void render(Graphics g) {
		g.setFont(new Font("Helvetica", Font.BOLD, 45));
		g.setColor(Color.CYAN);
		
		g.drawString("PACMAN",275,75);
	
		uiManager.render(g);
		
	}

}
