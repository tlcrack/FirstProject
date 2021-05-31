import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class MenuBackground {
	public BufferedImage menuImage;
	String menuBackground = "tree.jpg";
	MenuBackground(){
			try {
				menuImage = ImageIO.read(this.getClass().getResourceAsStream(menuBackground));
			} catch (Exception e) {
				System.out.println("Error: No found images");
				System.out.println("Error source: MenuBackground");
			}
		
	}
}