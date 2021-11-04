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
    JPanel[] todoPanel = new JPanel[100];
    JPanel listPanel;
    JPanel secListPanel;

    JTextArea[] todoTextArea  = new JTextArea[100];
    JTextField textField;

    JButton[] compButton = new JButton[100];
    JButton[] toDoButton = new JButton[100];

    Boolean[] isCompleted = new Boolean[100];

    int amountOfLists = 0;
    int clickedButton;

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



    public void toDoCard() {
        todoPanel[amountOfLists] = new JPanel();
        toDoButton[amountOfLists] = new JButton();
        compButton[amountOfLists] = new JButton();
        todoTextArea[amountOfLists] = new JTextArea();

        todoPanel[amountOfLists].setMaximumSize(new Dimension(150, 200));
        todoPanel[amountOfLists].setLayout(null);
        todoPanel[amountOfLists].setBackground(Color.BLACK);
        todoPanel[amountOfLists].add(todoTextArea[amountOfLists]);
        todoPanel[amountOfLists].add(toDoButton[amountOfLists]);
        todoPanel[amountOfLists].add(compButton[amountOfLists]);

        todoTextArea[amountOfLists].setFont(todoFont);
        todoTextArea[amountOfLists].setBounds(0, 0, 150, 170);
        todoTextArea[amountOfLists].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        todoTextArea[amountOfLists].setEditable(false);
        todoTextArea[amountOfLists].setLineWrap(true);
        todoTextArea[amountOfLists].setWrapStyleWord(true);

        toDoButton[amountOfLists].setBounds(0, 170, 110, 30);
        toDoButton[amountOfLists].setBorderPainted(false);
        toDoButton[amountOfLists].setFocusPainted(false);
        toDoButton[amountOfLists].setBackground(Color.BLUE);
        toDoButton[amountOfLists].addActionListener(toDoListener);
        toDoButton[amountOfLists].setText(String.valueOf(amountOfLists));

        compButton[amountOfLists].setBounds(110, 170, 40, 30);
        compButton[amountOfLists].setBorderPainted(false);
        compButton[amountOfLists].setFocusPainted(false);
        compButton[amountOfLists].addActionListener(complete);
        compButton[amountOfLists].setBackground(Color.GREEN);
        compButton[amountOfLists].setText(String.valueOf(amountOfLists));
    }

    public void GUI() {
        listPanel = new JPanel();
        secListPanel = new JPanel();

        JPanel panel = new JPanel();
        JButton addNewCardButton = new JButton("ADD");

        JLabel firstLabel = new JLabel("To-Do");
        JLabel secLabel = new JLabel("Completed");

        newFont = new Font("TimesRoman", Font.PLAIN | Font.BOLD, 20);
        todoFont = new Font("TimesRoman", Font.PLAIN | Font.BOLD, 15);

        guiPanel = new JPanel();
        frame.add(guiPanel);
        frame.add(panel);

        guiPanel.setBackground(Color.WHITE);
        guiPanel.setLayout(new GridLayout(0, 5));
        guiPanel.setSize(900, 550);
        guiPanel.add(listPanel);
        guiPanel.add(secListPanel);

        // Top List

        //listPanel.setLocation(100, 0);
        listPanel.setMinimumSize(new Dimension(150, 40));
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        listPanel.setBackground(Color.GRAY);
        listPanel.add(firstLabel);

        firstLabel.setSize(150, 40);
        firstLabel.setFont(newFont);
        firstLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

        //secListPanel.setBounds(300, 0, 150, 40);
        secListPanel.setLayout(new BoxLayout(secListPanel, BoxLayout.Y_AXIS));
        secListPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //secListPanel.setBackground(Color.GRAY);
        secListPanel.add(secLabel);

        secLabel.setSize(150, 0);
        secLabel.setFont(newFont);
        secLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        secLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

        panel.setBounds(0, 550, 900, 100);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.add(addNewCardButton);

        addNewCardButton.setBounds(10, 10, 100, 45);
        addNewCardButton.setFocusPainted(false);
        addNewCardButton.addActionListener(addNewToDo);
    }

    public void editText() {
        JFrame secJFrame = new JFrame();
        textField = new JTextField();
        String oldText = todoTextArea[clickedButton].getText();

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
            clickedButton = Integer.parseInt(e.getActionCommand());
            app.editText();

            System.out.println(clickedButton);
        }
    };

    ActionListener complete = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = Integer.parseInt(e.getActionCommand());

            if (!isCompleted[i]) {
                secListPanel.add(todoPanel[i]);
                listPanel.remove(todoPanel[i]);
                compButton[i].setBackground(Color.RED);

                frame.revalidate();
                frame.repaint();

                isCompleted[i] = true;
                System.out.println(i);

            } else {
                listPanel.add(todoPanel[i]);
                secListPanel.remove(todoPanel[i]);
                compButton[i].setBackground(Color.GREEN);

                frame.revalidate();
                frame.repaint();

                isCompleted[i] = false;
                System.out.println(i);

            }
        }
    };

    ActionListener addNewToDo = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            amountOfLists++;
            app.toDoCard();
            listPanel.add(todoPanel[amountOfLists]);
            isCompleted[amountOfLists] = false;

            frame.revalidate();
            frame.repaint();

        }
    };

    Action action = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            todoTextArea[clickedButton].setText(textField.getText());
        }
    };
}
