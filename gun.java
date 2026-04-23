public class gun
{ 
    private Position pos;
    private int speed;
    private long lastShot;
    private int fireRate;
    public gun(int screenWidth, int screenHeight, int gunHeight)
    {
        pos = new Position();
        pos.X = screenWidth/2;
        pos.Y = screenHeight-gunHeight;
        speed =10;
        fireRate = 500;
        lastShot=0;
    }
        public void Left()
        {
            pos.X = pos.X-speed;
            if (pos.X<0)
            {pos.X=0;}
        }
        public void Right(int screenWidth){
            pos.X = pos.X+ speed;
            if(pos.X> screenWidth)
            {pos.X = screenWidth;}
        }
        public void moveUp(int gunHeight){
            pos.Y = pos.Y- speed;
            if (pos.Y < gunHeight+10){
                pos.Y = gunHeight+10;
            }
        }
        public void moveDown(int screenHeight,int gunHeight){
            pos.Y = pos.Y + speed;
            if(pos.Y > screenHeight-gunHeight){
                pos.Y = screenHeight-gunHeight;
            }
        }
        
        public Bullet shoot(){
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastShot >= fireRate){
                lastShot = currentTime;
                Position bulletPos = new Position();
                bulletPos.X = pos.X;
                bulletPos.Y = pos.Y;
                return new Bullet(bulletPos);
            }
            return null; }
            public Position getPosition(){
                return pos;
            }
        }
