package banks.management.systems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    JTextField textCard, textHolder;
    JComboBox comboBox1;
    JCheckBox c1, c2, c3, c4;
    JButton submit, cancel;
    String formNo;
    Signup3(String formNo) {
        this.formNo = formNo;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(160,130,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(320, 10, 160, 130);
        add(image);

        // Application No ---
        JLabel l0 = new JLabel("Application No: ");
        l0.setBounds(580, 10, 500, 30);
        l0.setFont(new Font("AvantGarde", Font.BOLD, 20));
        l0.setForeground(Color.white);
        add(l0);

        JLabel labelFNo = new JLabel(formNo);
        labelFNo.setBounds(760, 10, 300, 30);
        labelFNo.setFont(new Font("AvantGarde", Font.BOLD, 20));
        labelFNo.setForeground(Color.white);
        add(labelFNo);

        // Page No ---
        JLabel l1 = new JLabel("Page No: 3");
        l1.setBounds(610, 60, 500, 30);
        l1.setFont(new Font("AvantGarde", Font.BOLD, 17));
        l1.setForeground(Color.white);
        add(l1);

        // Account Details
        JLabel l2 = new JLabel("Account Details");
        l2.setBounds(20, 130, 600, 40);
        l2.setFont(new Font("AvantGarde", Font.BOLD, 20));
        l2.setForeground(Color.white);
        add(l2);

        // Account Type ---
        JLabel labelType = new JLabel("Account Type: ");
        labelType.setBounds(40, 200, 600, 40);
        labelType.setFont(new Font("AvantGarde", Font.BOLD, 15));
        labelType.setForeground(Color.white);
        add(labelType);

        String [] AccType = {"Savings", "Current", "Business"};
        comboBox1 = new JComboBox(AccType);
        comboBox1.setFont(new Font("RaleWay", Font.BOLD, 15));
        comboBox1.setBounds(240, 206, 500, 30);
        add(comboBox1);


        // Account Holder Name ---
        JLabel labelHolder = new JLabel("Account Holder: ");
        labelHolder.setBounds(40, 250, 600, 40);
        labelHolder.setFont(new Font("AvantGarde", Font.BOLD, 15));
        labelHolder.setForeground(Color.white);
        add(labelHolder);

        textHolder = new JTextField();
        textHolder.setBounds(240, 256, 500, 30);
        textHolder.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(textHolder);

        // Card Number ---
        JLabel labelCard = new JLabel("Card No: ");
        labelCard.setBounds(40, 300, 600, 40);
        labelCard.setFont(new Font("AvantGarde", Font.BOLD, 15));
        labelCard.setForeground(Color.white);
        add(labelCard);

        JLabel l3 = new JLabel("XXXX-XXXX-XXXX-4531");
        l3.setBounds(240, 300, 600, 40);
        l3.setFont(new Font("AvantGarde", Font.BOLD, 15));
        l3.setForeground(Color.white);
        add(l3);

        JLabel l4 = new JLabel("(It appears 16 digits number)");
        l4.setBounds(40, 330, 600, 40);
        l4.setFont(new Font("AvantGarde", Font.BOLD, 12));
        l4.setForeground(Color.white);
        add(l4);

        JLabel l5 = new JLabel("(It would appear on ATM Card / Cheque Book & Statements)");
        l5.setBounds(240, 330, 600, 40);
        l5.setFont(new Font("AvantGarde", Font.BOLD, 12));
        l5.setForeground(Color.white);
        add(l5);

        // ATM PIN Password ---
        JLabel labelPIN = new JLabel("PIN No: ");
        labelPIN.setBounds(40, 380, 600, 40);
        labelPIN.setFont(new Font("AvantGarde", Font.BOLD, 15));
        labelPIN.setForeground(Color.white);
        add(labelPIN);

        JLabel l6 = new JLabel("(4-digits password)");
        l6.setBounds(40, 410, 600, 40);
        l6.setFont(new Font("AvantGarde", Font.BOLD, 12));
        l6.setForeground(Color.white);
        add(l6);

        JLabel l7 = new JLabel("XXXX");
        l7.setBounds(240, 380, 600, 40);
        l7.setFont(new Font("AvantGarde", Font.BOLD, 15));
        l7.setForeground(Color.white);
        add(l7);

        // Services Required ---
        JLabel labelSer = new JLabel("Services Required: ");
        labelSer.setBounds(40, 460, 600, 40);
        labelSer.setFont(new Font("AvantGarde", Font.BOLD, 15));
        labelSer.setForeground(Color.white);
        add(labelSer);

        c1 = new JCheckBox("Credit Card");
        c1.setFont(new Font("RaleWay", Font.BOLD, 15));
        c1.setBackground(new Color(31, 33, 41));
        c1.setBounds(240, 460, 150, 40);
        c1.setForeground(Color.white);
        add(c1);

        c2 = new JCheckBox("Debit Card");
        c2.setFont(new Font("RaleWay", Font.BOLD, 15));
        c2.setBackground(new Color(31, 33, 41));
        c2.setBounds(400, 460, 150, 40);
        c2.setForeground(Color.white);
        add(c2);

        c3 = new JCheckBox("Net Banking");
        c3.setFont(new Font("RaleWay", Font.BOLD, 15));
        c3.setBackground(new Color(31, 33, 41));
        c3.setBounds(560, 460, 150, 40);
        c3.setForeground(Color.white);
        add(c3);

        c4 = new JCheckBox("  I, hereby declare that the above details are verified & please proceed further.");
        c4.setFont(new Font("RaleWay", Font.ITALIC, 15));
        c4.setBackground(new Color(31, 33, 41));
        c4.setBounds(80, 530, 700, 40);
        c4.setForeground(Color.white);
        add(c4);

        submit = new JButton("Submit");
        submit.setFont(new Font("RaleWay", Font.BOLD, 15));
        submit.setBounds(700, 590, 100, 30);
        submit.setForeground(new Color(5, 115, 8));
        submit.setBackground(new Color(213, 216, 219));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("RaleWay", Font.BOLD, 15));
        cancel.setBounds(580, 590, 100, 30);
        cancel.setForeground(Color.RED);
        cancel.setBackground(new Color(213, 216, 219));
        cancel.addActionListener(this);
        add(cancel);








        getContentPane().setBackground(new Color(31, 33, 41));
        setLayout(null);
        setSize(850, 750);
        setLocation(220, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String aType = (String) comboBox1.getSelectedItem();

        String holderName = textHolder.getText();

        Random ran = new Random();

        long first7 = (ran.nextLong() % 90000000L) + 1409963000000000L;
        String cardNo = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        String service = "";
        if (c1.isSelected()) {
            service += "Credit Card";
        }else if (c2.isSelected()) {
            service += "Debit Card";
        }else if (c3.isSelected()) {
            service += "Net Banking";
        }

        try {
            if (e.getSource()==submit) {
                if (aType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the fields");
                }
                else {
                    Connect con3 = new Connect();
                    String q2 = "insert into registerthree values('"+formNo+"','"+aType+"', '"+holderName+"', '"+cardNo+"', '"+pin+"','"+service+"')";
                    String q3 = "insert into login values('"+formNo+"', '"+cardNo+"', '"+pin+"')";
                    con3.statement.executeUpdate(q2);
                    con3.statement.executeUpdate(q3);
                    JOptionPane.showMessageDialog(null, "Card Number : "+cardNo+"\n Pin : "+pin);
//                    new Signup3(formNo);
                    new Deposit(pin);
                    setVisible(false);
                }
            } else if (e.getSource() == cancel) {
                System.exit(0);
            }

        }catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup3("");
    }
}
