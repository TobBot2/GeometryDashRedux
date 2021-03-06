import java.awt.Color;
import java.awt.Graphics;
public class Player extends GameObject{
	public Player(float x, float y, KeyInput keyInput) {
		super(x, y, 32, 32);
		this.id = ID.Player;

		this.addTrait(new PlayerController(keyInput, this));
		this.addTrait(new Move(this));
		this.addTrait(new Physics(this));

		
	}

	@Override
	public void update(float dt, World world) {
		super.update(dt, world);
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect((int) getLeft(), (int) getTop(), 32, 32);
	}
	public float[] getPosition(){
		float[] arr = {x,y};
		return arr;
	}
}
