import javax.swing.*;

public class Program
{
    static Boolean isRunning = true;
    static long lastTime;
    
    public static void Main() {
        SwingUtilities.invokeLater(() -> { _start(); });
    }
    
    public static void _start()
    {
        DrawingSystem._start();
        TestingField._start();
        
        lastTime = System.nanoTime();
        GameLoop();
    }
    
    public static void _stop() {
        DrawingSystem._stop();
        TestingField._stop();
        System.exit(0);
    }

    public static void GameLoop() {
        if (!isRunning) {
            _stop();
            return;
        }
        
        long now = System.nanoTime();
        double delta = (now - lastTime) / 1_000_000_000.0;
        lastTime = now;
        
        Process(delta);
        SwingUtilities.invokeLater(Program::GameLoop);
    }
    
    public static void Process(double delta)
    {
        DrawingSystem._process(delta);
        TestingField._process(delta);
    }
}