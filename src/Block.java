

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Block implements IDrawable {

	int posX;
	int posY;
	int size;
    BufferedImage texture = null;
    
    public int spritePosX;
    public int spritePosY;
    public int spriteSizeX;
    public int spriteSizeY;
	
    Map map;
    
	Color color;
	
	boolean intersective = false;
	
	public Block() {};	
	public void stayOnBlock(Entity entity) {};
	public abstract Block clone();
	public abstract void update();
	
	@Override
	public void draw(Graphics g) {
		
    	Graphics2D g2D = (Graphics2D)g;
    	if(texture != null)
    	{
	    	g2D.drawImage(texture, posX, posY, posX + size, posY + size, 
	    			spritePosX, spritePosY, spriteSizeX, spriteSizeY, null);
    	}
	}
	

}
