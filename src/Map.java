import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

public class Map implements IDrawable{
	public int width;
	public int height;
	public int posX = 0;
	public int posY = 0;
	public int blockSize = 30;
	public Block blocks[][];
	public ArrayList<Entity> entities;
	public MapManager mapManager;
	public String mapPath;
	public boolean isRestarting = false;
	
	public Map(int width, int height, MapManager mapManager) {
	    blocks = new Block[width][height];
	    entities = new ArrayList<Entity>();
	    this.mapManager = mapManager;
	}
	
	public Map(String path, MapManager mapManager) 
	{
	    this.mapManager = mapManager;
	    loadMap(path);
	}
	
	public void loadMap(String path) {
		mapPath = path;
		try {
			Scanner sc = new Scanner(new File(path));
			width = sc.nextInt();
			height = sc.nextInt();		
			blocks = new Block[width][height];
		    entities = new ArrayList<Entity>();
			
			for(int y = 0; y < height; y++)
				for(int x = 0; x < width; x++) {
				    blocks[x][y] = BlocksRegister.getBlock(sc.nextInt());
				    blocks[x][y].size = blockSize;
				    blocks[x][y].posX = x * blocks[x][y].size;
				    blocks[x][y].posY = y * blocks[x][y].size;
				    blocks[x][y].map = this;
				}
			entities.clear();
			for(int y = 0; y < height; y++)
				for(int x = 0; x < width; x++)
				{	    
				    int entityRegisteredId = sc.nextInt();
				    if(entityRegisteredId >= 0)
				    {
					    Entity loadedEntity = EntityRegister.getEntity(entityRegisteredId);
					    loadedEntity.posX = x;
					    loadedEntity.posY = y;
					    loadedEntity.sizeX = blockSize;
					    loadedEntity.sizeY = blockSize;
					    loadedEntity.map = this;
					    entities.add(loadedEntity);
				    }
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void restart()
	{
		isRestarting = true;
		loadMap(mapPath);
	}
	
	public void handleKeyPressed(KeyEvent e)
	{
	    for(int i = 0; i < entities.size(); i++)
		entities.get(i).handleKeyPressed(e);
	}	
	
	public void update()
	{
		for(int y = 0; y < height; y++)
			for(int x = 0; x < width; x++)
			{
				if(isRestarting)
					break;
				blocks[x][y].update();
			}
		
		for(int i = 0; i < entities.size(); i++)
		{
			if(isRestarting)
				break;
			entities.get(i).update();
		}

		if(isRestarting)
			isRestarting = !isRestarting;
	}

	@Override
	public void draw(Graphics g) {
		for(int y = 0; y < height; y++)
			for(int x = 0; x < width; x++)
			    blocks[x][y].draw(g);
		
		for(int i = 0; i < entities.size(); i++)
		    entities.get(i).draw(g);	
				 
	}
}
