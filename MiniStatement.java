package banks.management.systems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    String pin;
    JButton button;
    MiniStatement(String pin) {

        this.pin = pin;
        JLabel label1 = new JLabel();
        label1.setBounds(20,140, 400, 250);
        add(label1);

        JLabel label2 = new JLabel();
        label2.setBounds(20,170, 400, 20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20,60, 400, 40);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20,460, 400, 20);
        add(label4);


        try {
            Connect c = new Connect();
            ResultSet resultSet = c.statement.executeQuery("select * from Login where pin = '"+pin+"'");
            while (resultSet.next()) {
                label3.setText("Card Number : "+resultSet.getString("card_number").substring(0,4)+"XXXXXXXX" + resultSet.getString("card_number").substring(12));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }


        try {
            int balance = 0;
            Connect c = new Connect();
            ResultSet resultSet = c.statement.executeQuery("select * from deposit1 where pin = '"+pin+"'");
            while (resultSet.next()) {

                label1.setText(label1.getText() + "<html>"+resultSet.getString("trans_date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("option_type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+ "<br><br><html>");

                if (resultSet.getString("option_type").equals("Deposited")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }

            label4.setText("Your Total Bank Balance is Rs. "+balance);


        } catch (Exception e) {
            e.printStackTrace();
        }

        button = new JButton("EXIT");
        button.setBounds(300, 520, 80, 30);
        button.setFont(new Font("System", Font.BOLD, 15));
        button.setBackground(new Color(8, 105, 138));
        button.setForeground(new Color(240, 243, 250));
        button.addActionListener(this);
        add(button);





        getContentPane().setBackground(new Color(218, 230, 193));
        setLayout(null);
        setSize(700, 600);
        setVisible(true);
        setLocation(300, 30);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new MainClass(pin);

    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
