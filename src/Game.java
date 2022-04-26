import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Game extends JPanel implements IDrawable, IUpdated{
	
	MapManager mapManager;
	BlocksRegister blocksRegister;
	EntityRegister entityRegister;
	TextureContent textureContent;
	
	public Game() {
		textureContent = new TextureContent();
		blocksRegister = new BlocksRegister();
		entityRegister = new EntityRegister();
		mapManager = new MapManager();
		mapManager.addMap("Maps/map1.txt");
		mapManager.addMap("Maps/map2.txt");
		mapManager.addMap("Maps/map3.txt");
		mapManager.setMap(2);
	}

	public void paint(Graphics g) {
		super.paint(g);
		draw(g);
	}

	@Override
	public void draw(Graphics g) {
		mapManager.draw(g);
	}

	@Override
	public void update() {
	    mapManager.update();
	}
	
}
