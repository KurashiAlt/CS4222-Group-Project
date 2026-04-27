import javax.swing.*;
import java.awt.event.*;

public class InputSystem
{
    public static boolean[] PressedKeys = new boolean[] { false, false, false, false };
    
    public static Vector2 GetInputVector() {
        double x = 0;
        if (PressedKeys[0]) x -= 1;
        if (PressedKeys[1]) x += 1;
        double y = 0;
        if (PressedKeys[2]) y -= 1;
        if (PressedKeys[3]) y += 1;
        return new Vector2(x, y);
    }
    
    private static void CreateInputDir(InputMap inputMap, ActionMap actionMap, String baseKey, int index) {
        inputMap.put(KeyStroke.getKeyStroke("pressed " + baseKey), "Pressed" + baseKey);
        inputMap.put(KeyStroke.getKeyStroke("released " + baseKey), "Released" + baseKey);
        actionMap.put("Pressed" + baseKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PressedKeys[index] = true;
            }
        });
        actionMap.put("Released" + baseKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PressedKeys[index] = false;
            }
        });
    }
    
    public static void _start() {
        InputMap inputMap = DrawingSystem.panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = DrawingSystem.panel.getActionMap();
        
        CreateInputDir(inputMap, actionMap, "A", 0);
        CreateInputDir(inputMap, actionMap, "D", 1);
        CreateInputDir(inputMap, actionMap, "W", 2);
        CreateInputDir(inputMap, actionMap, "S", 3);
        inputMap.put(KeyStroke.getKeyStroke("U"), "shoot");
        
        actionMap.put("shoot", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gun_system.shoot();
            }
        });
        
        Program.frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                Program.isRunning = false;
            }
        });
    }
    public static void _stop() { }
    public static void _process(double delta) { }
}