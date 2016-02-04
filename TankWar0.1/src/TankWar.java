import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class TankWar extends Frame{
	
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	
	Tank mytank = new Tank(50,50);
	
	Image offScreenImage = null;
	
	public void paint(Graphics g) {
		mytank.draw(g);
		
	}
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.GREEN);
		gOffScreen.fillRect(0, 0,GAME_WIDTH,GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage,0,0,null);
		
	}

	public static void main(String[] args) {
		 new TankWar().LanuchFrame();
		
	}
	
	public void LanuchFrame() {
		this.setBounds(400,300,GAME_WIDTH,GAME_HEIGHT);
		this.setResizable(false);
		this.setTitle("TankWar");
		this.setBackground(Color.GREEN);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.addKeyListener(new KeyMontor());
		setVisible(true);
		new Thread(new PaintThread()).start();
		
	}
	private class PaintThread implements Runnable{

		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}
	}
	private class KeyMontor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			mytank.keyPressed(e);
		}
	}
}
