package GridTools;

import java.awt.Color;

public class Game {

	private Ant ant; 
	private MyGrid grid; 
	private int width, height;
	
	public Game(int width, int height) {
		this.width = width;
		this.height = height;
		this.grid = new MyGrid(height);
		this.ant = new Ant(height, width);
		setGridColor();
	}
	
	public void runGame() {
		Color temp = Color.white;
		Boolean justUpdated = false;
		grid.setColor(ant.getY(), ant.getX(), Color.red);
		
		while (true) {
			int oldX = ant.getX(), 
				oldY = ant.getY();
		
			justUpdated = true;
			
			ant.logic(temp);
				
			if (temp.equals(Color.BLACK))
				grid.setColor(oldY, oldX, Color.WHITE);
			else 
				grid.setColor(oldY, oldX, Color.BLACK);
			temp = grid.colors[ant.getY() + 5][ant.getX() + 5];
			grid.setColor(ant.getY(), ant.getX(), Color.RED);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean outOfBounds(int x, int y) {
		return (x < 5 || y < 5 || x > width || y > height);
	}
	
	
	public void setGridColor() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				grid.setColor(i, j, Color.white);
			}
		}
	}
}
