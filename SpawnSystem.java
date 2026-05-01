public class SpawnSystem
{
    public static double SpawnTimer = 0;
    public static double SPAWN_RATE = 1.9; 
    public static void _process(double delta) {
        SpawnTimer += delta;
        if (SpawnTimer > SPAWN_RATE) {
            SpawnTimer = 0;
            int minX = 0;
            int maxX = 6;
            
            int randomX=minX + (int)(Math.random()*(maxX-minX));
            EnemySystem.spawnEnemy(new Vector2(randomX * 100 + 50 - (Enemy.size.x / 2), 0));
        }
    }
}