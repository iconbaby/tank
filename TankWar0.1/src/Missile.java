import java.awt.Color;
import java.awt.Graphics;


public class Missile {
	int x,y;
	
	public static final int X_SPEED = 10;
	public static final int Y_SPEED = 10;
	
	Tank.Direction dir;
	
	public Missile(int x,int y,Tank.Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.black);
		g.fillOval(x, y, 10, 10);
		g.setColor(c);
		move();
	}
	
	public void move() {
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
		}
		
	}
}