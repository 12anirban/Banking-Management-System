package banks.management.systems;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {

    Random random = new Random();
    Long first4 = (random.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);
    JTextField textName, textFName, textEmail, textPhone, textAdd, textCity, textPin;
    JDateChooser dateChooser;
    JRadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    JButton buttonNext;

    Signup() {
        super("Application Form");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/banking.png"));
        Image i2 = i1.getImage().getScaledInstance(120,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 10, 120, 100);
        add(image);


        JLabel label1 = new JLabel("Application No: " + first);
        label1.setBounds(300, 20, 600, 40);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 30));
        add(label1);

        JLabel label2 = new JLabel("Page No: 1");
        label2.setBounds(410, 70, 600, 30);
        label2.setFont(new Font("AvantGarde", Font.BOLD, 20));
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setBounds(20, 130, 600, 40);
        label3.setFont(new Font("AvantGarde", Font.BOLD, 20));
        add(label3);


        // Name ---
        JLabel labelName = new JLabel("Name: ");
        labelName.setBounds(20, 170, 600, 40);
        labelName.setFont(new Font("AvantGarde", Font.BOLD, 15));
        add(labelName);

        textName = new JTextField();
        textName.setBounds(140, 176, 600, 30);
        textName.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(textName);


        // Father's Name ---
        JLabel labelFName = new JLabel("Father's Name: ");
        labelFName.setBounds(20, 230, 600, 40);
        labelFName.setFont(new Font("AvantGarde", Font.BOLD, 15));
        add(labelFName);

        textFName = new JTextField();
        textFName.setBounds(140, 236, 600, 30);
        textFName.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(textFName);


        // Date of Birth ---
        JLabel dob = new JLabel("Date of Birth: ");
        dob.setBounds(20, 290, 600, 40);
        dob.setFont(new Font("AvantGarde", Font.BOLD, 15));
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(140, 296, 260, 30);
        dateChooser.setFont(new Font("RaleWay", Font.BOLD, 15));
        add(dateChooser);


        // Gender ---
        JLabel labelG = new JLabel("Gender: ");
        labelG.setBounds(430, 290, 600, 40);
        labelG.setFont(new Font("AvantGarde", Font.BOLD, 15));
        add(labelG);

        radioButton1 = new JRadioButton("Male");
        radioButton1.setBounds(500, 296, 100, 30);
        radioButton1.setBackground(new Color(183, 215, 247));
        radioButton1.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(radioButton1);

        radioButton2 = new JRadioButton("Female");
        radioButton2.setBounds(620, 296, 130, 30);
        radioButton2.setBackground(new Color(183, 215, 247));
        radioButton2.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(radioButton2);

        // This is for selecting only one b/t male and female
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);


        // Email Address ---
        JLabel labelEmail = new JLabel("Email ID: ");
        labelEmail.setBounds(20, 350, 600, 40);
        labelEmail.setFont(new Font("AvantGarde", Font.BOLD, 15));
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setBounds(140, 356, 600, 30);
        textEmail.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(textEmail);


        // Mobile No ---
        JLabel labelPhone = new JLabel("Phone No: ");
        labelPhone.setBounds(20, 410, 600, 40);
        labelPhone.setFont(new Font("AvantGarde", Font.BOLD, 15));
        add(labelPhone);

        textPhone = new JTextField();
        textPhone.setBounds(140, 416, 260, 30);
        textPhone.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(textPhone);

        // Marital Status ---
        JLabel labelMS = new JLabel("Martial Status: ");
        labelMS.setBounds(430, 410, 600, 40);
        labelMS.setFont(new Font("AvantGarde", Font.BOLD, 15));
        add(labelMS);

        radioButton3 = new JRadioButton("Married");
        radioButton3.setBounds(550, 416, 100, 30);
        radioButton3.setBackground(new Color(183, 215, 247));
        radioButton3.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(radioButton3);

        radioButton4 = new JRadioButton("Not Married");
        radioButton4.setBounds(670, 416, 140, 30);
        radioButton4.setBackground(new Color(183, 215, 247));
        radioButton4.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(radioButton4);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton3);
        buttonGroup1.add(radioButton4);


        // Address ---
        JLabel labelAdd = new JLabel("Address: ");
        labelAdd.setBounds(20, 470, 600, 40);
        labelAdd.setFont(new Font("AvantGarde", Font.BOLD, 15));
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setBounds(140, 476, 600, 30);
        textAdd.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(textAdd);

        // City ---
        JLabel labelCity = new JLabel("City: ");
        labelCity.setBounds(20, 530, 600, 40);
        labelCity.setFont(new Font("AvantGarde", Font.BOLD, 15));
        add(labelCity);

        textCity = new JTextField();
        textCity.setBounds(140, 536, 260, 30);
        textCity.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(textCity);


        // Pin Code ---
        JLabel labelPin = new JLabel("PIN Code: ");
        labelPin.setBounds(430, 530, 600, 40);
        labelPin.setFont(new Font("AvantGarde", Font.BOLD, 15));
        add(labelPin);

        textPin = new JTextField();
        textPin.setBounds(550, 536, 190, 30);
        textPin.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(textPin);

        buttonNext = new JButton("Save & Next");
        buttonNext.setBackground(Color.BLACK);
        buttonNext.setFont(new Font("RaleWay", Font.BOLD, 15));
        buttonNext.setForeground(Color.WHITE);
        buttonNext.setBounds(600, 595, 130, 30);
        buttonNext.addActionListener(this);
        add(buttonNext);



        getContentPane().setBackground(new Color(183, 215, 247)); // This is for the bgcolor
        setLayout(null);
        setSize(850, 700);
        setLocation(230, 20);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formNo = first;
        String name = textName.getText();
        String f_name = textFName.getText();
        String DOB = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (radioButton1.isSelected()){
            gender = "Male";
        }
        else if (radioButton2.isSelected()){
            gender = "Female";
        }
        String email = textEmail.getText();
        String phone_no = textPhone.getText();
        String marital = null;
        if (radioButton3.isSelected()){
            marital = "Married";
        } else if (radioButton4.isSelected()) {
            marital = "Not Married";
        }
        String address = textAdd.getText();
        String city = textCity.getText();
        String pin_code = textPin.getText();

        try {
            if (textName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Kindly fill up all the fields");
            }else {
                Connect con1 = new Connect();
                String q = "insert into register values('"+formNo+"', '"+name+"', '"+f_name+"', '"+DOB+"', '"+gender+"', '"+email+"', '"+phone_no+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin_code+"')";
                con1.statement.executeUpdate(q);
                new Signup2(formNo);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}

