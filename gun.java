public class gun
{ 
    private Vector2 pos;
    private int speed;
    private long lastShot;
    private int fireRate;
    public gun(int screenWidth, int screenHeight, int gunHeight)
    {
        pos = new Vector2(screenWidth / 2, screenHeight - gunHeight);
        speed = 100;
        fireRate = 500;
        lastShot = 0;
    }
    
    public void Move(Vector2 dir, double delta, int screenWidth, int screenHeight, int gunHeight)
    {
        pos.x += dir.x * delta * speed;
        pos.y += dir.y * delta *  speed;
        System.out.println(dir.x);
        
        pos.Clamp(0, screenWidth, gunHeight + 10, screenHeight - gunHeight);
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
