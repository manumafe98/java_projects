package gui;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gui {
    private JFrame frame;
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
    
    public Gui() {
        frame = new JFrame("Rock, Paper, Scissors");
        random = new Random();

        rockImage = new ImageIcon("E:/Java Projects/rock_paper_scissors/images/rock.jpeg");
        paperImage = new ImageIcon("E:/Java Projects/rock_paper_scissors/images/paper.jpeg");
        scissorsImage = new ImageIcon("E:/Java Projects/rock_paper_scissors/images/scissors.jpeg");
        imageArray = new ImageIcon[3];

        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");
        
        imageArray[0] = rockImage;
        imageArray[1] = paperImage;
        imageArray[2] = scissorsImage;

        randomImageLabel = new JLabel();
        userImageLabel = new JLabel();

    }

    public void createGui() {
        //randomImageLabel.setBounds(0, 0, 500, 500);
        //randomImageLabel.setIcon(imageArray[random.nextInt(3)]);
        userImageLabel.setBounds(0, 0, 500, 500);

        rockButton.setBounds(0, 500, 100, 50);
        rockButton.setFocusable(false);
        rockButton.addActionListener(e -> userImageLabel.setIcon(imageArray[0]));

        paperButton.setBounds(120, 500, 100, 50);
        paperButton.setFocusable(false);
        paperButton.addActionListener(e -> userImageLabel.setIcon(imageArray[1]));

        scissorsButton.setBounds(240, 500, 100, 50);
        scissorsButton.setFocusable(false);
        scissorsButton.addActionListener(e -> userImageLabel.setIcon(imageArray[2]));


        frame.setLayout(null);
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //frame.add(randomImageLabel);
        frame.add(userImageLabel);
        frame.add(rockButton);
        frame.add(paperButton);
        frame.add(scissorsButton);

    }
}
