import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class TankWar extends Frame{
	int x = 50;
	int y = 50;
	Image offScreenImage = null;
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x,y,30,30);
		g.setColor(c);
		y += 5;
	}
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(800, 600);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.GREEN);
		gOffScreen.fillRect(0, 0, 800,600);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage,0,0,null);
		
	}

	public static void main(String[] args) {
		 new TankWar().LanuchFrame();
		
	}
	
	public void LanuchFrame() {
		this.setBounds(400,300,800,600);
		this.setResizable(false);
		this.setTitle("TankWar");
		this.setBackground(Color.GREEN);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
		new Thread(new PaintThread()).start();
		
	}
	private class PaintThread implements Runnable{

		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}
	}
}
