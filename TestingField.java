import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class TestingField
{
    public static int EnemyCount = 10;
    public static double EnemySpeed = 500;
    public static int StartY = -100;
    public static int StopY = 1100;
    public static List<TestEnemy> TestEnemies = new ArrayList<TestEnemy>();
    
    public static void _start() {
        Random r = new Random();
        
        for (int i = 0; i < EnemyCount; i++) {
            int x = r.nextInt(700) + 50;
            int y = StartY;
            TestEnemy enemy = new TestEnemy();
            Position position = new Position();
            position.X = x;
            position.Y = y;
            enemy.position = position;
            TestEnemies.add(enemy);
            DrawingSystem.ConnectEnemy(position);
        }
    }
    public static void _process(double delta) {
        for (TestEnemy enemy : TestEnemies) {
            enemy.position.Y += EnemySpeed * delta;
            if (enemy.position.Y > StopY){
                enemy.position.Y = StartY;
            }
        }
    }
    public static void _stop() { }
}

class TestEnemy {
    Position position;
}