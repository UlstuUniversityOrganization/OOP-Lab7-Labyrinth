import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity
{	
    public Player()
    {
		super();
		color = new Color(100, 100, 255);

		texture = TextureContent.playerTexture;
		spritePosX = 0;
		spritePosY = 0;
		spriteSizeX = 600;
		spriteSizeY = 1062;
		
		health = 100;
    }
      
    public void handleKeyPressed(KeyEvent e)
    {
	super.handleKeyPressed(e);
	
	if(e.getKeyChar() == 'a')
	    move(0);
	if(e.getKeyChar() == 'w')
	    move(1);
	if(e.getKeyChar() == 'd')
	    move(2);
	if(e.getKeyChar() == 's')
	    move(3);
    }
    
    @Override
    public void death()
    {
    	super.death();
    }
    
    @Override
    public void update() {
    	super.update();
    	if(health <= 0)
    	{
    		map.restart();
    	}
    }
    
    @Override
    public void draw(Graphics g)
    {
    	super.draw(g);
	
	/*=
	Graphics2D g2D = (Graphics2D)g;

	if(playerImage != null)
	{
		g2D.drawImage(playerImage, posX * sizeX, posY * sizeY, posX * sizeX + sizeX, posY * sizeY + sizeY, 0, 0, 600, 1062, null);	
	}
	*/
    }

    @Override
    public Entity clone() {
	return new Player();
    }


}
