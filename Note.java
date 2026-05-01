import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Note {

    private Image texture;
    private int x, y;
    private int width, height;
    private String name; // "A", "B", etc.

    public Note(String name, String textureFile, int x, int y) {
        this.name = name;
        this.texture = Toolkit.getDefaultToolkit().getImage(textureFile);
        this.x = x;
        this.y = y;
        this.width = 64;   // temporary size
        this.height = 64;  // change to match your sprite
    }

    public void draw(Graphics2D g) {
        g.drawImage(texture, x, y, width, height, null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public String getName() {
        return name;
    }

    public void playSound() {
        // TODO: hook up your sound system here
        System.out.println("Playing note: " + name);
    }
}
