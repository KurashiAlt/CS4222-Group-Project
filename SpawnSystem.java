public class SpawnSystem
{
    public static double SpawnTimer = 0;
    public static double SPAWN_RATE = 1.9; 
    public static void _process(double delta) {
        SpawnTimer += delta;
        if (SpawnTimer > SPAWN_RATE) {
            SpawnTimer = 0;
            int minX = 50;
            int maxX = 750;
            
            int randomX=minX + (int)(Math.random()*(maxX-minX));
            EnemySystem.spawnEnemy(new Vector2(randomX, 0));
        }
    }
}