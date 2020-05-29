import java.awt.Color;
import java.awt.Graphics;
public class Player extends GameObject{
	private Collider bounds;

	public Player(float x, float y, KeyInput keyInput) {
		super(x, y, 32, 32);
		this.id = ID.Player;

		this.addTrait(new PlayerController(keyInput, this));
		this.addTrait(new Move(this));
		this.addTrait(new Physics(this));

		bounds = new Collider(0f,0f,1f,1f, this);
	}

	@Override
	public void update(float dt, World world) {
		super.update(dt, world);
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect((int)x, (int)y, 32, 32);
	}
	public float[] getPosition(){
		float[] arr = {x,y};
		return arr;
	}
}
