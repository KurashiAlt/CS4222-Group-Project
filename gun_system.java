import java.util.ArrayList;

public class gun_system
{
    private static gun weapon;
    private static ArrayList<Bullet> bullets = new ArrayList<>();
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    private static final int GUN_HEIGHT = 90;
    
    public static void SpawnGun(){
        weapon = new gun(SCREEN_WIDTH, SCREEN_HEIGHT, GUN_HEIGHT);
        DrawingSystem.ConnectGun(weapon.getPosition());
    }

    public static void _start(){
        SpawnGun();
    }

    public static void _process(double delta){
        updateBullets(delta);
        checkCollisions();
        
        Vector2 moveDir = InputSystem.GetInputVector();
        moveDir.Normalize();
        weapon.Move(moveDir, delta, SCREEN_WIDTH, SCREEN_HEIGHT, GUN_HEIGHT);
    }
    
    //AI to integrate
    public static void shoot(){
        Bullet bullet = weapon.shoot(); 
        if (bullet != null) {
            bullets.add(bullet);
            SoundEffects.playGunshot();
            DrawingSystem.ConnectBullet(bullet.getPosition());
        }
        
    }
    private static void updateBullets(double delta){
        for(int i = bullets.size() - 1; i >= 0; i = i - 1) {
            Bullet bullet = bullets.get(i);
            bullet.update(delta);
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
                     collisionDetect.CollidesWithVec(
                        bullet.getPosition(),
                        bullet.getSize(),
                        enemy.getPosition(),
                        enemy.getSize()
                    )
                ) {
                    EnemySystem.killEnemy(enemy);
                    bullet.notAlive();
                }
             }
        }
    }
}