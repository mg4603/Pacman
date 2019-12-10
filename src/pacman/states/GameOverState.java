package pacman.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import pacman.Handler;

public class GameOverState extends State {
	public GameOverState(Handler handler) {
		super(handler);
	}

	@Override
	public void update() {

		
	}

	@Override
	public void render(Graphics g) {
		
		g.setFont(new Font("Helvetica", Font.BOLD, 60));
		
		
		g.setColor(Color.WHITE);
		
		g.drawString("PACMAN",275,75);
		g.drawString("GAMEOVER" , 350, 145);
		
		
	}

}
