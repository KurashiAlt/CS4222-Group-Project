import javax.swing.*;
import java.awt.*;

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
    
    public static void ConnectGun(Position position) { }
    public static void DisconnectGun(Position position) { }
    public static void ConnectBullet(Position position) { }
    public static void DisconnectBullet(Position position) { }
    public static void ConnectEnemy(Position position) { }
    public static void DisconnectEnemy(Position position) { }
    
    private static class DrawPanel extends JPanel {

        public DrawPanel() {
            setBackground(Color.BLACK);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            // Basic example drawing
            g2.setColor(Color.WHITE);
            g2.drawString("Swing window running", 20, 20);

            g2.setColor(Color.RED);
            g2.fillRect(100, 100, 50, 50);
        }
    }
}