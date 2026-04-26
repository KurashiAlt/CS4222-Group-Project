public interface EnemySystem {

    void spawnEnemy(Vector2 position);

    void killEnemy(Enemy enemy);

    Enemy[] getEnemies();
}