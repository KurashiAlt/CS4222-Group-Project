import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class NoteManager {

    private ArrayList<Note> notes;

    public NoteManager() {
        notes = new ArrayList<>();

        notes.add(new Note("A", "A.png", 100, 100));
        notes.add(new Note("B", "B.png", 200, 100));
        notes.add(new Note("C", "C.png", 300, 100));
        notes.add(new Note("D", "D.png", 400, 100));
        notes.add(new Note("E", "E.png", 500, 100));
        notes.add(new Note("F", "F.png", 600, 100));
        notes.add(new Note("G", "G.png", 700, 100));
    }

    public void draw(Graphics2D g) {
        for (Note n : notes) {
            n.draw(g);
        }
    }

    public void checkBulletCollision(Bullet bullet) {
        Rectangle bulletBox = bullet.getBounds();

        for (int i = 0; i < notes.size(); i++) {
            Note n = notes.get(i);

            if (bulletBox.intersects(n.getBounds())) {
                n.playSound();
                notes.remove(i);
                bullet.setActive(false);
                break;
            }
        }
    }
}
