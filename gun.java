public class gun
{ 
    private Vector2 pos;
    private int speed;
    public gun(int screenWidth, int screenHeight, int gunHeight)
    {
        pos = new Vector2(screenWidth / 2, screenHeight - gunHeight);
        speed = 300;
    }
    
    public void Move(Vector2 dir, double delta, int screenWidth, int screenHeight, int gunHeight)
    {
        pos.x += dir.x * delta * speed;
        pos.y += dir.y * delta *  speed;
        
        pos.Clamp(0, screenWidth, gunHeight + 10, screenHeight - gunHeight);
    }
    
    public Bullet shoot(){
        Vector2 bulletPos = new Vector2(pos.x, pos.y);
        return new Bullet(bulletPos);
    }
    public Vector2 getPosition(){
        return pos;
    }
}
