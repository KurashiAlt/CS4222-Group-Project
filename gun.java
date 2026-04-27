public class gun
{ 
    private Vector2 pos;
    private int speed;
    private long lastShot;
    private int fireRate;
    public gun(int screenWidth, int screenHeight, int gunHeight)
    {
        pos = new Vector2(screenWidth / 2, screenHeight - gunHeight);
        speed = 10;
        fireRate = 500;
        lastShot = 0;
    }
    
    public void Left()
    {
        pos.x = pos.x - speed;
        if (pos.x < 0) {
            pos.x = 0;
        }
    }
    public void Right(int screenWidth){
        pos.x = pos.x + speed;
        if(pos.x > screenWidth) {
            pos.x = screenWidth;
        }
    }
    public void moveUp(int gunHeight){
        pos.y = pos.y - speed;
        if (pos.y < gunHeight + 10) {
            pos.y = gunHeight + 10;
        }
    }
    public void moveDown(int screenHeight,int gunHeight){
        pos.y = pos.y + speed;
        if(pos.y > screenHeight - gunHeight){
            pos.y = screenHeight - gunHeight;
        }
    }
    
    public Bullet shoot(){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastShot >= fireRate){
            lastShot = currentTime;
            Vector2 bulletPos = new Vector2(pos.x, pos.y);
            return new Bullet(bulletPos);
        }
        return null;
    }
    public Vector2 getPosition(){
        return pos;
    }
}
