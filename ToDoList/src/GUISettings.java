import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISettings extends JFrame implements ActionListener {

    private JPanel taskPanel, taskComponentPanel;

    public GUISettings(){
        super("To Do List Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(CommonConstants.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        this.getContentPane().setBackground(Color.gray);

        addGuiComponents();
    }

    private void addGuiComponents(){
        // ==== BANNER TEXT ====
        JLabel bannerLabel = new JLabel("To Do List");
        bannerLabel.setForeground(Color.white);
        bannerLabel.setFont(new Font("SansSerif", Font.PLAIN, 32));
        bannerLabel.setBounds(
                (CommonConstants.GUI_SIZE.width - bannerLabel.getPreferredSize().width)/2,
                15,
                CommonConstants.BANNER_SIZE.width,
                CommonConstants.BANNER_SIZE.height
        );

        // ==== TASK PANEL ====
        taskPanel = new JPanel();

        // ==== TASK COMPONENT PANEL ====
        taskComponentPanel = new JPanel();
        taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel, BoxLayout.Y_AXIS));
        taskPanel.add(taskComponentPanel);

        // ==== JSCROLLPANE ====
        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setBounds(8, 70, CommonConstants.TASK_PANEL_SIZE.width, CommonConstants.TASK_PANEL_SIZE.height);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // ==== ADD TASK BUTTON ====
        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.setBounds(-5, CommonConstants.GUI_SIZE.height - 88,
                CommonConstants.ADD_TASK_BUTTON_SIZE.width, CommonConstants.ADD_TASK_BUTTON_SIZE.height);
        addTaskButton.addActionListener(this);
        addTaskButton.setBackground(Color.green.darker());
        addTaskButton.setForeground(Color.white);
        addTaskButton.setFocusPainted(false);


        // ==== ADD TO FRAME ====
        this.getContentPane().add(bannerLabel);
        this.getContentPane().add(scrollPane);
        this.getContentPane().add(addTaskButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equalsIgnoreCase("Add Task")){

            // ==== TASK CREATION ====
            TaskComponent taskComponent = new TaskComponent(taskComponentPanel);
            taskComponentPanel.add(taskComponent);
            taskComponent.getTaskField().requestFocus();
            repaint();
            revalidate();
        }

    }
}
