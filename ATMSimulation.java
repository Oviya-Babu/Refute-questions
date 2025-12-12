import javax.swing.*;

public class ATMSimulation {
    // Initial balance
    private static int balance = 10000;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ATM Simulation");

        JLabel pinLabel = new JLabel("Enter PIN:");
        pinLabel.setBounds(50, 50, 100, 30);

        JPasswordField pinField = new JPasswordField();
        pinField.setBounds(150, 50, 150, 30);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(150, 100, 100, 30);

        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(50, 150, 300, 30);

        // ✅ Login button logic
        loginBtn.addActionListener(e -> {
            String pin = new String(pinField.getPassword());
            if (pin.equals("1234")) {   // correct PIN
                frame.getContentPane().removeAll(); // clear login screen
                showATMOptions(frame);
                frame.revalidate();
                frame.repaint();
            } else {
                statusLabel.setText("Invalid PIN! Try again.");
            }
        });

        frame.add(pinLabel);
        frame.add(pinField);
        frame.add(loginBtn);
        frame.add(statusLabel);

        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // ✅ Show ATM options after successful login
    private static void showATMOptions(JFrame frame) {
        JLabel menuLabel = new JLabel("Select an option:");
        menuLabel.setBounds(50, 30, 200, 30);

        JButton checkBalBtn = new JButton("Check Balance");
        checkBalBtn.setBounds(50, 80, 150, 30);

        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBounds(50, 130, 150, 30);

        JButton withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(50, 180, 150, 30);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(50, 230, 300, 30);

        // ✅ Check Balance
        checkBalBtn.addActionListener(e -> 
            resultLabel.setText("Balance: ₹" + balance)
        );

        // ✅ Deposit
        depositBtn.addActionListener(e -> {
            String amtStr = JOptionPane.showInputDialog(frame, "Enter amount to deposit:");
            try {
                int amt = Integer.parseInt(amtStr);
                balance += amt;
                resultLabel.setText("Deposited ₹" + amt + ". New Balance: ₹" + balance);
            } catch (Exception ex) {
                resultLabel.setText("Invalid input!");
            }
        });

        // ✅ Withdraw
        withdrawBtn.addActionListener(e -> {
            String amtStr = JOptionPane.showInputDialog(frame, "Enter amount to withdraw:");
            try {
                int amt = Integer.parseInt(amtStr);
                if (amt <= balance) {
                    balance -= amt;
                    resultLabel.setText("Withdrew ₹" + amt + ". New Balance: ₹" + balance);
                } else {
                    resultLabel.setText("Insufficient Balance!");
                }
            } catch (Exception ex) {
                resultLabel.setText("Invalid input!");
            }
        });

        frame.add(menuLabel);
        frame.add(checkBalBtn);
        frame.add(depositBtn);
        frame.add(withdrawBtn);
        frame.add(resultLabel);
    }
}