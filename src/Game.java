import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Game extends Canvas implements Runnable{
	
	public static int WIDTH = 1600, HEIGHT = 1000;
	public String title = "Geometry Dash Redux";
	
	private Thread thread;
	private boolean isRunning = false;
	
	private World world;
	private Player player;
	private KeyInput keyInput;
	
	private synchronized void start() {
		if (isRunning) return;
		
		thread = new Thread(this);
		thread.start();
		isRunning = true;
	}
	
	private synchronized void stop() {
		if (!isRunning) return;
		
		try {
			thread.join();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public Game() {
		new Window(WIDTH, HEIGHT, title, this);
		
		init();
		start();
	}
	
	private void init() {
		keyInput = new KeyInput();
		
		player = new Player(WIDTH/2,HEIGHT/2, keyInput);
		world = new World();
		
		
		ArrayList<Integer> testMap = new ArrayList<Integer>();
		for (int i = 0; i < 400; i++) {
			testMap.add(i % 2 == 0 ? 1 : 0);
		}
		world.loadLevel(testMap);
		
		this.addKeyListener(keyInput);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.requestFocus();
		long lastTime = System.nanoTime(); // time since start of program in nanoseconds
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--; 			
				} 			
			render(); 			
			frames++; 			 			
			if (System.currentTimeMillis() - timer > 1000) { 
				timer += 1000; 				
				frames = 0;
			}
		}
	}
	
	private void tick() {
		player.tick();
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.green);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		world.draw(g);
		
		player.render(g);
		
		
		bs.show();
		g.dispose();
	}
	
	public static void main(String args[]) {
		new Game();
		
	}
}
