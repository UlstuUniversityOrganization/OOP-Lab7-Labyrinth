import java.awt.Color;

public class Cat extends Entity
{
	int timer = 0;
	int stepTime = 10;
	
	public Cat()
	{
		color = new Color(100, 100, 255);
		texture = TextureContent.catTexture;
		spritePosX = 0;
		spritePosY = 0;
		spriteSizeX = texture.getWidth();
		spriteSizeY = texture.getHeight();
		
		health = 45;
	}
	
	@Override
	public void update()
	{
		super.update();
		if(timer >= stepTime)
		{
			move((int)Math.round(Math.random() * 4));
			timer = 0;
		}
		timer++;
	}
	
	@Override
	public Entity clone() {
		return new Cat();
	}
	
}
