import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UploadUI extends JFrame implements ActionListener {

    JTextField questionField, aField, bField, cField, dField;
    JComboBox<String> topicBox, correctBox;
    JButton saveBtn,backBtn;

    public UploadUI() {

        setTitle("Upload Question");
        setSize(500, 550);
        setLayout(null);
        JLabel heading = new JLabel("Upload MCQ Question");
        heading.setBounds(0, 5, 500, 30);
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 20));
        heading.setForeground(new Color(45, 72, 140));
        add(heading);


        JLabel topicLabel = new JLabel("Select Topic:");
        topicLabel.setBounds(50, 40, 120, 30);
        add(topicLabel);

        topicBox = new JComboBox<>(new String[]{"Java","DBMS","OS"});
        topicBox.setBounds(180, 40, 150, 30);
        add(topicBox);

        questionField = new JTextField();
        questionField.setBounds(50, 80, 380, 30);
        add(questionField);

        aField = new JTextField();
        bField = new JTextField();
        cField = new JTextField();
        dField = new JTextField();

        aField.setBounds(50, 130, 380, 30);
        bField.setBounds(50, 170, 380, 30);
        cField.setBounds(50, 210, 380, 30);
        dField.setBounds(50, 250, 380, 30);

        add(aField); add(bField); add(cField); add(dField);

        correctBox = new JComboBox<>(new String[]{"A","B","C","D"});
        correctBox.setBounds(180, 300, 100, 30);
        add(correctBox);
        backBtn = new JButton("Back to Main Menu");
        backBtn.setBounds(150, 400, 180, 35);
        add(backBtn);
        backBtn.addActionListener(this);
        saveBtn = new JButton("Save Question");
        saveBtn.setBounds(150, 350, 180, 40);
        add(saveBtn);
        Font inputFont = new Font("SansSerif", Font.PLAIN, 14);
        questionField.setFont(inputFont);
        aField.setFont(inputFont);
        bField.setFont(inputFont);
        cField.setFont(inputFont);
        dField.setFont(inputFont);
        topicBox.setFont(inputFont);
        correctBox.setFont(inputFont);


        saveBtn.addActionListener(this);
        ButtonStyleUtil.style(saveBtn, Color.green,new Color(39, 174, 96));
        ButtonStyleUtil.style(
                backBtn,
                new Color(231, 76, 60),
                new Color(192, 57, 43));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backBtn){
            new MainMenu();
            dispose();
            return;
        }
        if(e.getSource() == saveBtn){

        String question = questionField.getText().trim();
        String optionA = aField.getText().trim();
        String optionB = bField.getText().trim();
        String optionC = cField.getText().trim();
        String optionD = dField.getText().trim();
        String correct = (String) correctBox.getSelectedItem();
        String topic = (String) topicBox.getSelectedItem();

        // 🔹 Validation Section
        if (question.isEmpty() ||
                optionA.isEmpty() ||
                optionB.isEmpty() ||
                optionC.isEmpty() ||
                optionD.isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "All fields must be filled!",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {

            Connection con = DBConnection.getConnection();

            int topicId = 0;

            if (topic.equals("Java")) topicId = 1;
            if (topic.equals("DBMS")) topicId = 2;
            if (topic.equals("OS")) topicId = 3;

            String sql = "INSERT INTO question " +
                    "(topic_id, question, option_a, option_b, option_c, option_d, correct_option) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, topicId);
            ps.setString(2, question);
            ps.setString(3, optionA);
            ps.setString(4, optionB);
            ps.setString(5, optionC);
            ps.setString(6, optionD);
            ps.setString(7, correct);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Question Uploaded Successfully!");

            // Clear fields after successful insert
            questionField.setText("");
            aField.setText("");
            bField.setText("");
            cField.setText("");
            dField.setText("");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }}
}