public class Vector2 {

    public double x;
    public double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vector2 other) {
        this.x += other.x;
        this.y += other.y;
    }
    
    public void Clamp(double minX, double maxX, double minY, double maxY) {
        if (x < minX) x = minX;
        if (x > maxX) x = maxX;
        if (y < minY) y = minY;
        if (y > maxY) y = maxY;
    }
    
    public void Normalize() {
        double length = Math.sqrt(x * x + y * y);
        
        if (length != 0) {
            x /= length;
            y /= length;
        }
    }
    
    public Vector2 Normalized() {
        double length = Math.sqrt(x * x + y * y);

        if (length == 0) {
            return new Vector2(0, 0);
        }
    
        return new Vector2(x / length, y / length);
    }

    public Vector2 copy() {
        return new Vector2(x, y);
    }
}
