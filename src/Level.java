import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Level {
	ArrayList<Integer> tileMap;
	int width;
	int height;
	
	final int TILE_SIZE;
	
	public Level(int tile_size) {
		this.TILE_SIZE = tile_size;
	}
	public void load(ArrayList<Integer> map, int width, int height) {
		tileMap = map;
		this.width = width;
		this.height = height;
	}
	public void generate() {
		this.generate(100,40);
	}
	public void generate(int width, int height) {
		tileMap = new ArrayList<Integer>();
		this.width = width;
		this.height = height;
		
		int gapWidth = 5;
		int platformWidth = 10;

		boolean drawGap = false;

		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (row < 10){
					tileMap.add(0);
				}else{
					int index = col % (gapWidth + platformWidth); // a value between 0 - 14

					if (index > platformWidth){ // returns true if 11 - 14
						drawGap = true;
					}else{
						drawGap = false;
					}

					if (drawGap){
						tileMap.add(0);
					}else{
						tileMap.add(1);
					}
				}
			}
		}
	}
	public int getTile(int col,int row){ // returns value of tileMap of index
		int index =  row*width + col;
		
		if (index > tileMap.size()) {
			System.err.println("Level.getTile(); Index out of range");
			return -1;
		}
		return tileMap.get(index);
	}
	public void draw(Graphics g) {
		for (int col = 0; col < width; col++) {
			for (int row = 0; row < height; row++) {
				int tile = this.getTile(col, row);
				
				int x = col*TILE_SIZE;
				int y = row*TILE_SIZE;
				
				Color color = Color.blue;
				if (tile == 1){
					color = Color.green;
				}
				
				g.setColor(color);
				g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
			}
		}
		
	}
}
