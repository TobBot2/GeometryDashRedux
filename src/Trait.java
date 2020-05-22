public abstract class Trait {
    String name;
    GameObject parent;
    public Trait(String name, GameObject parent){
        this.name = name;
        this.parent = parent;
    }
    public abstract void update(float dt, World world);
    public abstract void obstructs(GameObject match);

}