import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    Dimension windowSize = new Dimension(900, 650);

    static Main app;

    Font welcomeFont;
    Font newFont;
    Font todoFont;

    JFrame frame;
    JPanel startPanel;
    JPanel guiPanel;
    JPanel todoPanel;

    JTextPane todoTextPane;

    public void run() {
        frame = new JFrame();

        frame.setVisible(true);
        frame.setSize(windowSize);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
    }

    public void startMenu() {
        startPanel = new JPanel();
        JPanel labelPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        JLabel welcomeLabel = new JLabel("Welcome");
        JButton startButton = new JButton("Start");

        welcomeFont = new Font("TimesRoman", Font.PLAIN | Font.BOLD, 65);

        frame.add(startPanel);

        startPanel.setSize(windowSize);
        startPanel.setBackground(Color.white);
        startPanel.setLayout(null);
        startPanel.add(labelPanel);
        startPanel.add(buttonPanel);

        labelPanel.setBounds(300, 50, 300, 200);
        labelPanel.setLayout(null);
        labelPanel.setBackground(Color.white);

        buttonPanel.setBounds(400, 400, 100, 70);
        buttonPanel.setLayout(null);

        labelPanel.add(welcomeLabel);
        welcomeLabel.setSize(300, 200);
        welcomeLabel.setFont(welcomeFont);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setVerticalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBackground(Color.WHITE);

        buttonPanel.add(startButton);
        startButton.setSize(100, 70);
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);
        startButton.setBackground(Color.GRAY);
        startButton.addActionListener(al);

    }

    public void GUI() {
        JPanel listPanel = new JPanel();
        JPanel secListPanel = new JPanel();
        JLabel firstLabel = new JLabel("To-Do");
        JLabel secLabel = new JLabel("Completed");

        todoTextPane = new JTextPane();

        newFont = new Font("TimesRoman", Font.PLAIN | Font.BOLD, 20);
        todoFont = new Font("TimesRoman", Font.PLAIN | Font.BOLD, 15);

        todoPanel = new JPanel();
        guiPanel = new JPanel();
        frame.add(guiPanel);

        guiPanel.setBackground(Color.WHITE);
        guiPanel.setLayout(null);
        guiPanel.setSize(windowSize);
        guiPanel.add(todoPanel);
        guiPanel.add(listPanel);
        guiPanel.add(secListPanel);

        todoPanel.setSize(150, 200);
        todoPanel.setLayout(null);
        todoPanel.setLocation(100, 40);
        todoPanel.setBackground(Color.GRAY);
        todoPanel.add(todoTextPane);

        listPanel.setBounds(100, 0, 150, 40);
        listPanel.add(firstLabel);

        secListPanel.setBounds(300, 0, 150, 40);
        secListPanel.add(secLabel);

        firstLabel.setSize(150, 0);
        firstLabel.setFont(newFont);

        secLabel.setSize(150, 0);
        secLabel.setFont(newFont);

        todoTextPane.setFont(todoFont);
        todoTextPane.setBounds(0, 0, 150, 200);
        todoTextPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }

    public static void main(String[] args) {
        app = new Main();
        app.run();
        app.startMenu();
    }

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.remove(startPanel);
            frame.revalidate();
            frame.repaint();

            app.GUI();
        }
    };
}
