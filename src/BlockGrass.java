import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class BlockGrass extends Block{

	public BlockGrass() {
		super();
		texture = TextureContent.grassTexture;
		spriteSizeX = texture.getWidth();
		spriteSizeY = texture.getHeight();
		
		intersective = false;
	}

	@Override
	public Block clone() {
		return new BlockGrass();
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
	}
	
	@Override
	public void update() {
	    
	}
}
