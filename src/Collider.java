public class Collider{
    // 0 - 1 (percentage)
    float x, y, width, height;
    GameObject parent;

    public Collider(float x, float y, float width, float height, GameObject parent){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.parent = parent;
    }
    public float getLeft(){
        return parent.getLeft() + x * parent.width;
    }
    public void setLeft(float val){
        parent.setLeft(val - x * parent.width);
    }
    public float getRight(){
        return parent.getLeft() + width * parent.width;
    }
    public void setRight(float val){
        parent.setLeft(val - width * parent.width);
    }
    public float getTop(){
        return parent.getTop() + y * parent.height;
    }
    public void setTop(float val){
        parent.setTop(val - y * parent.height);
    }
    public float getBottom(){
        return parent.getTop() + height * parent.height;
    }
    public void setBottom(float val){
        parent.setTop(val - height * parent.height);
    }

    public boolean overlaps(Collider candidate){
        boolean result = !(
            getLeft() > candidate.getRight() || 
            getRight() < candidate.getLeft() ||
            getTop() > candidate.getBottom() ||
            getBottom() < candidate.getTop()
        );
        return result;
    }
}