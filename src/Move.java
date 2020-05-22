public class Move extends Trait{
    
    public Move(GameObject parent){
        super("playerController", parent);
    }
    @Override
    public void update(float dt, World world){
        parent.x += parent.velX;
        parent.y += parent.velY;
    }
    @Override
    public void obstructs(GameObject match){
        
    }
}