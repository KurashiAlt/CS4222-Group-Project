import java.util.ArrayList;

public class gun_system
{
    private static gun weapon;
    private static ArrayList<Bullet> bullets = new ArrayList<>();
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    private static final int GUN_HEIGHT = 50;
    
    public static void SpawnGun(){
        weapon = new gun(SCREEN_WIDTH, SCREEN_HEIGHT, GUN_HEIGHT);
        DrawingSystem.ConnectGun(weapon.getPosition());
    }

    public static void _start(){
        SpawnGun();
        System.out.println(weapon.getPosition().x);
        System.out.println(weapon.getPosition().y);
    }

    public static void _process(double delta){
        updateBullets();
        checkCollisions();
    }
        
    public static void moveLeft(){
        weapon.Left();
    }
    public static void moveRight(){
        weapon.Right(SCREEN_WIDTH);
    }
    public static void moveUp(){
        weapon.moveUp(GUN_HEIGHT);
    }
    public static void moveDown(){
        weapon.moveDown(SCREEN_HEIGHT, GUN_HEIGHT);
    }
    
    //AI to integrate
    public static void shoot(){
        Bullet bullet = weapon.shoot(); 
        if (bullet != null) {
            bullets.add(bullet);
            //SoundSystem.PlayShoot();
            DrawingSystem.ConnectBullet(bullet.getPosition());
        }
        
    }
    private static void updateBullets(){
        for(int i = bullets.size() - 1; i >= 0; i = i - 1) {
            Bullet bullet = bullets.get(i);
            bullet.update();
            if (!bullet.isAlive()) {
                DrawingSystem.DisconnectBullet(bullet.getPosition());
                bullets.remove(i);
            }
        }
    }
    private static void checkCollisions(){
        Enemy[] enemies = EnemySystem.getEnemies();
        for(Bullet bullet : bullets){
            for(Enemy enemy : enemies) {
                 if(
                     enemy.isAlive() &&
                     collisionDetect.collidesWith(
                        bullet.getPosition(),
                        enemy.getPosition(),
                        50,
                        50
                    )
                ) {
                    EnemySystem.killEnemy(enemy);
                    bullet.notAlive();
                }
             }
        }
    }
}