public class Bullet
{ 
    private Position pos;
    private int speed;
    private boolean bulletLife;
    // Where the bullet has to start and whatnot+ give it life
    public Bullet(Position startPos){
        pos= startPos;
        speed = 10;
        bulletLife = true;
    }
    //Each frame it moves up by the speed...also dies @ top.
    public void update()
    {
        pos.Y = pos.Y-speed;
        if (pos.Y<= 0){
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
    public Position getPosition(){
        return pos;
    }
    public int getX()
    {
        return pos.X;
    }
    public int getY()
    {
        return pos.Y;
    }
}