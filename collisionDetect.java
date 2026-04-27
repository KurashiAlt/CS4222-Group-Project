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
    
    public static boolean CollidesWithVec(
        Vector2 positionA, Vector2 sizeA,
        Vector2 positionB, Vector2 sizeB
    ) {
        return positionA.x < positionB.x + sizeB.x &&
               positionA.x + sizeA.x > positionB.x &&
               positionA.y < positionB.y + sizeB.y &&
               positionA.y + sizeA.y > positionB.y;
    }
}