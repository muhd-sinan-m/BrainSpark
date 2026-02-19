import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MainMenu extends JFrame implements ActionListener {

    JButton javaBtn, dbmsBtn, osBtn, uploadBtn, manageBtn;

    public MainMenu() {

        setTitle("MCQ Quiz System");
        setSize(420, 430);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel htitle = new JLabel("BrainSpark - MCQ Quiz System");
        htitle.setBounds(38, 10, 400, 30);
        htitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        htitle.setForeground(new Color(45, 72, 140));
        add(htitle);

        JLabel title = new JLabel("Select Topic");
        title.setBounds(150, 40, 150, 30);
        title.setFont(new Font("Segoe UI", Font.BOLD, 15));
        title.setForeground(new Color(30, 30, 30));
        add(title);

        javaBtn = new JButton("Java");
        dbmsBtn = new JButton("DBMS");
        osBtn = new JButton("OS");
        uploadBtn = new JButton("Upload Questions");
        manageBtn = new JButton("Manage Questions");

        javaBtn.setBounds(120, 80, 150, 30);
        dbmsBtn.setBounds(120, 120, 150, 30);
        osBtn.setBounds(120, 160, 150, 30);
        uploadBtn.setBounds(100, 220, 200, 35);
        manageBtn.setBounds(100, 265, 200, 35);

        add(javaBtn);
        add(dbmsBtn);
        add(osBtn);
        add(uploadBtn);
        add(manageBtn);

        javaBtn.addActionListener(this);
        dbmsBtn.addActionListener(this);
        osBtn.addActionListener(this);
        uploadBtn.addActionListener(this);
        manageBtn.addActionListener(this);

        ButtonStyleUtil.style(javaBtn, new Color(52, 152, 219), new Color(41, 128, 185));
        ButtonStyleUtil.style(dbmsBtn, new Color(46, 204, 113), new Color(39, 174, 96));
        ButtonStyleUtil.style(osBtn, new Color(155, 89, 182), new Color(142, 68, 173));
        ButtonStyleUtil.style(uploadBtn, new Color(243, 156, 18), new Color(230, 126, 34));
        ButtonStyleUtil.style(manageBtn, new Color(26, 188, 156), new Color(22, 160, 133));


        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == javaBtn) {
            new QuizUI("Java");
            dispose();
        }

        if (e.getSource() == dbmsBtn) {
            new QuizUI("DBMS");
            dispose();
        }

        if (e.getSource() == osBtn) {
            new QuizUI("OS");
            dispose();
        }

        if (e.getSource() == uploadBtn) {
            new UploadUI();
        }
        if (e.getSource() == manageBtn) {
            new ManageQuestionsUI();
            dispose();
        }

    }


    public static void main(String[] args) {

        new MainMenu();
    }
}
