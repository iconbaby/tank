import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Missile {
	int x,y;
	
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	
	public static final int X_SPEED = 10;
	public static final int Y_SPEED = 10;
	
	Tank.Direction dir;
	
	TankWar tc;
	
	private boolean live = true;
	
	public boolean isLive() {
		return live;
	}

	public Missile(int x,int y) {
		this.x = x;
		this.y = y;
		
	}
	
	public Missile(int x,int y,Tank.Direction dir) {
		this(x,y);
		this.dir = dir;
		
	}
	
	public Missile(int x,int y,Tank.Direction dir,TankWar tc) {
		
		this(x, y,dir);
		this.tc = tc;
	}
	
	public void draw(Graphics g) {
		if(!live) {
			tc.missiles.remove(this);
			return;
			
		}
		
		Color c = g.getColor();
		g.setColor(Color.black);
		g.fillOval(x, y, WIDTH,HEIGHT);
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
		
		if(x < 0|| y < 0|| x > TankWar.GAME_WIDTH|| y > TankWar.GAME_HEIGHT) {
			live = false;
		}
		
	}
	public boolean hitTank(Tank t) {
		
		if(this.getRect().intersects(t.getRect()) && t.isLive()){
			t.setLive(false);
			this.live = false;
			return true;
		}
		return false;
	}
	public Rectangle getRect() {
		
		return new Rectangle(x,y,WIDTH,HEIGHT);
	}
}