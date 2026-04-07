import javax.swing.*;

public class Program
{
    public static void _start()
    {
        TestingField._start();
        DrawingSystem._start();
        
        lastTime = System.nanoTime();
        GameLoop();
    }
    
    public static void _stop() {
        TestingField._stop();
        DrawingSystem._stop();
    }
    
    public static void _process(double delta)
    {
        TestingField._process(delta);
        DrawingSystem._process(delta);
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