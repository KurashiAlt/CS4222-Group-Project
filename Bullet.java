public class Bullet
{
    private static Vector2 size = new Vector2(25, 25);
    private Vector2 pos;
    private int speed;
    private boolean bulletLife;
    
    // Where the bullet has to start and whatnot+ give it life
    public Bullet(Vector2 startPos){
        pos = startPos;
        speed = 500;
        bulletLife = true;
    }
    
    //Each frame it moves up by the speed...also dies @ top.
    public void update(double delta)
    {
        pos.y = pos.y - speed * delta;
        if (pos.y <= 0){
            bulletLife = false;
        }
    }
    
    public boolean isAlive(){
        return bulletLife;
    }
    public void notAlive()
    {
        bulletLife = false;
    }
    
    public Vector2 getPosition() { return pos; }
    public static Vector2 getSize() { return size; }
}