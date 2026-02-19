import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ReviewUI extends JFrame {

    public ReviewUI(ArrayList<Question> questions, int attempted) {

        setTitle("Answer Review");
        setSize(700, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // 🔹 Header
        JLabel title = new JLabel("Answer Review", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
        add(title, BorderLayout.NORTH);

        // 🔹 Text Area
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        area.setBackground(new Color(245, 247, 250));
        area.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < attempted; i++) {

            Question q = questions.get(i);

            String userAnswerText = getOptionText(q, q.userAnswer);
            String correctAnswerText = getOptionText(q, q.correct);

            sb.append("Q").append(i + 1).append(". ")
                    .append(q.question).append("\n\n");

            sb.append("Your Answer    : ")
                    .append(userAnswerText).append("\n");

            sb.append("Correct Answer : ")
                    .append(correctAnswerText);

            if (q.userAnswer != null && q.userAnswer.equals(q.correct)) {
                sb.append("   [CORRECT]");

            } else {
                sb.append("   [WRONG]");

            }

            sb.append("\n");
            sb.append("-------------------------------------------------------------\n\n");
        }

        area.setText(sb.toString());

        // 🔹 Scroll Pane Styling
        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private String getOptionText(Question q, String option) {

        if (option == null || option.equals("Not Answered"))
            return "Not Attempted";

        switch (option) {
            case "A": return q.a;
            case "B": return q.b;
            case "C": return q.c;
            case "D": return q.d;
            default: return "Not Attempted";
        }
    }
}
