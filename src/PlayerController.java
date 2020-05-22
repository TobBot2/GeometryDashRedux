public class PlayerController extends Trait{

    private float acc = 2f;
    private float dcc = 0.9f;

    private KeyInput keyInput;
    public PlayerController(KeyInput keyInput, GameObject parent){
        super("playerController", parent);

        this.keyInput = keyInput;
    }
    @Override
    public void update(float dt, World world) {
        // TODO Auto-generated method stub
        // keys 0 - right
        // keys 1 - left
        // keys 2 - up
        // keys 3 - down
        // keys 4 - action
        if (keyInput.keys[0]) {
            parent.velX += acc;
        } else if (keyInput.keys[1]) {
            parent.velX -= acc;
        } else {
            parent.velX *= dcc;
        }
        if (keyInput.keys[2]) {
            parent.velY -= acc;
        } else if (keyInput.keys[3]) {
            parent.velY += acc;
        } else {
            parent.velY *= dcc;
        }

        if (keyInput.keys[4]) {
            parent.x = 0;
            parent.y = 0;
        }
    }

    @Override
    public void obstructs(GameObject match) {
        // TODO Auto-generated method stub

    }
    
}