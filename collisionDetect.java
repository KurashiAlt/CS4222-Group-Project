public class collisionDetect
{
    public static boolean collidesWith(
            Vector2 bulletPos,
            Vector2 enemyPos,
            int width,
            int height)
    {
        return bulletPos.x >= enemyPos.x &&
               bulletPos.x <= enemyPos.x + width &&
               bulletPos.y >= enemyPos.y &&
               bulletPos.y <= enemyPos.y + height;
    }
}