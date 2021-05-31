import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int xSpeed;
	int ySpeed;
	boolean needImage = true;
	boolean gotImage = false;
	
	public static BufferedImage objectImage;
	public BufferedImage introMage;
	Rectangle collisionBox;
	
	String suddenlySky = "sky.jpg";
	
	public GameObject(int x, int y, int width, int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		
		collisionBox = new Rectangle(x, y, width, height);
		
		if (needImage) {
			try {
				introMage = ImageIO.read(this.getClass().getResourceAsStream(suddenlySky));
			} catch (Exception e) {
				System.out.println("Error: No found images");
				System.out.println("Error source: GameObject");
			}
		}
	}
	

	void update(){
		collisionBox.setBounds(x, y, width, height);
		x+=xSpeed;
		y+=ySpeed;
		
	}

	void draw(Graphics g) {
		g.drawImage(introMage, x, y, width, height, null);
	}


	void walk(boolean isLeft){
		if(!isLeft) {
			xSpeed=10;
		}
		else if(isLeft) {
			xSpeed=-10;
		}
	}
	

	void setPosition(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
}
