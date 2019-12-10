package pacman.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject{
	
	private BufferedImage image;
	private ClickListener clicker;

	public UIImageButton(float x, float y, int width, int height ,BufferedImage image , ClickListener clicker) {
		super(x, y, width, height);
		this.image = image;
		this.clicker = clicker;
		
	}

	@Override
	public void update() {
		
		
	}

	@Override
	public void render(Graphics g) {
		
		if (hover)
			g.drawImage(image, (int) x, (int) y , width + 10, height + 10, null);
		
		else
			g.drawImage(image, (int) x, ( int )  y, width, height , null);
		
		
	}

	@Override
	public void onClick() {
		clicker.onClick();
		
		
	}

}
