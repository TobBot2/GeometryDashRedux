import java.awt.Graphics;
import java.util.ArrayList;

public abstract class GameObject {
	protected float x, y;
	protected float velX, velY;
	protected ID id;

	protected ArrayList<Trait> traits;
	
	public GameObject(float x, float y) {
		this.x = x;
		this.y = y;
		this.id = ID.GameObject;

		this.traits = new ArrayList<Trait>();
	}
	public void addTrait(Trait t){
		this.traits.add(t);
		
	}
	public Trait getTrait(String name){
		for (Trait t : traits){
			if (t.name == name){
				return t;
			}
		}
		return null;
	}
	public void update(float dt, World world){
		for (Trait t : traits){
			t.update(dt,world);
		}
	}
	public abstract void render(Graphics g);

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
	
	
}
