package com.manumafe;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Color;

public class Gui {
    private JFrame frame;
    private JLabel titleLabel;
    private Font font;
    private Color color;
    private JLabel randomImageLabel;
    private JLabel userImageLabel;
    private ImageIcon rockImage;
    private ImageIcon paperImage;
    private ImageIcon scissorsImage;
    private Random random;
    private ImageIcon[] imageArray;
    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;
    private JButton startPlayingButton;
    private JButton instructionsButton;
    private JPanel initialPanel;
    private JPanel gamePanel;
    private CardLayout cardLayout;
    private JLabel userPointsLabel;
    private JLabel pcPointsLabel;
    private JLabel resultLabel;
    private RockPaperScissors rockPaperScissors;
    private int pcPoints;
    private int userPoints;

    public Gui() {
        frame = new JFrame("Rock, Paper, Scissors");
        initialPanel = new JPanel();
        gamePanel = new JPanel();
        cardLayout = new CardLayout();

        titleLabel = new JLabel("Rock, Paper, Scissors");
        font = new Font("Arial", Font.BOLD, 40);
        color = new Color(0x9A4444);

        startPlayingButton = new JButton("Start Playing");
        instructionsButton = new JButton("Instructions");

        rockImage = new ImageIcon("E:/repos/my_projects/rock_paper_scissors/images/rock.jpeg");
        paperImage = new ImageIcon("E:/repos/my_projects/rock_paper_scissors/images/paper.jpeg");
        scissorsImage = new ImageIcon("E:/repos/my_projects/rock_paper_scissors/images/scissors.jpeg");
        imageArray = new ImageIcon[] { rockImage, paperImage, scissorsImage };

        random = new Random();
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");
        randomImageLabel = new JLabel();
        userImageLabel = new JLabel();

        userPointsLabel = new JLabel("User: ");
        pcPointsLabel = new JLabel("Pc: ");
        resultLabel = new JLabel();

        rockPaperScissors = new RockPaperScissors();

        pcPoints = 0;
        userPoints = 0;
    }

    public void createGui() {

        frame.setLayout(cardLayout);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(initialPanel, "InitialPanel");
        frame.add(gamePanel, "GamePanel");

        randomImageLabel.setBounds(50, 10, 500, 500);

        userImageLabel.setBounds(450, 10, 500, 500);

        rockButton.setBounds(240, 500, 100, 40);
        rockButton.setFocusable(false);
        rockButton.addActionListener(e -> {
            userImageLabel.setIcon(imageArray[0]);
            choice(0);
        });

        paperButton.setBounds(360, 500, 100, 40);
        paperButton.setFocusable(false);
        paperButton.addActionListener(e -> {
            userImageLabel.setIcon(imageArray[1]);
            choice(1);
        });

        scissorsButton.setBounds(480, 500, 100, 40);
        scissorsButton.setFocusable(false);
        scissorsButton.addActionListener(e -> {
            userImageLabel.setIcon(imageArray[2]);
            choice(2);
        });

        resultLabel.setBounds(300, 0, 300, 100);
        resultLabel.setFont(font);
        resultLabel.setForeground(color);

        userPointsLabel.setBounds(0, 690, 200, 100);
        userPointsLabel.setFont(font);
        userPointsLabel.setForeground(color);

        pcPointsLabel.setBounds(670, 690, 100, 100);
        pcPointsLabel.setFont(font);
        pcPointsLabel.setForeground(color);

        gamePanel.setLayout(null);
        gamePanel.add(randomImageLabel);
        gamePanel.add(userImageLabel);
        gamePanel.add(rockButton);
        gamePanel.add(paperButton);
        gamePanel.add(scissorsButton);
        gamePanel.add(userPointsLabel);
        gamePanel.add(pcPointsLabel);
        gamePanel.add(resultLabel);

        titleLabel.setBounds(150, 75, 600, 400);
        titleLabel.setForeground(color);
        titleLabel.setFont(font);

        startPlayingButton.setBounds(150, 350, 120, 30);
        startPlayingButton.setFocusable(false);
        startPlayingButton.addActionListener(e -> cardLayout.show(frame.getContentPane(), "GamePanel"));

        instructionsButton.setBounds(440, 350, 120, 30);
        instructionsButton.setFocusable(false);
        instructionsButton.addActionListener(e -> showInstructions());

        initialPanel.setLayout(null);
        initialPanel.add(titleLabel);
        initialPanel.add(startPlayingButton);
        initialPanel.add(instructionsButton);

        cardLayout.show(frame.getContentPane(), "InitialPanel");
        frame.setVisible(true);

    }

    public void showInstructions() {
        JOptionPane.showMessageDialog(frame, "Welcome to the popular game rock, paper, scissors." +
                "\nYou are going to be playing against a PC that randomly chooses an option." +
                "\nHope you enjoy and start playing!");
    }

    public void choice(int selectedHand) {

        int randomNumber = random.nextInt(3);
        randomImageLabel.setIcon(imageArray[randomNumber]);
        var result = rockPaperScissors.logic(selectedHand, randomNumber);

        if ( result == GameResult.DRAW) {
            resultLabel.setText("Draw");
        } else if (result == GameResult.WIN) {
            resultLabel.setText("You Won");
            userPoints += 1;
            userPointsLabel.setText("User: " + userPoints);
        } else {
            resultLabel.setText("You Loose");
            pcPoints += 1;
            pcPointsLabel.setText("Pc: " + pcPoints);
        }
    }
}
