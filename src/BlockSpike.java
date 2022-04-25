import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BlockSpike extends Block
{

	public BufferedImage off_texture;
	public BufferedImage on_texture;
	public boolean spikesOn = true;
	
	public int damage = 100;
	public int damageTimer = 0;
	public int damageTime = 10;
	
	public int spikesOnTime = 50;
	public int spikesOnTimer = 0;
	
	public BlockSpike()
	{
		super();
		off_texture = TextureContent.spike_offTexture;
		on_texture = TextureContent.spike_onTexture;
		
		texture = spikesOn ? on_texture : off_texture;
		spriteSizeX = texture.getWidth();
		spriteSizeY = texture.getHeight();
	}
	
	@Override
	public void stayOnBlock(Entity entity)
	{
		super.stayOnBlock(entity);
		
		if(spikesOn)
		{
			damageTimer++;
			if(damageTimer >= damageTime)
			{
				entity.health -= damage;
				damageTimer = 0;
			}
		}
	}
	
	@Override
	public Block clone()
	{
		return new BlockSpike();
	}

	@Override
	public void update() 
	{
		spikesOnTimer++;
		if(spikesOnTimer >= spikesOnTime)
		{
			spikesOn = !spikesOn;
			spikesOnTimer = 0;
		}
		texture = spikesOn ? on_texture : off_texture;
		spriteSizeX = texture.getWidth();
		spriteSizeY = texture.getHeight();
	}
	
	@Override
	public void draw(Graphics g)
	{
		super.draw(g);
	}

}
