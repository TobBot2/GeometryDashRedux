import java.awt.Graphics;
import java.util.ArrayList;

public class World {
	final int TILE_SIZE = 32;
	
	Level level;
	
	public World() {
		level = new Level(TILE_SIZE);
	}
	public void loadLevel(ArrayList<Integer> tileData) {
		level.generate();
	}
	public void draw(Graphics g) {
		level.draw(g);
	}
	
	
}