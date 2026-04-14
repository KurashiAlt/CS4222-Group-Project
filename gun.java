public class gun
{ 
    private int x;
    private int y;
    private int speed;
    private long lastShot;
    private int fireRate;
    public gun(int screenWidth, int screenHeight, int gunHeight)
    {
        x = screenWidth/2;
        y = screenHeight-gunHeight;
        speed =10;
        fireRate = 500;
        lastShot=0;
    }
        public void Left()
        {
            x = x-speed;
            if (x<0)
            {x=0;}
        }
        public void Right(int screenWidth){
            x = x+ speed;
            if(x> screenWidth)
            {x = screenWidth;}
        }
        public Bullet shoot()
        {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastShot >= fireRate){
                lastShot = currentTime;
                return new Bullet(x, y);
            }
            return null; }
            public int getX(){return x; }
            public int getY() {return y;}
        }
