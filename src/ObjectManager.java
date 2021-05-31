import java.awt.Graphics;

public class ObjectManager {
	
	GamePanel gp;
	
	ObjectManager() {
		startGame();
	}
	Mage c = new Mage(300, 100, 150, 150);
	
	void startGame() {
		
	}
	
	void update() {
		c.update();
	}
	
	void draw(Graphics g) {
		c.draw(g);
		
	}
}
