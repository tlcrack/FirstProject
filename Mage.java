import java.awt.Graphics;

public class Mage extends GameObject{
	
	boolean isVisible = false;
	
	Mage(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	
	
	void setVisible(boolean isVisible) {
		this.isVisible=isVisible;
	}
	
	void update() {
		if(x+xSpeed>=0 && y+ySpeed>=0 && y+ySpeed + height<=1000) {
			super.update();
		}
	}
	
}
