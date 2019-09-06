package GridTools;

import java.awt.Color;

//white turn right, black turn left
//0 - up, 1 - right, 2 - down, 3 - left;
public class Ant {
	private int x, y;
	private int dir;
	private int height, width;
	
	public Ant(int height, int width) {
		this.dir = 0;
		this.width = width;
		this.height = height;
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
				if (y < 0)
					setCenter(width, height);
				break;
			case 1: 
				x++;
				if (x > width - 1)
					setCenter(width, height);
				break;
			case 2:
				y++;
				if (y > height - 1)
					setCenter(width, height);
				break;
			case 3:
				x--;
				if (x < 0)
					setCenter(width, height);
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
	
	public void setCenter(int width, int height) {
		this.x = Math.floorDiv(width, 2);
		this.y = Math.floorDiv(height, 2);
	}
	
	public int getDirection() {
		return dir;
	}
}
