
public class BlockFinish extends Block
{

	public BlockFinish()
	{
		super();
		texture = TextureContent.finishTexture;
		spriteSizeX = texture.getWidth();
		spriteSizeY = texture.getHeight();
	}
	
	@Override
	public void stayOnBlock(Entity entity)
	{
		if(entity instanceof Player)
		{
			map.mapManager.activeMapID++;
			map.mapManager.activeMapID %= map.mapManager.maps.size();
			map.mapManager.restartMap(map.mapManager.activeMapID);
		}
	}
	
	@Override
	public Block clone() {
		return new BlockFinish();
	}

	@Override
	public void update() {	
	}

}
