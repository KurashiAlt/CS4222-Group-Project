import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class DrawingSystem
{
    private static JFrame frame;
    private static DrawPanel panel;
    
    public static void _start() {
        frame = new JFrame("Basic Swing Window");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);

        panel = new DrawPanel();
        frame.add(panel);
        
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                Program.isRunning = false;
            }
        });


        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void _process(double delta) {
        panel.repaint();
    }
    public static void _stop() {
        frame.dispose();
    }
    
    public static List<Position> Guns = new ArrayList<Position>();
    public static List<Position> Enemies = new ArrayList<Position>();
    public static List<Position> Bullets = new ArrayList<Position>();
    public static void ConnectGun(Position position) { Guns.add(position); }
    public static void DisconnectGun(Position position) { Guns.remove(position); }
    public static void ConnectBullet(Position position) { Bullets.add(position); }
    public static void DisconnectBullet(Position position) { Bullets.remove(position); }
    public static void ConnectEnemy(Position position) { Enemies.add(position); }
    public static void DisconnectEnemy(Position position) { Enemies.remove(position); }
    
    private static class DrawPanel extends JPanel {
        public DrawPanel() {
            setBackground(Color.BLACK);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        
            Graphics2D g2 = (Graphics2D) g;
        
            // --- Guns (WHITE) ---
            g2.setColor(Color.WHITE);
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