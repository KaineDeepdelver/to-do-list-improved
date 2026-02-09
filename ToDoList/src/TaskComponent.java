import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskComponent extends JPanel implements ActionListener {

    private JCheckBox checkBox;
    private JTextPane taskField;
    private JButton deleteButton;

    public JTextPane getTaskField() {
        return taskField;
    }

    private JPanel mainPanel;

    public TaskComponent(JPanel mainPanel) {
        this.mainPanel = mainPanel;

        // ==== TASK FIELD ====
        taskField = new JTextPane();
        taskField.setPreferredSize(CommonConstants.TASK_FIELD_SIZE);
        taskField.setContentType("text/html");

        // ==== CHECKBOX ====
        checkBox = new JCheckBox();
        checkBox.setPreferredSize(CommonConstants.CHECKBOX);
        checkBox.setOpaque(false);
        checkBox.addActionListener(this);

        // ==== DELETE BUTTON ====
        deleteButton = new JButton("X");
        deleteButton.setPreferredSize(CommonConstants.DELETE_BUTTON_SIZE);
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.white);
        deleteButton.addActionListener(this);
        deleteButton.setFocusPainted(false);

        // ==== FEATURE INJECTION ====
        add(checkBox);
        add(taskField);
        add(deleteButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (checkBox.isSelected()) {

            // ==== REPLACES ALL HTML TAGS TO EMPTY STRING TO GRAB THE MAIN TEXT ====
            String taskText = taskField.getText().replaceAll("<[^>]*>", "");

            // ==== ADD STRIKETHROUGH TEXT ====
            taskField.setText("<html><s>" + taskText + "</s></html>");
        } else if (!checkBox.isSelected()) {
            String taskText = taskField.getText().replaceAll("<[^>]*>", "");

            taskField.setText(taskText);
        }

        if (e.getActionCommand().equalsIgnoreCase("X")) {

            mainPanel.remove(this);
            mainPanel.repaint();
            mainPanel.revalidate();
        }
    }
}
