public class Physics extends Trait{
    public Physics(GameObject parent){
        super("physics", parent);
    }
    @Override
    public void update(float dt, World world){
        parent.y += parent.velY;
        world.level.tileCollider.checkY(parent, world.level);

        parent.x += parent.velX;
        world.level.tileCollider.checkX(parent, world.level);
        
        parent.velY += world.gravity;
    }
    @Override
    public void obstructs(GameObject match){

    }
}