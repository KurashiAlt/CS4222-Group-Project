public class collisionDetect
{
    public static boolean collidesWith(
            Position bulletPos,
            Position enemyPos,
            int width,
            int height)
    {
        return bulletPos.X >= enemyPos.X &&
               bulletPos.X <= enemyPos.X + width &&
               bulletPos.Y >= enemyPos.Y &&
               bulletPos.Y <= enemyPos.Y + height;
    }
}