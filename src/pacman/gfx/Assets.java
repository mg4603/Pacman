package pacman.gfx;

import java.awt.image.BufferedImage;

public class Assets {
private static final int width=35,height=46,x=159,s=57,y=4;

public static BufferedImage ghost1,ghost2,ghost3,ghost4,prize1,prize2,prize3,prize4,tile1,tile2,tile3,tile4, dots ,start, highScore;
public  static BufferedImage [] player_up, player_down, player_left, player_right,p;

public static void init() {
	
	SpriteSheet sheet=new SpriteSheet(ImageLoader.loadImage("/texture/spritesheet.png"));
	SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/texture/pacmansheet.png"));
	
	start = ImageLoader.loadImage("/texture/StartTile.png");
	
	highScore = ImageLoader.loadImage("/texture/HighScoreTile.png");
	
	player_up = new BufferedImage[2];
	player_down = new BufferedImage[2];
	player_left = new BufferedImage[2];
	player_right = new BufferedImage[2];
	p = new BufferedImage[2];
	p[0] = sheet1.crop(0,0,60,60);
	player_up[0] = sheet1.crop(60,0,60,60);
	player_up[1] = sheet1.crop(120,0,65,60);
	player_down[0]= sheet1.crop(120,60,65,60);
	player_down[1] = sheet1.crop(60,60,60,60);
	player_left[0] = sheet1.crop(315,60,67,60);
	player_left[1]  = sheet1.crop(253,52,67,65);
	player_right[0] = sheet1.crop(243,0,65,60);
	player_right[1] = sheet1.crop(305,0,60,60);
	tile1=ImageLoader.loadImage("/texture/tile1.png");
	tile2=ImageLoader.loadImage("/texture/tile2.png");
	tile3=ImageLoader.loadImage("/texture/tile2.png");
	tile4=ImageLoader.loadImage("/texture/tile2.png");
	ghost1=sheet.crop(x, 50, width, height);	
	ghost2=sheet.crop(x, 50+height, width, height);
	ghost3=sheet.crop(x, 50+height*2, width, height);
	ghost4=sheet.crop(x, 50+height*3, width, height);
	prize1=sheet.crop(s+3, y, width, height);
	prize2=sheet.crop(s+width,y , width, height);
	prize3=sheet.crop(s+width*2,y , width, height);
	prize4=sheet.crop(s+width*3-5,y , width, height);
	dots=ImageLoader.loadImage("/texture/Dots.png");
	
}
}
