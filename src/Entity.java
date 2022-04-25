import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

enum Direction
{
    LEFT,
    UP,
    RIGHT,
    DOWN
}

public abstract class Entity implements IDrawable {
    
	public int posX = 0;
    public int posY = 0;
    public int sizeX = 50;
    public int sizeY = 50;
    
    public int spritePosX;
    public int spritePosY;
    public int spriteSizeX;
    public int spriteSizeY;
    
    public int health = 100;
    
    BufferedImage texture = null;
    Color color = new Color(255, 255, 0);

    Map map;
    
    public Entity() {};
    
    public void move(int dir) // 0(<-) 1 (^) 2 (->) 3 (V)
    {  	
		if(dir == 0)
		    if(posX - 1 >= 0)
	    	    	if(map.blocks[posX - 1][posY].intersective == false)
	    	    	    posX--;
		
		if(dir == 1)
		    if(posY - 1 >= 0)
			if(map.blocks[posX][posY - 1].intersective == false)
				posY--;
		
		if(dir == 2)
		    if(posX + 1 < map.width)
			if(map.blocks[posX + 1][posY].intersective == false)
			    posX++;
		
		if(dir == 3)
		    if(posY + 1 < map.height)
			if(map.blocks[posX][posY + 1].intersective == false)
			    posY++;
    }
    
    public void stayOnBlock()
    {
    	map.blocks[posX][posY].stayOnBlock(this);
    }
    
    public void setTexture()
    {
    	
    }
    
    public void death()
    {
    	map.entities.remove(this);
    }
    
    public void update()
    {
    	if(health <= 0)
    		death();
    	stayOnBlock();
    };
    public void handleKeyPressed(KeyEvent e) {};
    @Override
    public void draw(Graphics g)
    {
    	Graphics2D g2D = (Graphics2D)g;
		//g.setColor(color);
		//g.fillRect(posX * sizeX, posY * sizeY, sizeX, sizeY);
    	if(texture != null)
    	{
	    	g2D.drawImage(texture, posX * sizeX, posY * sizeY, posX * sizeX + sizeX, posY * sizeY + sizeY, 
	    			spritePosY, spritePosY, spriteSizeX, spriteSizeY, null);
    	}
    }
    
    public abstract Entity clone();
}
