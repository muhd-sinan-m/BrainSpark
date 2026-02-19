import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ResultUI extends JFrame implements ActionListener {

    JButton menuBtn, exitBtn,viewBtn;
    ArrayList<Question> questions;
    int att;
    public ResultUI(int score, ArrayList<Question> questions,int attempted) {

        setTitle("Quiz Result");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel scoreTitle = new JLabel("Quiz Result");
        scoreTitle.setBounds(0, 20, 400, 30);
        scoreTitle.setHorizontalAlignment(JLabel.CENTER);
        scoreTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        scoreTitle.setForeground(new Color(45, 72, 140));
        add(scoreTitle);

        JLabel scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setBounds(0, 60, 400, 40);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        scoreLabel.setForeground(new Color(46, 204, 113)); // green score
        add(scoreLabel);

        this.questions = questions;
        this.att = attempted;

        menuBtn = new JButton("Main Menu");
        menuBtn.setBounds(70, 170, 120, 35);
        add(menuBtn);
        viewBtn = new JButton("View Answers");
        viewBtn.setBounds(130, 130, 150, 30);
        add(viewBtn);
        exitBtn = new JButton("Exit");
        exitBtn.setBounds(220, 170, 100, 35);
        add(exitBtn);

        menuBtn.addActionListener(this);
        viewBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        ButtonStyleUtil.style(viewBtn, new Color(155, 89, 182),new Color(142, 68, 173));
        ButtonStyleUtil.style(
                menuBtn,
                new Color(52, 152, 219),
                new Color(41, 128, 185));
        ButtonStyleUtil.style(exitBtn,new Color(231, 76, 60),new Color(192, 57, 43));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == menuBtn) {
            new MainMenu();
            dispose();
        }
        if (e.getSource() == viewBtn) {
            new ReviewUI(questions,att);
        }
        if (e.getSource() == exitBtn) {
            System.exit(0);
        }
    }
}