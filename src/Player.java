import java.awt.Color;
import java.awt.Graphics;
public class Player extends GameObject{
	
	private KeyInput keyInput;
	
	private float acc = 1f;
	private float dcc = 0.95f;
	
	public Player(float x, float y, KeyInput keyInput) {
		super(x, y);
		this.id = ID.Player;
		this.keyInput = keyInput;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		// keys 0 - right
		// keys 1 - left
		// keys 2 - up
		// keys 3 - down
		// keys 4 - action
		if (keyInput.keys[0]) {
			velX += acc;
		}else if (keyInput.keys[1]) {
			velX -= acc;
		}else {
			velX *= dcc;
		}
		if (keyInput.keys[2]) {
			velY -= acc;
		}else if (keyInput.keys[3]) {
			velY += acc;
		}else {
			velY *= dcc;
		}
		
		if (keyInput.keys[4]) {
			x = 0;
			y = 0;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect((int)x, (int)y, 32, 32);
	}
	
	
}
