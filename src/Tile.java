import java.awt.Graphics;
import java.awt.Color;
public class Tile extends GameObject{
    private Color color;
    private boolean isSolid;
    private Collider bounds;
    public Tile(float x, float y, float width, float height, int type){
        super(x,y,width,height);
        bounds = new Collider(0f,0f,1f,1f, this);
        setType(type);
    }
    @Override
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect((int)x, (int)y,(int)width, (int)height);
    }
    public void setType(int type){
        switch (type) {
            case (0):
                color = Color.blue;
                isSolid = false;
                break;
            case (1):
                color = Color.green;
                isSolid = false;
                break;
            case (2):
                color = Color.black;
                isSolid = true;
                break;
            default:
                System.out.println("Invalid type for Tile");
                break;
        }
    }
}