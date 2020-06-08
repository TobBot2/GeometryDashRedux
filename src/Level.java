import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Level {
	ArrayList<Tile> tileMap;
	int width;
	int height;
	
	final int TILE_SIZE;

	TileCollider tileCollider = new TileCollider();
	
	public Level(int tile_size) {
		this.TILE_SIZE = tile_size;
	}
	public void load(ArrayList<Integer> map, int width, int height) {
		this.width = width;
		this.height = height;
	}
	public void generate() {
		this.generate(100,40);
	}
	public void generate(int width, int height) {
		tileMap = new ArrayList<Tile>();
		this.width = width;
		this.height = height;
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				float x = col * TILE_SIZE + 0.5f;
				float y = row * TILE_SIZE + 0.5f;
				tileMap.add(new Tile(x,y,TILE_SIZE,TILE_SIZE, 0));
			}
		}
		int numOfGenerations = 10;
		for (int i = 0; i < numOfGenerations; i++){
			generatePlatforms();
		}
	}
	public Tile getTile(int col,int row){ // returns value of tileMap of index
		int index =  row*width + col;
		
		if (index > tileMap.size()) {
			System.err.println("Level.getTile(); Index out of range");
			return null;
		}
		return tileMap.get(index);
	}
	public void setTile(int col, int row, Tile tile){
		int index =  row*width + col;
		
		if (index > tileMap.size()) {
			System.err.println("Level.setTile("+col+','+row+','+tile+"); Index out of range");
			return;
		}
		tileMap.set(index, tile);
		
	}
	public void draw(Graphics g) {
		for (Tile tile : tileMap){
			tile.draw(g);
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
					Tile tile = getTile(col, row);
					
					int type = 1;
					if (row == (height - platformHeight)){
						type = 2;
					}
					tile.setType(type);
					col++;
				}
			}
			int gapWidth = randGenerate.nextInt(gapMaxWidth - gapMinWidth) + gapMinWidth;
			col += gapWidth;
		}
	}
}
