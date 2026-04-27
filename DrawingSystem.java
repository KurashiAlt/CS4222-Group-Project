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
    
    public static List<Position> Guns = new ArrayList<Position>();
    public static List<Position> Enemies = new ArrayList<Position>();
    public static List<Position> Bullets = new ArrayList<Position>();
    public static void ConnectGun(Position position) { Guns.add(position); }
    public static void DisconnectGun(Position position) { Guns.remove(position); }
    public static void ConnectBullet(Position position) { Bullets.add(position); }
    public static void DisconnectBullet(Position position) { Bullets.remove(position); }
    public static void ConnectEnemy(Position position) { Enemies.add(position); }
    public static void DisconnectEnemy(Position position) { Enemies.remove(position); }
    
    public static JPanel GetGameMenu() {
        return panel;
    }
    
    public static class GamePanel extends JPanel {
        public GamePanel() {
            setBackground(Color.BLACK);
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        
            Graphics2D g2 = (Graphics2D) g;
        
            // --- Guns (WHITE) ---
            g2.setColor(Color.BLUE);
            for (Position p : Guns) {
                g2.fillRect(p.X, p.Y, 50, 50);
            }
        
            // --- Bullets (ORANGE) ---
            g2.setColor(Color.ORANGE);
            for (Position p : Bullets) {
                g2.fillRect(p.X, p.Y, 50, 50);
            }
        
            // --- Enemies (RED) ---
            g2.setColor(Color.RED);
            for (Position p : Enemies) {
                g2.fillRect(p.X, p.Y, 50, 50);
            }
        }
    }
}