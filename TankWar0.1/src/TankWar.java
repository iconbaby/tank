import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class TankWar extends Frame{
	public static void main(String[] args) {
		 new TankWar().LanuchFrame();
		
	}
	
	public void LanuchFrame() {
		this.setBounds(400,300,800,600);
		setVisible(true);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
			
			
		});
	}
}
