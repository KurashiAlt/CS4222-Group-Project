import java.util.ArrayList;

public class EnemySystem {
    private static ArrayList<Enemy> enemies = new ArrayList<>();

    public static void _start() {
        enemies.clear();
    }

    public static void _process(double delta) {
        for (int i = enemies.size() - 1; i >= 0; i--) {
            Enemy enemy = enemies.get(i);
            enemy.update(delta);

            if (!enemy.isAlive()) {
                DrawingSystem.DisconnectEnemy(enemy.getPosition());
                enemies.remove(i);
            }
        }
    }

    public static void spawnEnemy(Vector2 position) {
        enemies.add(new Enemy(position));
        DrawingSystem.ConnectEnemy(position);
    }

    public static void killEnemy(Enemy enemy) {
        enemy.kill();
    }

    public static Enemy[] getEnemies() {
        return enemies.toArray(new Enemy[0]);
    }
}