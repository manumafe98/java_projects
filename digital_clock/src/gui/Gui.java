package gui;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gui {
    private JFrame frame;
    private JLabel clockLabel;
    private JLabel dayLabel;
    private Font clockFont;
    private Font dayFont;
    private LocalDateTime dateObject;
    private DateTimeFormatter timeFormatter;
    private DateTimeFormatter dayFormatter;
    private String time;
    private String day;
    private Timer timer;

    public Gui() {
        frame = new JFrame("Digital Clock");
        clockLabel = new JLabel();
        dayLabel = new JLabel();
        clockFont = new Font("Arial", Font.BOLD, 50);
        dayFont = new Font("Arial", Font.PLAIN, 15);

        dateObject = LocalDateTime.now();
        timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        dayFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        time = dateObject.format(timeFormatter);
        day = dateObject.format(dayFormatter);
        timer = new Timer(1000, (e) -> updateLabel());
        timer.start();

    }

    private void updateLabel() {
        LocalDateTime currentTime = LocalDateTime.now();
        String time = currentTime.format(timeFormatter);
        clockLabel.setText(time);
    }

    public void createGui() {

        clockLabel.setBounds(215, 150, 300, 100);
        clockLabel.setText(time);
        clockLabel.setForeground(Color.WHITE);
        clockLabel.setFont(clockFont);

        dayLabel.setBounds(275, 190, 150, 100);
        dayLabel.setText(day);
        dayLabel.setForeground(Color.WHITE);
        dayLabel.setFont(dayFont);

        frame.getContentPane().setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 420);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(dayLabel);
        frame.add(clockLabel);

    }
}
