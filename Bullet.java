public class Bullet
{ 
    private Vector2 pos;
    private int speed;
    private boolean bulletLife;
    // Where the bullet has to start and whatnot+ give it life
    public Bullet(Vector2 startPos){
        pos = startPos;
        speed = 10;
        bulletLife = true;
    }
    //Each frame it moves up by the speed...also dies @ top.
    public void update()
    {
        pos.y = pos.y - speed;
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
    public Vector2 getPosition(){
        return pos;
    }
    public double getX()
    {
        return pos.x;
    }
    public double getY()
    {
        return pos.y;
    }
}