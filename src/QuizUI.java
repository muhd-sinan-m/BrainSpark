import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
        import java.sql.*;
        import java.util.*;

public class QuizUI extends JFrame implements ActionListener {

    JLabel questionLabel, timerLabel;
    JRadioButton optA, optB, optC, optD;
    ButtonGroup bg;
    JButton nextBtn,stopBtn;

    ArrayList<Question> questions = new ArrayList<>();
    int index = 0;
    int score = 0;
    int time = 10;
    Timer timer;

    public QuizUI(String topic) {

        setTitle("Quiz - " + topic);
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        timerLabel = new JLabel("Time: 300");
        timerLabel.setBounds(480, 20, 100, 30);
        add(timerLabel);

        questionLabel = new JLabel();
        questionLabel.setBounds(50, 60, 500, 30);
        add(questionLabel);

        optA = new JRadioButton();
        optB = new JRadioButton();
        optC = new JRadioButton();
        optD = new JRadioButton();

        optA.setBounds(50, 110, 500, 30);
        optB.setBounds(50, 150, 500, 30);
        optC.setBounds(50, 190, 500, 30);
        optD.setBounds(50, 230, 500, 30);

        bg = new ButtonGroup();
        bg.add(optA);
        bg.add(optB);
        bg.add(optC);
        bg.add(optD);

        add(optA);
        add(optB);
        add(optC);
        add(optD);
        ButtonStyleUtil.style(optA,new Color(52, 152, 219),new Color(41, 128, 185));
        ButtonStyleUtil.style(optB,new Color(46, 204, 113),new Color(39, 174, 96));
        ButtonStyleUtil.style(optC,new Color(155, 89, 182),new Color(142, 68, 173));
        ButtonStyleUtil.style(optD,new Color(243, 156, 18),new Color(230, 126, 34));

        nextBtn = new JButton("Next");
        nextBtn.setBounds(240, 290, 100, 30);
        add(nextBtn);

        nextBtn.addActionListener(this);
        stopBtn = new JButton("Stop Quiz");
        stopBtn.setBounds(360, 290, 120, 30);
        add(stopBtn);
        stopBtn.addActionListener(this);
        loadQuestions(topic);
        displayQuestion();
        startTimer();
        ButtonStyleUtil.style(nextBtn, Color.green,new Color(39, 174, 96));
        ButtonStyleUtil.style(
               stopBtn,
                new Color(231, 76, 60),
                new Color(192, 57, 43));
        setVisible(true);
    }

    void loadQuestions(String topic) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = """
                SELECT q.* FROM question q
                JOIN topic t ON q.topic_id = t.topic_id
                WHERE t.topic_name = ?
                ORDER BY RAND()
                LIMIT 10
            """;

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, topic);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Question q = new Question();
                q.question = rs.getString("question");
                q.a = rs.getString("option_a");
                q.b = rs.getString("option_b");
                q.c = rs.getString("option_c");
                q.d = rs.getString("option_d");
                q.correct = rs.getString("correct_option");
                questions.add(q);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void displayQuestion() {
        Question q = questions.get(index);

        questionLabel.setText((index + 1) + ". " + q.question);
        optA.setText(q.a);
        optB.setText(q.b);
        optC.setText(q.c);
        optD.setText(q.d);

        bg.clearSelection();
    }

    void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                time--;
                timerLabel.setText("Time: " + time);

                if (time <= 0) {


                    questions.get(index).userAnswer = "Not Answered";

                    index++;

                    if (index < questions.size()) {
                        time = 10;
                        displayQuestion();
                    } else {
                        timer.stop();
                        finishQuiz();
                    }
                }

            }
        });
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == stopBtn) {
           int choice = JOptionPane.showConfirmDialog(this,"Are you sure you want to stop Quiz?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                timer.stop();
                finishQuiz();
            }
        }
        if (e.getSource() == nextBtn) {

            checkAnswer();
            index++;

            if (index < questions.size()) {
                time = 10;
                timerLabel.setText("Time: " + time);
                displayQuestion();
            } else {
                finishQuiz();
            }
        }
    }

    void checkAnswer() {

        Question q = questions.get(index);

        if (optA.isSelected()) q.userAnswer = "A";
        else if (optB.isSelected()) q.userAnswer = "B";
        else if (optC.isSelected()) q.userAnswer = "C";
        else if (optD.isSelected()) q.userAnswer = "D";
        else q.userAnswer = "Not Answered";

        if (q.userAnswer.equals(q.correct)) {
            score++;
        }
    }

    void finishQuiz() {
        timer.stop();
        new ResultUI(score,questions,index);
        dispose();
    }
}

