public class SpawnSystem
{
    public static double SpawnTimer = 0;
    public static double SPAWN_RATE = 1; 
    public static void _process(double delta) {
        SpawnTimer += delta;
        if (SpawnTimer > SPAWN_RATE) {
            SpawnTimer = 0;
            EnemySystem.spawnEnemy(new Vector2(200, 0));
        }
    }
}