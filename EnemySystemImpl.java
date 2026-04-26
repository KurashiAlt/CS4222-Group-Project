import java.util.ArrayList;

public class EnemySystemImpl implements EnemySystem {

    private static ArrayList<Enemy> enemies = new ArrayList<>();

    public static void _start() {
        enemies.clear();
    }

    public static void _process(double delta) {
        for (int i = enemies.size() - 1; i >= 0; i--) {
            Enemy enemy = enemies.get(i);
            enemy.update(delta);

            if (!enemy.isAlive()) {
                enemies.remove(i);
            }
        }
    }

    @Override
    public void spawnEnemy(Vector2 position) {
        enemies.add(new Enemy(position));
    }

    @Override
    public void killEnemy(Enemy enemy) {
        enemy.kill();
    }

    @Override
    public Enemy[] getEnemies() {
        return enemies.toArray(new Enemy[0]);
    }
}