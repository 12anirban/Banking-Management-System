package banks.management.systems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    String pin;
    TextField textField;
    JButton button1, button2;
    Withdrawal(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1000,870,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(135, -160, 1000, 870);
        add(image);

        // Amount deposited ---
        JLabel label1 = new JLabel("(Maximum Withdrawal is Rs. 10,000)");
        label1.setForeground(Color.YELLOW);
        label1.setFont(new Font("System", Font.BOLD, 15));
        label1.setBounds(240, 300, 350, 40);
        image.add(label1);

        JLabel label2 = new JLabel("ENTER YOUR AMOUNT");
        label2.setForeground(Color.CYAN);
        label2.setFont(new Font("System", Font.BOLD, 18));
        label2.setBounds(270, 340, 450, 40);
        image.add(label2);


        textField = new TextField();
        textField.setBounds(272, 390, 200, 40);
        textField.setFont(new Font("Courier", Font.BOLD, 30));
        textField.setForeground(new Color(204, 204, 194));
        textField.setBackground(new Color(33, 4, 196));
        image.add(textField);


        button1 = new JButton("WITHDRAW");
        button1.setFont(new Font("System", Font.BOLD, 16));
        button1.setBounds(445, 471, 130, 26);
        button1.setForeground(new Color(201, 201, 203));
        button1.setBackground(new Color(1, 86, 4));
        button1.addActionListener(this);
        image.add(button1);

        button2 = new JButton("BACK");
        button2.setFont(new Font("System", Font.BOLD, 16));
        button2.setBounds(445, 504, 130, 26);
        button2.setForeground(new Color(201, 201, 203));
        button2.setBackground(new Color(173, 11, 1));
        button2.addActionListener(this);
        image.add(button2);





        setLayout(null);
        setSize(1350, 1080);
        setLocation(0, 0);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==button1) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                }else {
                    Connect c = new Connect();
                    ResultSet resultSet = c.statement.executeQuery("select * from deposit1 where pin = '"+pin+"'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("option_type").equals("Deposited")) {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                        }else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance in Your Account");
                    return;
                    }
                    c.statement.executeUpdate("insert into deposit1 values('"+pin+"', '"+date+"', 'Withdrawal', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" is debited successfully.");
                    setVisible(false);
                    new MainClass(pin);
                }

            }catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource()==button2) {
            setVisible(false);
            new MainClass(pin);
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
