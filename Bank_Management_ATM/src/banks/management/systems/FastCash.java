package banks.management.systems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    String pin;
    JButton b1, b2, b3, b4, b5, b6, b7;

    FastCash(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1000,870,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(135, -160, 1000, 870);
        add(image);

        JLabel label1 = new JLabel("PLEASE SELECT WITHDRAWAL AMOUNT");
        label1.setForeground(Color.ORANGE);
        label1.setFont(new Font("System", Font.BOLD, 18));
        label1.setBounds(189, 300, 450, 40);
        image.add(label1);

        b1 = new JButton("Rs. 2000");
        b1.setFont(new Font("System", Font.BOLD, 15));
        b1.setBounds(405, 404, 170, 26);
        b1.setForeground(new Color(250, 250, 252));
        b1.setBackground(new Color(42, 133, 156));
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Rs. 5000");
        b2.setFont(new Font("System", Font.BOLD, 15));
        b2.setBounds(405, 437, 170, 26);
        b2.setForeground(new Color(250, 250, 252));
        b2.setBackground(new Color(42, 133, 156));
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("Rs. 10000");
        b3.setFont(new Font("System", Font.BOLD, 15));
        b3.setBounds(405, 470, 170, 26);
        b3.setForeground(new Color(250, 250, 252));
        b3.setBackground(new Color(42, 133, 156));
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("Rs. 100");
        b4.setFont(new Font("System", Font.BOLD, 15));
        b4.setBounds(173, 404, 170, 26);
        b4.setForeground(new Color(250, 250, 252));
        b4.setBackground(new Color(42, 133, 156));
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("Rs.500");
        b5.setFont(new Font("System", Font.BOLD, 15));
        b5.setBounds(173, 437, 170, 26);
        b5.setForeground(new Color(250, 250, 252));
        b5.setBackground(new Color(42, 133, 156));
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("Rs.1000");
        b6.setFont(new Font("System", Font.BOLD, 15));
        b6.setBounds(173, 470, 170, 26);
        b6.setForeground(new Color(250, 250, 252));
        b6.setBackground(new Color(42, 133, 156));
        b6.addActionListener(this);
        image.add(b6);

        b7 = new JButton("Back");
        b7.setFont(new Font("System", Font.BOLD, 15));
        b7.setBounds(405, 503, 170, 26);
        b7.setForeground(new Color(250, 250, 252));
        b7.setBackground(new Color(42, 133, 156));
        b7.addActionListener(this);
        image.add(b7);




        setLayout(null);
        setSize(1350, 1080);
        setLocation(0, 0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b7) {
            setVisible(false);
            new MainClass(pin);
        } else {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Connect c = new Connect();
            Date date = new Date();
            try {
                ResultSet resultSet = c.statement.executeQuery("select * from deposit1 where pin = '"+pin+"'");
                int balance = 0;
                while (resultSet.next()) {
                    if (resultSet.getString("option_type").equals("Deposited")) {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                } String num = "17";

                if (e.getSource()!=b7 && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                c.statement.executeUpdate("insert into deposit1 values('"+pin+"', '"+date+"', 'Withdrawal', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" is debited successfully.");

            }catch (Exception E) {
                E.printStackTrace();
            }
            setVisible(false);
            new MainClass(pin);
        }


    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
