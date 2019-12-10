package pacman.tiles.screenoutput;

// code for multiple levels needs to be created       speed for ghost should be increased and ,maze shoukd be reinitialised

import java.awt.Graphics;


import pacman.Handler;
import pacman.entities.Dots;
import pacman.entities.EntityManager;
import pacman.entities.Ghost1;
import pacman.entities.Ghost2;
import pacman.entities.Ghost3;
import pacman.entities.Ghost4;
import pacman.entities.Player;
import pacman.tiles.Tile;
import pacman.tiles.screenoutput.utils.Utils;

public class Maze {
	
	private Handler handler ;
	private   int width,height;//40x15
	private int spawnX,spawnY;
	private int [][]tiles;
	
	
	
	
	//Entities
	private EntityManager entityManager;
	
	
	public Maze(Handler handler,String path) {
		this.handler = handler ;
		entityManager = new EntityManager(handler, new Player( handler , 430 , 150));
		
		
		entityManager.addEntity(new Ghost1(handler, 40, 40));
		entityManager.addEntity(new Ghost2(handler, 780, 40));
		entityManager.addEntity(new Ghost3(handler,  40, 280));
		entityManager.addEntity(new Ghost4(handler, 780, 280));
		loadMaze(path);
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		for( int i = 1; i <= 39; i++)
			for (int j = 1; j < 15 ; j++ )
			{
				if(!getTile(i,j).isSolid())
					entityManager.addEntity(new Dots(handler , i * Tile.width  + 10,j * Tile.height + 10));
			}
		
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
	private void loadMaze(String path) {
		width=41;
		height=16;
		tiles=new int[width][height];
		
		String file = Utils.loadFileAsString(path);
		String []tokens =file.split("\\s+");
		width=Utils.parseInt(tokens[0]);
		height=Utils.parseInt(tokens[1]);
		spawnX=Utils.parseInt(tokens[2]);
		spawnY=Utils.parseInt(tokens[3]);
		
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				tiles[x][y] = Utils.parseInt(tokens[x+y*width+4]);
			
				
				
			}
		}
	}
	
	
	public void update() {
		entityManager.update();
		
	}
	
	
	public void render(Graphics g) {
		
		for(int y=0;y<height;y++) {
			for (int x=0;x<width;x++) {
				getTile(x,y).render(g, x*Tile.width, y*Tile.height);
				
			}
		}	
	entityManager.render(g);
		
	}
	


	
	public Tile getTile(int x,int y) {
		if(x<0||y<0||x>820||y>320)
			return Tile.tile1;
		Tile t=Tile.tiles[tiles[x][y]];
		
		if (t == null )
			return Tile.tile1;
		return t;
		
		
	}
	
	
		
		
	}
	
	
	
	
	

