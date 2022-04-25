import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class BlockStone extends Block{

	public BlockStone() {
		super();
		color = new Color(100, 100, 100);
		texture = TextureContent.stoneTexture;
		spriteSizeX = texture.getWidth();
		spriteSizeY = texture.getHeight();
		
		intersective = true;
	}
	
	@Override
	public Block clone() {
		return new BlockStone();
	}
	
	@Override
	public void draw(Graphics g) {
		//super.draw(g);
		
    	Graphics2D g2D = (Graphics2D)g;
		//g.setColor(color);
		//g.fillRect(posX * sizeX, posY * sizeY, sizeX, sizeY);
    	if(texture != null)
    	{
	    	//g2D.drawImage(texture, posX * size, posY * size, posX * size + size, posY * size + size, 
	    	//		spritePosY, spritePosY, spriteSizeX, spriteSizeY, null);
	    	g2D.drawImage(texture, posX, posY, posX + size, posY + size, 
	    			spritePosY, spritePosY, spriteSizeX, spriteSizeY, null);
    	}
	}

	@Override
	public void update() {
	    
	}
}
