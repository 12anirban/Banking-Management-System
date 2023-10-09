package banks.management.systems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pin;
    JLabel label2;
    JButton button1;
    BalanceEnquiry(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1000,870,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(135, -160, 1000, 870);
        add(image);

        // Amount deposited ---
        JLabel label1 = new JLabel("Your Current Bank Balance is Rs. ");
        label1.setForeground(Color.YELLOW);
        label1.setFont(new Font("System", Font.BOLD, 15));
        label1.setBounds(200, 300, 350, 40);
        image.add(label1);

        label2 = new JLabel();
        label2.setForeground(Color.CYAN);
        label2.setFont(new Font("System", Font.BOLD, 20));
        label2.setBounds(206, 340, 450, 40);
        image.add(label2);

        button1 = new JButton("BACK");
        button1.setFont(new Font("System", Font.BOLD, 16));
        button1.setBounds(455, 470, 120, 26);
        button1.setForeground(new Color(250, 250, 252));
        button1.setBackground(new Color(5, 115, 8));
        button1.addActionListener(this);
        image.add(button1);

        int balance = 0;
        try {
            Connect c = new Connect();
            ResultSet resultSet = c.statement.executeQuery("select * from deposit1 where pin = '"+pin+"'");
            while (resultSet.next()) {
                if (resultSet.getString("option_type").equals("Deposited")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception E) {
            E.printStackTrace();
        }

        label2.setText(""+balance);

        setLayout(null);
        setSize(1350, 1080);
        setLocation(0, 0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new MainClass(pin);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
