import java.awt.Graphics;
import java.util.ArrayList;

public class World {
	final int TILE_SIZE = 32;
	
	Level level;
	
	protected float gravity = 0.1f;
	public World() {
		level = new Level(TILE_SIZE);
	}
	public void loadLevel(ArrayList<Integer> tileData) {
		level.generate();
	}
	public void draw(Graphics g) {
		level.draw(g);
	}
	public int getWidth(){
		return level.width * TILE_SIZE;
	}
	public int getHeight(){
		return level.height * TILE_SIZE;
	}
}
