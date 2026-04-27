import javax.swing.*;

public class Program
{
    public static JFrame frame;
    public static void _start()
    {
        frame = new JFrame("Basic Swing Window");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);
        
        GameMain._start();
        DrawingSystem._start();
        InputSystem._start();
        gun_system._start();
        TestingField._start();
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        lastTime = System.nanoTime();
        GameLoop();
    }
    
    public static void _stop() {
        TestingField._stop();
        InputSystem._stop();
        DrawingSystem._stop();
        
        frame.dispose();
        System.exit(0);
    }
    
    public static void _process(double delta)
    {
        GameMain._process(delta);
        DrawingSystem._process(delta);
        InputSystem._process(delta);
        gun_system._process(delta);
        TestingField._process(delta);
    }
    
    static Boolean isRunning = true;
    static long lastTime;
    
    public static void Main() {
        SwingUtilities.invokeLater(() -> { _start(); });
    }

    public static void GameLoop() {
        if (!isRunning) {
            _stop();
            return;
        }
        
        long now = System.nanoTime();
        double delta = (now - lastTime) / 1_000_000_000.0;
        lastTime = now;
        
        _process(delta);
        SwingUtilities.invokeLater(Program::GameLoop);
    }
}