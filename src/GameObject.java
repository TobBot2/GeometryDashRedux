import java.awt.Graphics;
import java.util.ArrayList;

public abstract class GameObject {
	protected float x, y, width, height;
	protected float velX, velY;
	protected ID id;

	protected Collider bounds;

	protected ArrayList<Trait> traits;
	
	public GameObject(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = ID.GameObject;

		this.bounds = new Collider(0f, 0f, 1f, 1f, this);
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
	public abstract void draw(Graphics g);

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
	
	public float getLeft() {
		return x - width/2;
	}
	public void setLeft(float val){
		x = (val + width/2);
	}
	
	public float getRight() {
		return x + width / 2;
	}

	public void setRight(float val) {
		x = (val - width / 2);
	}

	public float getTop() {
		return y - height / 2;
	}

	public void setTop(float val) {
		y = (val + height / 2);
	}
	
	public float getBottom() {
		return y + height / 2;
	}

	public void setBottom(float val) {
		y = (val - height / 2);
	}
}
