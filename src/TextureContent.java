import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TextureContent {

	static public BufferedImage playerTexture;
	static public BufferedImage grassTexture;
	static public BufferedImage stoneTexture;
	static public BufferedImage lavaTexture;
	static public BufferedImage finishTexture;
	static public BufferedImage catTexture;
	static public BufferedImage spike_offTexture;
	static public BufferedImage spike_onTexture;
	
	public TextureContent()
	{
		try {
			playerTexture = ImageIO.read(ClassLoader.getSystemResource("Textures/Entity/Player.png"));
			grassTexture = ImageIO.read(ClassLoader.getSystemResource("Textures/Block/grass.jpg"));
			stoneTexture = ImageIO.read(ClassLoader.getSystemResource("Textures/Block/stone.png"));
			lavaTexture = ImageIO.read(ClassLoader.getSystemResource("Textures/Block/lava.jpg"));
			finishTexture = ImageIO.read(ClassLoader.getSystemResource("Textures/Block/finish.png"));
			catTexture = ImageIO.read(ClassLoader.getSystemResource("Textures/Entity/cat.png"));
			spike_offTexture = ImageIO.read(ClassLoader.getSystemResource("Textures/Block/spike_off.png"));
			spike_onTexture = ImageIO.read(ClassLoader.getSystemResource("Textures/Block/spike_on.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
