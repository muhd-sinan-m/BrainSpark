import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ManageQuestionsUI extends JFrame implements ActionListener, ItemListener {

    JComboBox<String> topicBox;
    JTable questionTable;
    DefaultTableModel tableModel;
    JButton deleteBtn, backBtn, refreshBtn;
    String idColumnName;

    public ManageQuestionsUI() {
        setTitle("Manage Questions");
        setSize(900, 520);
        setLayout(null);

        JLabel heading = new JLabel("Manage Questions");
        heading.setBounds(0, 5, 900, 30);
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 20));
        heading.setForeground(new Color(45, 72, 140));
        add(heading);

        JLabel topicLabel = new JLabel("Select Topic:");
        topicLabel.setBounds(30, 45, 100, 25);
        add(topicLabel);

        topicBox = new JComboBox<>(new String[]{"Java", "DBMS", "OS"});
        topicBox.setBounds(140, 45, 140, 25);
        add(topicBox);
        topicBox.addItemListener(this);

        tableModel = new DefaultTableModel();
        questionTable = new JTable(tableModel);
        questionTable.setRowHeight(24);
        JScrollPane scrollPane = new JScrollPane(questionTable);
        scrollPane.setBounds(30, 85, 820, 320);
        add(scrollPane);

        deleteBtn = new JButton("Delete Selected");
        deleteBtn.setBounds(220, 420, 160, 35);
        add(deleteBtn);

        refreshBtn = new JButton("Refresh");
        refreshBtn.setBounds(400, 420, 120, 35);
        add(refreshBtn);

        backBtn = new JButton("Back to Main Menu");
        backBtn.setBounds(540, 420, 180, 35);
        add(backBtn);

        deleteBtn.addActionListener(this);
        refreshBtn.addActionListener(this);
        backBtn.addActionListener(this);

        ButtonStyleUtil.style(deleteBtn, new Color(231, 76, 60), new Color(192, 57, 43));
        ButtonStyleUtil.style(refreshBtn, new Color(52, 152, 219), new Color(41, 128, 185));
        ButtonStyleUtil.style(backBtn, new Color(243, 156, 18), new Color(230, 126, 34));

        loadQuestions();
        setVisible(true);
    }

    private void loadQuestions() {
        String topic = (String) topicBox.getSelectedItem();
        if (topic == null) {
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            String sql = """
                SELECT q.* FROM question q
                JOIN topic t ON q.topic_id = t.topic_id
                WHERE t.topic_name = ?
                ORDER BY q.question
            """;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, topic);
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData meta = rs.getMetaData();
            if (idColumnName == null) {
                idColumnName = resolveIdColumn(meta);
            }

            boolean hasId = idColumnName != null;
            if (hasId) {
                tableModel.setColumnIdentifiers(new String[]{"ID", "Question", "A", "B", "C", "D", "Correct"});
            } else {
                tableModel.setColumnIdentifiers(new String[]{"Question", "A", "B", "C", "D", "Correct"});
            }
            tableModel.setRowCount(0);
            configureQuestionColumnWidth(hasId);

            while (rs.next()) {
                if (hasId) {
                    tableModel.addRow(new Object[]{
                            rs.getObject(idColumnName),
                            rs.getString("question"),
                            rs.getString("option_a"),
                            rs.getString("option_b"),
                            rs.getString("option_c"),
                            rs.getString("option_d"),
                            rs.getString("correct_option")
                    });
                } else {
                    tableModel.addRow(new Object[]{
                            rs.getString("question"),
                            rs.getString("option_a"),
                            rs.getString("option_b"),
                            rs.getString("option_c"),
                            rs.getString("option_d"),
                            rs.getString("correct_option")
                    });
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String resolveIdColumn(ResultSetMetaData meta) throws SQLException {
        for (int i = 1; i <= meta.getColumnCount(); i++) {
            String name = meta.getColumnName(i);
            String lower = name.toLowerCase();
            if (lower.contains("id") && !lower.equals("topic_id")) {
                return name;
            }
        }
        return null;
    }

    private void configureQuestionColumnWidth(boolean hasId) {
        int questionCol = hasId ? 1 : 0;
        if (questionTable.getColumnModel().getColumnCount() > questionCol) {
            questionTable.getColumnModel().getColumn(questionCol).setPreferredWidth(380);
        }
    }

    private int resolveTopicId(String topic) {
        if ("Java".equals(topic)) return 1;
        if ("DBMS".equals(topic)) return 2;
        if ("OS".equals(topic)) return 3;
        return 0;
    }

    private void deleteSelectedQuestion() {
        int row = questionTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Select a question to delete.");
            return;
        }

        int choice = JOptionPane.showConfirmDialog(
                this,
                "Delete selected question?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
        );
        if (choice != JOptionPane.YES_OPTION) {
            return;
        }

        String topic = (String) topicBox.getSelectedItem();
        if (topic == null) {
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            if (idColumnName != null) {
                Object idValue = tableModel.getValueAt(row, 0);
                String sql = "DELETE FROM question WHERE " + idColumnName + " = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setObject(1, idValue);
                ps.executeUpdate();
            } else {
                int topicId = resolveTopicId(topic);
                String sql = """
                    DELETE FROM question
                    WHERE topic_id = ?
                      AND question = ?
                      AND option_a = ?
                      AND option_b = ?
                      AND option_c = ?
                      AND option_d = ?
                      AND correct_option = ?
                """;
                PreparedStatement ps = con.prepareStatement(sql);
                int colOffset = 0;
                ps.setInt(1, topicId);
                ps.setString(2, (String) tableModel.getValueAt(row, colOffset));
                ps.setString(3, (String) tableModel.getValueAt(row, colOffset + 1));
                ps.setString(4, (String) tableModel.getValueAt(row, colOffset + 2));
                ps.setString(5, (String) tableModel.getValueAt(row, colOffset + 3));
                ps.setString(6, (String) tableModel.getValueAt(row, colOffset + 4));
                ps.setString(7, (String) tableModel.getValueAt(row, colOffset + 5));
                ps.executeUpdate();
            }
            loadQuestions();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteBtn) {
            deleteSelectedQuestion();
        }
        if (e.getSource() == refreshBtn) {
            loadQuestions();
        }
        if (e.getSource() == backBtn) {
            new MainMenu();
            dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            loadQuestions();
        }
    }
}
