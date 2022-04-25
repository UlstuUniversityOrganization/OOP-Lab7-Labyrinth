import java.awt.Color;
import java.awt.Graphics;

public class BlockLava extends Block
{
	public int damage = 100;
	public int damageTimer = 0;
	public int damageTime = 1;
	
	public BlockLava()
	{
		super();
		texture = TextureContent.lavaTexture;
		spriteSizeX = texture.getWidth();
		spriteSizeY = texture.getHeight();
	}

	@Override
	public Block clone() 
	{
		return new BlockLava();
	}
	
	@Override
	public void stayOnBlock(Entity entity)
	{
		damageTimer++;
		if(damageTimer >= damageTime)
		{
			entity.health -= damage;
			damageTimer = 0;
		}
		
		/*
		mapManager.restartMap(mapManager.activeMapID);
		if(entity instanceof Player)
		{
			//mapManager.restartMap(mapManager.activeMapID);
		}
		*/
	}

	@Override
	public void update()
	{
		
	}
	
	@Override
	public void draw(Graphics g)
	{
		super.draw(g);	
	}

}
