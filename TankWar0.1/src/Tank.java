import java.awt.*;
import java.awt.event.KeyEvent;
public class Tank {

	private int x,y;
	
	private static final int  X_SPEED = 5;
	
	private static final int  Y_SPEED = 5;
	private boolean bL =false, bU = false, bD = false, bR = false;
	
	public enum Direction {R,L,U,D,RU,RD,LU,LD,STOP};
	
	private Direction dir = Direction.STOP;
	
	public Tank(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x,y,30,30);
		g.setColor(c);
		move();
	}
	
	void move() {
		switch (dir) {
		case U:
			y -= Y_SPEED;
			break;

		case D:
			y += Y_SPEED;
			break;

		case L:
			x -= X_SPEED;
			break;

		case R:
			x += X_SPEED;
			break;

		case LU:
			x -= X_SPEED;
			y -= Y_SPEED;
			break;

		case RU:
			x += X_SPEED;
			y -= Y_SPEED;
			break;

		case LD:
			x -= X_SPEED;
			y += Y_SPEED;
			break;

		case RD:
			x += X_SPEED;
			y += Y_SPEED;
			break;

		case STOP:

		}

	}
	void locateDirection() {
		if(bU && !bL && !bD && !bR) dir = Direction.U;
		else if(!bU && bL && !bD && !bR) dir = Direction.L;
		else if(!bU && !bL && bD && !bR) dir = Direction.D;
		else if(!bU && !bL && !bD && bR) dir = Direction.R;
		else if(bU && bL && !bD && !bR) dir = Direction.LU;
		else if(bU && !bL && !bD && bR) dir = Direction.RU;
		else if(!bU && bL && bD && !bR) dir = Direction.LD;
		else if(!bU && !bL && bD && bR) dir = Direction.RD;
		else if(!bU && !bL && !bD && !bR) dir = Direction.STOP;
	}
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_RIGHT: 
			bR = true;
			break;
		
		case KeyEvent.VK_LEFT:
			bL = true;
			break;
		
		case KeyEvent.VK_UP: 
			bU = true;
			break;
		
		case KeyEvent.VK_DOWN: 
			bD = true;
			break;
		}
		locateDirection();
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_RIGHT: 
			bR = false;
			break;
		
		case KeyEvent.VK_LEFT:
			bL = false;
			break;
		
		case KeyEvent.VK_UP: 
			bU = false;
			break;
		
		case KeyEvent.VK_DOWN: 
			bD = false;
			break;
		}
		locateDirection();
		
	}
}