package banks.management.systems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener { // ActionListener will provide error unless we create override class of actionPerformed below

    JLabel label1, label2, label3;
    JTextField textField;
    JPasswordField passwordField;
    Button button1, button2, button3;
    Login () {
        super("Bank Management System"); // This super will be at top in this constructor like this

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/banking.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 100, 100);
        add(image);

        ImageIcon j1 = new ImageIcon(ClassLoader.getSystemResource("icons/cards.png"));
        Image j2 = j1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon j3 = new ImageIcon(j2);
        JLabel image2 = new JLabel(j3);
        image2.setBounds(530, 170, 300, 300);
        add(image2);





        // Heading label :--
        label1 = new JLabel("WELCOME TO ATM SERVICE");
        label1.setForeground(Color.yellow);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 25));
        label1.setBounds(230, 125, 450, 40);
        add(label1);


        // ATM card no :--
        label2 = new JLabel("Enter Card Number:");
        label2.setForeground(Color.white);
        label2.setFont(new Font("AvantGarde", Font.BOLD, 15));
        label2.setBounds(150, 190, 375, 30);
        add(label2);

        textField = new JTextField(15);
        textField.setForeground(Color.BLUE);
        textField.setBounds(325, 190, 230, 30);
        textField.setFont(new Font("Arial", Font.BOLD, 13));
        add(textField);

        // ATM PIN :--
        label3 = new JLabel("Enter PIN:");
        label3.setForeground(Color.white);
        label3.setFont(new Font("AvantGarde", Font.BOLD, 15));
        label3.setBounds(150, 240, 375, 30);
        add(label3);


        passwordField = new JPasswordField(15);
        passwordField.setForeground(Color.red);
        passwordField.setBounds(325, 240, 230, 30);
        passwordField.setFont(new Font("Arial", Font.BOLD, 13));
        add(passwordField);

        button1 = new Button("Log in");
        button1.setFont(new Font("Arial", Font.BOLD, 13));
        button1.setForeground(Color.green);
        button1.setBackground(Color.BLACK);
        button1.setBounds(300, 300, 100, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new Button("Clear");
        button2.setFont(new Font("Arial", Font.BOLD, 13));
        button2.setForeground(Color.green);
        button2.setBackground(Color.BLACK);
        button2.setBounds(430, 300, 100, 30);
        button2.addActionListener(this);
        add(button2);

        button3 = new Button("Sign up");
        button3.setFont(new Font("Arial", Font.BOLD, 13));
        button3.setForeground(Color.green);
        button3.setBackground(Color.BLACK);
        button3.setBounds(365, 350, 100, 30);  // (300+430)/2 = 365
        button3.addActionListener(this);
        add(button3);


        ImageIcon k1 = new ImageIcon(ClassLoader.getSystemResource("icons/backlog.jpg"));
        Image k2 = k1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon k3 = new ImageIcon(k2);
        JLabel image3 = new JLabel(k3);
        image3.setBounds(0, 0, 850, 480);
        add(image3);




        setLayout(null);
        setSize(850, 480);
        setVisible(true);
        setLocation(230, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource() == button1){
                Connect c = new Connect();
                String cardNo = textField.getText();
                String pin = passwordField.getText();
                String q = "select * from Login where card_number = '"+cardNo+"'and pin = '"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next()){
                    setVisible(false);
                    new MainClass(pin);
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid Card Number or PIN is provided");
                }

            } else if (e.getSource() == button2) {
                textField.setText("");
                passwordField.setText("");
            } else if (e.getSource() == button3) {
                new Signup();
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();

    }
}

