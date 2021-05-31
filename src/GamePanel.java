import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	final static int WIDTH = 750;
	final static int HEIGHT = 500;
	boolean ingame = false;

	int MENU = 0;
	int CUTSCENE = 1;
	int GAME = 2;
	
	
	int MODE = MENU;
	
	JFrame frame = new JFrame();
	Timer updateTimer = new Timer(1000 / 60, this);
	
	ObjectManager om = new ObjectManager();
	BackgroundManager bm = new BackgroundManager(WIDTH, HEIGHT);
	
	MenuBackground mb = new MenuBackground();
	
	GamePanel() {
		
		
	}
	void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.add(this);
		frame.addKeyListener(this);
		
		updateTimer.start();
		frame.pack();
		repaint();
	}
		void drawBackground(Graphics g){
			if(MODE==MENU) {
				g.drawImage(mb.menuImage, 0, 0, WIDTH, HEIGHT, null);
			}
		}
	static int getPanelWidth() {
		return 750;
	}
	
	static int getPanelHeight() {
		return 500;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==updateTimer) {
			om.update();
			repaint();
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(MODE==GAME) {
			if(e.getKeyCode()==KeyEvent.VK_LEFT ||e.getKeyCode()==KeyEvent.VK_A) {
				om.c.walk(true);
			}
			else if(e.getKeyCode()==KeyEvent.VK_RIGHT ||e.getKeyCode()==KeyEvent.VK_D) {
				om.c.walk(false);
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if (MODE==GAME) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT
				|| e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D) {
				om.c.xSpeed=0;
			}
		}
	}
	
	protected void paintComponent(Graphics g) {
		drawBackground(g);
		om.draw(g);
	}
}