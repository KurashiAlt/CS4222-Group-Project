import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class DrawingSystem
{
    public static GamePanel panel;
    
    public static void _start() {
        panel = new GamePanel();
    }
    public static void _process(double delta) {
        if (GameMain.currentPanel == panel) {
            panel.repaint();
        }
    }
    public static void _stop() { }
    
    public static List<Vector2> Guns = new ArrayList<Vector2>();
    public static List<Vector2> Enemies = new ArrayList<Vector2>();
    public static List<Vector2> Bullets = new ArrayList<Vector2>();
    public static void ConnectGun(Vector2 position) { Guns.add(position); }
    public static void DisconnectGun(Vector2 position) { Guns.remove(position); }
    public static void ConnectBullet(Vector2 position) { Bullets.add(position); }
    public static void DisconnectBullet(Vector2 position) { Bullets.remove(position); }
    public static void ConnectEnemy(Vector2 position) { Enemies.add(position); }
    public static void DisconnectEnemy(Vector2 position) { Enemies.remove(position); }
    
    public static JPanel GetGameMenu() {
        return panel;
    }
    
    public static class GamePanel extends JPanel {
        public GamePanel() {
            setBackground(Color.BLACK);
        }
        
        public static String GetNote(int x) {
            switch (x) {
                case 0: return "C";
                case 1: return "C#";
                case 2: return "D";
                case 3: return "D#";
                case 4: return "E";
                case 5: return "F";
                case 6: return "F#";
                case 7: return "G";
                case 8: return "A";
                case 9: return "A#";
                case 10: return "B";
            }
            return "";
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        
            Graphics2D g2 = (Graphics2D) g;
        
            // Checkerboard
            Boolean t = false;
            g2.setColor(Color.WHITE);
            for (int y = 0; y <= 700; y += 100) {
                for (int x = 0; x <= 1200; x += 100) {
                    if (t == false)
                    {
                        t = true;
                    }
                    else {
                        g2.fillRect(x, y, 100, 100);
                        t = false;
                    }
                }
            }
            
            // --- Guns (BLUE) ---
            g2.setColor(Color.BLUE);
            for (Vector2 p : Guns) {
                g2.fillRect((int)p.x, (int)(p.y), 50, 50);
            }
        
            // --- Bullets (ORANGE) ---
            g2.setColor(Color.ORANGE);
            Vector2 bulletSize = Bullet.getSize();
            for (Vector2 p : Bullets) {
                g2.fillRect((int)p.x, (int)(p.y), (int)bulletSize.x, (int)bulletSize.y);
            }
        
            // --- Enemies (RED) ---
            g2.setFont(new Font("Arial", Font.BOLD, 32));
            Vector2 enemySize = Enemy.getSize();
            for (Vector2 p : Enemies) {
                g2.setColor(Color.RED);
                g2.fillRect((int)p.x, (int)(p.y), (int)enemySize.x, (int)enemySize.y);
                g2.setColor(Color.CYAN);
                g2.drawString(GetNote((int)(p.x / 100)), (int)p.x, (int)p.y + 40);
            }
        }
    }
}