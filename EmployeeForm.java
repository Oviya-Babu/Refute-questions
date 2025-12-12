import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EmployeeForm {
    public static void main(String[] args) {
        // Frame
        JFrame frame = new JFrame("Employee Details");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel for form inputs
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel deptLabel = new JLabel("Department:");
        JTextField deptField = new JTextField();

        JLabel salaryLabel = new JLabel("Salary:");
        JTextField salaryField = new JTextField();

        JButton addButton = new JButton("Add Employee");

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(deptLabel);
        formPanel.add(deptField);
        formPanel.add(salaryLabel);
        formPanel.add(salaryField);
        formPanel.add(new JLabel()); // empty placeholder
        formPanel.add(addButton);

        // Table for displaying employees
        String[] columnNames = {"Name", "Department", "Salary"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Add form and table to frame
        frame.add(formPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Button action - using Lambda
        addButton.addActionListener((ActionEvent e) -> {
            String name = nameField.getText().trim();
            String dept = deptField.getText().trim();
            String salary = salaryField.getText().trim();

            if (name.isEmpty() || dept.isEmpty() || salary.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields!");
            } else {
                tableModel.addRow(new Object[]{name, dept, salary});

                // Clear inputs
                nameField.setText("");
                deptField.setText("");
                salaryField.setText("");
            }
        });

        // Show frame
        frame.setVisible(true);
    }
}
