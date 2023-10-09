package banks.management.systems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
    String formNo;
    JComboBox comboBox, comboBox2, comboBox3, comboBox4;
    JTextField textOcc, textPan, textAadhar;
    JRadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    JButton next;
    Signup2(String formNo) {
        super("Application Form");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/banking.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(30, 10, 100, 100);
        add(image);

        this.formNo = formNo;

        JLabel labelForm = new JLabel("Application No: ");
        labelForm.setBounds(300, 30, 600, 30);
        labelForm.setFont(new Font("AvantGarde", Font.BOLD, 30));
        add(labelForm);

        JLabel labelFNo = new JLabel(formNo);
        labelFNo.setBounds(540, 30, 200, 30);
        labelFNo.setFont(new Font("AvantGarde", Font.BOLD, 30));
        add(labelFNo);

        JLabel l1 = new JLabel("Page No: 2");
        l1.setBounds(410, 70, 600, 30);
        l1.setFont(new Font("AvantGarde", Font.BOLD, 20));
        add(l1);

        JLabel l2 = new JLabel("Additional Details");
        l2.setBounds(20, 130, 600, 40);
        l2.setFont(new Font("AvantGarde", Font.BOLD, 20));
        add(l2);

        // Religion ---
        JLabel labelReg = new JLabel("Religion: ");
        labelReg.setBounds(30, 170, 600, 40);
        labelReg.setFont(new Font("AvantGarde", Font.BOLD, 15));
        add(labelReg);

        String [] religion = {"Hindu", "Muslim", "Christian", "Others"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(new Color(248, 248, 170));
        comboBox.setFont(new Font("RaleWay", Font.BOLD, 15));
        comboBox.setBounds(230, 176, 500, 30);
        add(comboBox);

        // Category ---
        JLabel labelCat = new JLabel("Category: ");
        labelCat.setBounds(30, 210, 600, 40);
        labelCat.setFont(new Font("AvantGarde", Font.BOLD, 15));
        add(labelCat);

        String [] category = {"General", "SC", "ST", "OBC"};
        comboBox2 = new JComboBox(category);
        comboBox2.setBackground(new Color(248, 248, 170));
        comboBox2.setFont(new Font("RaleWay", Font.BOLD, 15));
        comboBox2.setBounds(230, 216, 500, 30);
        add(comboBox2);

        // Annual Income ---
        JLabel labelInc = new JLabel("Annual Income: ");
        labelInc.setFont(new Font("AvantGarde", Font.BOLD, 15));
        labelInc.setBounds(30, 250, 600, 40);
        add(labelInc);

        String [] income = {"Less than 2,50000", "250000 - 500000", "500000 - 7,50000", "Above 7,50000"};
        comboBox3 = new JComboBox(income);
        comboBox3.setBackground(new Color(248, 248, 170));
        comboBox3.setFont(new Font("RaleWay", Font.BOLD, 15));
        comboBox3.setBounds(230, 256, 500, 30);
        add(comboBox3);

        // Education Qualification ---
        JLabel labelEdu = new JLabel("Education Qualification: ");
        labelEdu.setFont(new Font("AvantGarde", Font.BOLD, 15));
        labelEdu.setBounds(30, 290, 600, 40);
        add(labelEdu);

        String [] education = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        comboBox4 = new JComboBox(education);
        comboBox4.setBackground(new Color(248, 248, 170));
        comboBox4.setFont(new Font("RaleWay", Font.BOLD, 15));
        comboBox4.setBounds(230, 296, 500, 30);
        add(comboBox4);

        // Occupation ---
        JLabel labelOcc = new JLabel("Occupation: ");
        labelOcc.setBounds(30, 360, 600, 40);
        labelOcc.setFont(new Font("AvantGarde", Font.BOLD, 15));
        add(labelOcc);

        textOcc = new JTextField();
        textOcc.setBounds(170, 366, 250, 30);
        textOcc.setBackground(new Color(248, 248, 170));
        textOcc.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(textOcc);

        // Pan Number ---
        JLabel labelPan = new JLabel("PAN No: ");
        labelPan.setBounds(450, 360, 600, 40);
        labelPan.setFont(new Font("AvantGarde", Font.BOLD, 15));
        add(labelPan);

        textPan = new JTextField();
        textPan.setBounds(550, 366, 250, 30);
        textPan.setBackground(new Color(248, 248, 170));
        textPan.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(textPan);

        // Aadhar Number ---
        JLabel labelAadhar = new JLabel("Aadhar No: ");
        labelAadhar.setBounds(30, 410, 600, 40);
        labelAadhar.setFont(new Font("AvantGarde", Font.BOLD, 15));
        add(labelAadhar);

        textAadhar = new JTextField();
        textAadhar.setBounds(170, 416, 250, 30);
        textAadhar.setBackground(new Color(248, 248, 170));
        textAadhar.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(textAadhar);

        // Senior Citizen or  or not ---
        JLabel labelSen = new JLabel("Are you a senior citizen ? ");
        labelSen.setBounds(30, 460, 600, 40);
        labelSen.setFont(new Font("AvantGarde", Font.BOLD, 15));
        add(labelSen);

        radioButton1 = new JRadioButton("Yes");
        radioButton1.setBounds(250, 466, 100, 30);
        radioButton1.setBackground(new Color(248, 248, 170));
        radioButton1.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(radioButton1);

        radioButton2 = new JRadioButton("No");
        radioButton2.setBounds(350, 466, 100, 30);
        radioButton2.setBackground(new Color(248, 248, 170));
        radioButton2.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(radioButton2);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(radioButton1);
        buttonGroup2.add(radioButton2);

        // Have an existing account or not ---
        JLabel labelEx = new JLabel("Have an existing account ? ");
        labelEx.setBounds(30, 500, 600, 40);
        labelEx.setFont(new Font("AvantGarde", Font.BOLD, 15));
        add(labelEx);

        radioButton3 = new JRadioButton("Yes");
        radioButton3.setBounds(250, 506, 100, 30);
        radioButton3.setBackground(new Color(248, 248, 170));
        radioButton3.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(radioButton3);

        radioButton4 = new JRadioButton("No");
        radioButton4.setBounds(350, 506, 100, 30);
        radioButton4.setBackground(new Color(248, 248, 170));
        radioButton4.setFont(new Font("RaleWay", Font.PLAIN, 15));
        add(radioButton4);

        ButtonGroup buttonGroup3 = new ButtonGroup();
        buttonGroup3.add(radioButton3);
        buttonGroup3.add(radioButton4);



        next = new JButton("Save & Next");
        next.setBackground(Color.BLACK);
        next.setFont(new Font("RaleWay", Font.BOLD, 15));
        next.setForeground(Color.WHITE);
        next.setBounds(600, 576, 130, 30);
        next.addActionListener(this);
        add(next);





        getContentPane().setBackground(new Color(248, 248, 170));
        setLayout(null);
        setSize(850, 750);
        setLocation(220, 30);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) comboBox.getSelectedItem();  // religion
        String cat = (String) comboBox2.getSelectedItem(); // Category
        String inc = (String) comboBox3.getSelectedItem(); // Annual income
        String edu = (String) comboBox4.getSelectedItem(); // Education Qualification
        String occ = textOcc.getText(); // Occupation
        String pan = textPan.getText(); // Pan No
        String aad = textAadhar.getText(); // Aadhar Number
        String sCiti = " ";
        if (radioButton1.isSelected()) {
            sCiti = "Yes";
        }
        else if (radioButton2.isSelected()) {
             sCiti = "No";
        }
        String accExist = " ";
        if (radioButton3.isSelected()) {
            accExist = "Yes";
        }
        else if (radioButton4.isSelected()) {
            accExist = "No";
        }

        try {
            if (textPan.getText().equals("") || textAadhar.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            }
            else {
                Connect con2 = new Connect();
                String q1 = "insert into registertwo values('"+formNo+"','"+rel+"', '"+cat+"', '"+inc+"', '"+edu+"','"+occ+"', '"+pan+"', '"+aad+"', '"+sCiti+"', '"+accExist+"')";
                con2.statement.executeUpdate(q1);
                new Signup3(formNo);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup2("");
    }
}

