package pacman.tiles;
import java.awt.Graphics;
import java.awt.image.BufferedImage;



public class Tile {
	
	
	public static Tile tiles[]=new Tile[256];
	public static Tile tile1=new Tile1(0);
	public static Tile tile2=new Tile2(1);

	
	
	protected BufferedImage texture;
	protected final int id;
	public static final int width = 20,height = 20;
	
	
	public Tile(BufferedImage texture,int id) {
		this.texture=texture;
		this.id=id;
		tiles[id]=this;
			
	}
	
	
	public void update() {
		
	}
	
	
	public void render(Graphics g,int x,int y) {
		g.drawImage(texture,x,y,width,height,null);
		
	}
	
	
	public boolean isSolid() {
		return false;
	}
	public int getId() {
		return id;
	}

}
