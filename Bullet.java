public class Bullet
{ 
    private int x;
    private int y;
    private int speed;
    private boolean bulletLife;
    // Where the bullet has to start and whatnot+ give it life
    public Bullet(int startX, int startY){
        x= startX;
        y = startY;
        speed = 10;
        bulletLife = true;
    }
    //Each frame it moves up by the speed...also dies @ top.
    public void update()
    {
        y= y-speed;
        if (y<= 0){
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
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
}