package banks.management.systems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton button1, button2;
    Deposit(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1000,870,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(135, -160, 1000, 870);
        add(image);

        // Amount deposited ---
        JLabel label1 = new JLabel("ENTER YOUR DEPOSIT AMOUNT");
        label1.setForeground(Color.YELLOW);
        label1.setFont(new Font("System", Font.BOLD, 15));
        label1.setBounds(250, 300, 450, 40);
        image.add(label1);

        textField = new TextField();
        textField.setBounds(272, 360, 200, 40);
        textField.setFont(new Font("Courier", Font.BOLD, 30));
        textField.setForeground(new Color(204, 204, 194));
        textField.setBackground(new Color(33, 4, 196));
        image.add(textField);


        button1 = new JButton("DEPOSIT");
        button1.setFont(new Font("System", Font.BOLD, 16));
        button1.setBounds(455, 470, 120, 26);
        button1.setForeground(new Color(250, 250, 252));
        button1.setBackground(new Color(5, 115, 8));
        button1.addActionListener(this);
        image.add(button1);

        button2 = new JButton("BACK");
        button2.setFont(new Font("System", Font.BOLD, 16));
        button2.setBounds(455, 503, 120, 26);
        button2.setForeground(new Color(250, 250, 252));
        button2.setBackground(new Color(254, 15, 0));
        button2.addActionListener(this);
        image.add(button2);




        setLayout(null);
        setSize(1350, 1080);
        setLocation(0, 0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Date date = new Date();
            String amount = textField.getText();
            if (e.getSource()==button1) {
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter the Amount");
                }
                else {
                    Connect con5 = new Connect();
                    String q5 = "insert into deposit1 values('"+pin+"', '"+date+"', 'Deposited', '"+amount+"')";
                    con5.statement.executeUpdate(q5);
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" is successfully deposited");
                    setVisible(false);
                    new MainClass(pin);
                }
            }else if (e.getSource()==button2) {
                setVisible(false);
                new MainClass(pin);
            }
        }catch (Exception E) {
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
