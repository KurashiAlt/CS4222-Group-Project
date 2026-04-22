import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameMain {

    private JFrame window;
    private JPanel currentPanel;
    private long lastTime;

    private JLabel titleLabel;

    public static void main(String[] args) {
        GameMain game = new GameMain();
        game._start();
    }
    public void _start() {
        window = new JFrame("Animated Start Menu");
        window.setSize(600, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        currentPanel = GetMenu();
        window.add(currentPanel);

        window.setVisible(true);

        lastTime = System.nanoTime();
        Timer timer = new Timer(16, e -> 
        {
            long now = System.nanoTime();
            double delta = (now - lastTime) / 1_000_000_000.0;
            lastTime = now;
            _process(delta);
        });
        timer.start();
    }


    public void _process(double delta) {
        
    }

    
    public JPanel GetMenu() {
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

        startBtn.addActionListener(e -> showMessage("Game would start here"));
        tutorialBtn.addActionListener(e -> showTutorial());
        quitBtn.addActionListener(e -> System.exit(0));

        buttons.add(startBtn);
        buttons.add(tutorialBtn);
        buttons.add(quitBtn);

        menu.add(buttons, BorderLayout.CENTER);

        return menu;
    }

    
    private JButton makeStyledButton(String text) {
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
    public void showTutorial() {
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
            "• Hit the letters (notes) to play the instrument\n" +
            "• Hit the notes to avoid dying\n" +
            "• Move up and down to change octaves\n"
        );

        JButton backBtn = makeStyledButton("Back");
        backBtn.addActionListener(e -> switchPanel(GetMenu()));

        tutorial.add(new JScrollPane(text), BorderLayout.CENTER);
        tutorial.add(backBtn, BorderLayout.SOUTH);

        switchPanel(tutorial);
    }

    
    private void switchPanel(JPanel newPanel) {
        window.remove(currentPanel);
        currentPanel = newPanel;
        window.add(currentPanel);
        window.revalidate();
        window.repaint();
    }

    
    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(window, msg);
    }
}