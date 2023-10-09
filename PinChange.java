package banks.management.systems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JButton button1, button2;
    JPasswordField password1, password2;
    String pin;

    PinChange (String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1000,870,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(135, -160, 1000, 870);
        add(image);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.YELLOW);
        label1.setFont(new Font("System", Font.BOLD, 20));
        label1.setBounds(275, 280, 400, 40);
        image.add(label1);


        JLabel label2 = new JLabel("ENTER NEW PIN : ");
        label2.setForeground(Color.GREEN);
        label2.setFont(new Font("System", Font.BOLD, 15));
        label2.setBounds(200, 330, 350, 40);
        image.add(label2);

        password1 = new JPasswordField();
        password1.setBounds(380, 336, 150, 30);
        password1.setFont(new Font("Courier", Font.BOLD, 18));
        password1.setForeground(new Color(204, 204, 194));
        password1.setBackground(new Color(26, 13, 102));
        image.add(password1);

        JLabel label3 = new JLabel("RE-ENTER NEW PIN : ");
        label3.setForeground(Color.GREEN);
        label3.setFont(new Font("System", Font.BOLD, 15));
        label3.setBounds(200, 380, 350, 40);
        image.add(label3);

        password2 = new JPasswordField();
        password2.setBounds(380, 386, 150, 30);
        password2.setFont(new Font("Courier", Font.BOLD, 18));
        password2.setForeground(new Color(204, 204, 194));
        password2.setBackground(new Color(26, 13, 102));
        image.add(password2);

        button1 = new JButton("CHANGE");
        button1.setFont(new Font("System", Font.BOLD, 16));
        button1.setBounds(455, 470, 120, 26);
        button1.setForeground(new Color(250, 250, 252));
        button1.setBackground(new Color(23, 145, 181));
        button1.addActionListener(this);
        image.add(button1);

        button2 = new JButton("CANCEL");
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
        try {
            String p1 = password1.getText();
            String p2 = password2.getText();

            if (!p1.equals(p2)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            if (e.getSource()==button1) {
                if (password1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter the new PIN");
                    return;
                }
                if (password2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-enter the new PIN");
                    return;
                }
                Connect c = new Connect();
                String q1 = "update deposit1 set pin = '"+p1+"' where pin = '"+pin+"'";
                String q2 = "update Login set pin = '"+p1+"' where pin = '"+pin+"'";
                String q3 = "update registerthree set pin = '"+p1+"' where pin = '"+pin+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "Your PIN has changed successfully");
                setVisible(false);
                new MainClass(pin);

            } else if (e.getSource()==button2) {
                new MainClass(pin);
                setVisible(false);
            }

        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
