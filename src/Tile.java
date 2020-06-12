import java.awt.Graphics;
import java.awt.Color;
public class Tile extends GameObject{
    private Color color;
    private boolean isSolid = false;
    public Tile(float x, float y, float width, float height, int type){
        super(x,y,width,height);
        setType(type);
    }
    @Override
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect((int) getLeft(), (int) getTop(),(int) width, (int) height);
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
    public boolean getSolid(){
        return isSolid;
    }
}