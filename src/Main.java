import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
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

    JTextArea todoTextArea;
    JTextField textField;

    JButton compButton;

    Boolean isCompleted = false;

    StyledDocument doc;

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

        JButton toDoButton = new JButton();
        compButton = new JButton();

        todoTextArea = new JTextArea();

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

        // Top List

        listPanel.setBounds(100, 0, 150, 40);
        listPanel.add(firstLabel);
        firstLabel.setSize(150, 0);
        firstLabel.setFont(newFont);

        secListPanel.setBounds(300, 0, 150, 40);
        secListPanel.add(secLabel);
        secLabel.setSize(150, 0);
        secLabel.setFont(newFont);

        // To Do card

        todoPanel.setSize(150, 200);
        todoPanel.setLayout(null);
        todoPanel.setLocation(100, 40);
        todoPanel.setBackground(Color.GRAY);
        todoPanel.add(todoTextArea);
        todoPanel.add(toDoButton);
        todoPanel.add(compButton);

        todoTextArea.setFont(todoFont);
        todoTextArea.setBounds(0, 0, 150, 170);
        todoTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        todoTextArea.setEditable(false);
        todoTextArea.setLineWrap(true);
        todoTextArea.setWrapStyleWord(true);

        toDoButton.setBounds(0, 170, 110, 30);
        toDoButton.setBorderPainted(false);
        toDoButton.setFocusPainted(false);
        toDoButton.setBackground(Color.BLUE);
        toDoButton.addActionListener(toDoListener);

        compButton.setBounds(110, 170, 40, 30);
        compButton.setBorderPainted(false);
        compButton.setFocusPainted(false);
        compButton.addActionListener(complete);
        compButton.setBackground(Color.GREEN);
    }

    public void editText() {
        JFrame secJFrame = new JFrame();
        textField = new JTextField();
        String oldText = todoTextArea.getText();

        textField.setText(oldText);

        secJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        secJFrame.setVisible(true);
        secJFrame.setLocationRelativeTo(null);
        secJFrame.add(textField);
        secJFrame.setSize(100, 80);

        textField.addActionListener(action);
    }

    public static void main(String[] args) {
        app = new Main();
        app.run();
        app.startMenu();
    }

    // Action Listeners

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.remove(startPanel);
            frame.revalidate();
            frame.repaint();

            app.GUI();
        }
    };

    ActionListener toDoListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            app.editText();
        }
    };

    ActionListener complete = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (!isCompleted) {
                todoPanel.setLocation(300, 40);
                compButton.setBackground(Color.RED);

                isCompleted = true;
            } else {
                todoPanel.setLocation(100, 40);
                compButton.setBackground(Color.GREEN);

                isCompleted = false;
            }
        }
    };

    Action action = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            todoTextArea.setText(textField.getText());
        }
    };
}
