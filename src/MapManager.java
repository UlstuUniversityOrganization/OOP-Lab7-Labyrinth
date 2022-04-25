import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MapManager implements IDrawable, IUpdated{
	public ArrayList<Map> maps;
	public int activeMapID = 2;
	public Map activatedMap;
	
	public MapManager()
	{
		maps = new ArrayList<Map>();
	}
	
	public void addMap(String path) 
	{
		Map map = new Map(path, this);
		maps.add(map);
	}
	
	public void setMap(int mapID)
	{
		activeMapID = mapID;
	}
	
	public void handleKeyPressed(KeyEvent e)
	{
	    maps.get(activeMapID).handleKeyPressed(e);
	}
	
	public void restartMap(int mapID)
	{
		maps.get(mapID).restart();
	}

	@Override
	public void draw(Graphics g) {
	    maps.get(activeMapID).draw(g);
	}

	@Override
	public void update() {	    
	    maps.get(activeMapID).update();  
	}
}
