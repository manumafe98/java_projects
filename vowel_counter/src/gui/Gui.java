package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

public class Gui {
    private JFrame frame;
    private JTextField textField;
    private JLabel titleLabel;
    private JLabel vowelsLabel;
    private Font titleFont;
    private Font numberOfVowelsFont;
    private Color labelColor;
    private Color backgroundColor;
    private Color textBorderColor;
    private LineBorder customBorder;
    private GuiLogic logic;
    private long numberOfVowels;

    public Gui() {
        frame = new JFrame("Vowel Counter");
        textField = new JTextField();
        titleLabel = new JLabel();
        vowelsLabel = new JLabel();
        titleFont = new Font("Arial", Font.BOLD, 25);
        numberOfVowelsFont = new Font("Arial", Font.BOLD, 15);
        backgroundColor = new Color(0xE95793);
        labelColor = new Color(0x610C9F);
        textBorderColor = new Color(0x940B92);
        customBorder = new LineBorder(textBorderColor, 2);
        logic = new GuiLogic();
        numberOfVowels = 0;
        
    }

    public void createGui() {

        titleLabel.setText("Welcome to Vowel Counter");
        titleLabel.setBounds(40, 100, 500, 30);
        titleLabel.setForeground(labelColor);
        titleLabel.setFont(titleFont);

        vowelsLabel.setText("Number of vowels: 0");
        vowelsLabel.setBounds(130, 220, 500, 30);
        vowelsLabel.setForeground(labelColor);
        vowelsLabel.setFont(numberOfVowelsFont);

        textField.setBounds(100, 180, 200, 30);
        textField.setBorder(customBorder);
        textField.setBackground(backgroundColor);
        textField.addActionListener(event -> {
            String word = textField.getText();
            numberOfVowels = logic.checkAmountOfVowels(word);
            vowelsLabel.setText("Number of vowels: "+numberOfVowels);
        });

        frame.setSize(420, 420);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(backgroundColor);
        frame.add(textField);
        frame.add(titleLabel);
        frame.add(vowelsLabel);
    }
}
