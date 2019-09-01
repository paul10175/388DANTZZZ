package GridTools;

import java.awt.Color;

//white turn right, black turn left
//0 - up, 1 - right, 2 - down, 3 - left;
public class Ant {
	private int x, y;
	private int dir;
	
	public Ant(int height, int width) {
		this.dir = 0;
		this.x = Math.floorDiv(width, 2);
		this.y = Math.floorDiv(height, 2);
	}
	
	public void logic(Color color) {
		if(color.equals(Color.WHITE))
			dir = (dir + 1) % 4;
		else 
			dir = (dir == 0) ? 3 : (dir - 1) % 4;
			
		switch(dir) {
			case 0: 
				y--;
				break;
			case 1: 
				x++;
				break;
			case 2:
				y++;
				break;
			case 3:
				x--;
				break;
		}
	}
	
	public boolean outOfBounds(int height, int width) {
		return (x < 0 || y < 0 || x > width || y > height);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getDirection() {
		return dir;
	}
}
