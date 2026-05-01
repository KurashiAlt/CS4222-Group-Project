import java.awt.*;
import java.util.ArrayList;

public class NoteManager {

    private ArrayList<NoteText> notes;

    public NoteManager() {
        notes = new ArrayList<>();

        // Create 7 notes A–G as text
        notes.add(new NoteText("A", "A.wav", 100, 100));
        notes.add(new NoteText("B", "B.wav", 200, 100));
        notes.add(new NoteText("C", "C.wav", 300, 100));
        notes.add(new NoteText("D", "D.wav", 400, 100));
        notes.add(new NoteText("E", "E.wav", 500, 100));
        notes.add(new NoteText("F", "F.wav", 600, 100));
        notes.add(new NoteText("G", "G.wav", 700, 100));
    }

    // Draw all notes as text
    public void draw(Graphics2D g) {
        g.setFont(new Font("Arial", Font.BOLD, 32));
        g.setColor(Color.WHITE);

        for (NoteText n : notes) {
            n.draw(g);
        }
    }

    // Collision with bullet
    public void checkBulletCollision(Bullet bullet) {
        Rectangle bulletBox = bullet.getBounds();

        for (int i = 0; i < notes.size(); i++) {
            NoteText n = notes.get(i);

            if (bulletBox.intersects(n.getBounds())) {
                n.playSound();
                notes.remove(i);
                bullet.setActive(false);
                break;
            }
        }
    }
}
