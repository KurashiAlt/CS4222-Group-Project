import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameMain {

    private static JFrame window;
    public static JPanel currentPanel;
    private static long lastTime;

    private static JLabel titleLabel;

    public static void _start() {
        window = Program.frame;

        currentPanel = GetMenu();
        window.add(currentPanel);
    }


    public static void _process(double delta) {
        long now = System.nanoTime();
        lastTime = now;
    }
    
    public static JPanel GetDead() {
        JPanel menu = new JPanel();
        menu.setLayout(new BorderLayout());

        // Title 
        titleLabel = new JLabel("You are Dead", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        menu.add(titleLabel, BorderLayout.NORTH);

        // Buttons panel
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(3, 1, 10, 10));
        buttons.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        
        JButton quitBtn = makeStyledButton("Quit");
        
        quitBtn.addActionListener(e -> Program.isRunning = false);

        buttons.add(quitBtn);

        menu.add(buttons, BorderLayout.CENTER);

        return menu;
    }
    
    public static JPanel GetMenu() {
        JPanel menu = new JPanel();
        menu.setLayout(new BorderLayout());

        // Title 
        titleLabel = new JLabel("The Space Base", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        menu.add(titleLabel, BorderLayout.NORTH);

        // Buttons panel
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(3, 1, 10, 10));
        buttons.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));

        JButton startBtn = makeStyledButton("Start Game");
        JButton tutorialBtn = makeStyledButton("Tutorial");
        JButton quitBtn = makeStyledButton("Quit");

        startBtn.addActionListener(e -> switchPanel(DrawingSystem.GetGameMenu()));
        tutorialBtn.addActionListener(e -> showTutorial());
        quitBtn.addActionListener(e -> Program.isRunning = false);

        buttons.add(startBtn);
        buttons.add(tutorialBtn);
        buttons.add(quitBtn);

        menu.add(buttons, BorderLayout.CENTER);

        return menu;
    }

    
    private static JButton makeStyledButton(String text) {
        JButton btn = new JButton(text);

        btn.setFocusPainted(false);
        btn.setFont(new Font("SansSerif", Font.BOLD, 26));

        // Button colours
        Color normal = new Color(70, 130, 180);      // Steel blue
        Color hover = new Color(100, 160, 210);      // Lighter blue
        Color textColor = Color.WHITE;

        btn.setBackground(normal);
        btn.setForeground(textColor);

        // Hover effect
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(hover);
            }
            public void mouseExited(MouseEvent e) {
                btn.setBackground(normal);
            }
        });

        return btn;
    }

    // -------------------------------
    // Tutorial Screen
    // -------------------------------
    public static void showTutorial() {
        JPanel tutorial = new JPanel();
        tutorial.setLayout(new BorderLayout());

        JTextArea text = new JTextArea();
        text.setEditable(false);
        text.setFont(new Font("Monospaced", Font.PLAIN, 16));

        text.setText(
            "CONTROLS\n" +
            "W - move forward\n" +
            "A - move left\n" +
            "D - move right\n" +
            "S - move backwards\n" +
            "U - shoot\n\n" +
            "AIM\n" +
            "• Hit the red boxes (notes) to play the instrument\n" +
            "• Hit the notes to avoid dying\n" +
            "• The octave of the notes depends on how high up they are when killed\n"
        );

        JButton backBtn = makeStyledButton("Back");
        backBtn.addActionListener(e -> switchPanel(GetMenu()));

        tutorial.add(new JScrollPane(text), BorderLayout.CENTER);
        tutorial.add(backBtn, BorderLayout.SOUTH);

        switchPanel(tutorial);
    }

    
    public static void switchPanel(JPanel newPanel) {
        window.remove(currentPanel);
        currentPanel = newPanel;
        window.add(currentPanel);
        window.revalidate();
        window.repaint();
    }

    
    private static void showMessage(String msg) {
        JOptionPane.showMessageDialog(window, msg);
    }
}