import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

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
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				tileMap.add(0);
			}
		}
		int numOfGenerations = 10;
		for (int i = 0; i < numOfGenerations; i++){
			generatePlatforms();
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
	public void setTile(int col, int row, int tile){
		int index =  row*width + col;
		
		if (index > tileMap.size()) {
			System.err.println("Level.setTile("+col+','+row+','+tile+"); Index out of range");
			return;
		}
		tileMap.set(index, tile);
		
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
				}else if (tile == 2){
					color = Color.black;
				}
				
				g.setColor(color);
				g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
			}
		}
		
	}
	public void generatePlatforms(){
		int gapMinWidth = 5;
		int gapMaxWidth = 10;
		int platformMinWidth = 3;
		int platformMaxWidth = 7;
		int platformMinHeight = 10;
		int platformMaxHeight = 20;
		Random randGenerate = new Random(); // sets seed
		int col = 0;
		while (col < width) {
			int platformWidth = randGenerate.nextInt(platformMaxWidth - platformMinWidth) + platformMinWidth;
			int platformHeight = randGenerate.nextInt(platformMaxHeight - platformMinHeight) + platformMinHeight;

			int startCol = col;
			int endCol = startCol + platformWidth;
			for (int row = height - 1; row >= (height - platformHeight); row--) {
				col = startCol;
				while (col < endCol && col < width) {
					int tile = 1;
					if (row == (height - platformHeight)){
						tile = 2;
					}
					setTile(col, row, tile);
					col++;
				}
			}
			int gapWidth = randGenerate.nextInt(gapMaxWidth - gapMinWidth) + gapMinWidth;
			col += gapWidth;
		}
	}
}
