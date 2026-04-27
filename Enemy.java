public class Enemy {
    private static Vector2 size = new Vector2(50, 50);
    private Vector2 position;
    private Vector2 velocity;
    private boolean alive;

    public Enemy(Vector2 startPosition) {
        this.position = startPosition;
        this.velocity = new Vector2(0, 50);
        this.alive = true;
    }

    public void update(double delta) {
        if (!alive) return;

        position.x += velocity.x * delta;
        position.y += velocity.y * delta;
    }

    public Vector2 getPosition() { return position; }
    public static Vector2 getSize() { return size; }

    public boolean isAlive() {
        return alive;
    }

    public void kill() {
        alive = false;
    }

    public boolean reachedEnd(double endY) {
        return position.y >= endY;
    }
}