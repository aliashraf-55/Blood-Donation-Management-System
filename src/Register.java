import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Register extends JFrame {
    private Container c;
    private ImageIcon icon;
    private JTextField t1, t2, t3, t4, t5, t6;
    private JLabel l1, l2, l3, l4, l5, l6;
    private JComboBox<String> cb1;
    private JRadioButton rb1, rb2;
    private JButton b1, b2;
    private JPasswordField p1;
    private Font f;
    private ButtonGroup grp;

    Register() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 620);
        this.setLocationRelativeTo(null);
        this.setTitle("Register");

        icon = new ImageIcon(getClass().getResource("image.jpeg"));
        this.setIconImage(icon.getImage());

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(136, 4, 4));
        f = new Font("Times New Roman", Font.BOLD, 14);

        l1 = new JLabel("Name :");
        l1.setBounds(30, 20, 150, 50);
        l1.setForeground(Color.white);
        l1.setFont(f);
        c.add(l1);

        l2 = new JLabel("Age :");
        l2.setBounds(30, 80, 150, 50);
        l2.setForeground(Color.white);
        l2.setFont(f);
        c.add(l2);

        l3 = new JLabel("Phone :");
        l3.setBounds(30, 140, 150, 50);
        l3.setForeground(Color.white);
        l3.setFont(f);
        c.add(l3);

        l4 = new JLabel("Address :");
        l4.setBounds(30, 190, 150, 50);
        l4.setForeground(Color.white);
        l4.setFont(f);
        c.add(l4);

        l5 = new JLabel("Blood Group :");
        l5.setBounds(30, 250, 150, 50);
        l5.setForeground(Color.white);
        l5.setFont(f);
        c.add(l5);

        l6 = new JLabel("Last Donate(yyyy-mm-dd):");
        l6.setBounds(30, 310, 200, 50);
        l6.setFont(f);
        l6.setForeground(Color.white);
        c.add(l6);

        t1 = new JTextField();
        t1.setBounds(230, 20, 200, 50);
        t1.setForeground(new Color(136,4,4));
        t1.setFont(f);
        c.add(t1);

        t2 = new JTextField();
        t2.setBounds(230, 80, 200, 50);
        t2.setForeground(new Color(136,4,4));
        t2.setFont(f);
        c.add(t2);

        t3 = new JTextField();
        t3.setBounds(230, 140, 200, 50);
        t3.setForeground(new Color(136,4,4));
        t3.setFont(f);
        c.add(t3);

        t4 = new JTextField();
        t4.setBounds(230, 195, 200, 50);
        t4.setForeground(new Color(136,4,4));
        t4.setFont(f);
        c.add(t4);

        String[] bgarray = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        cb1 = new JComboBox<>(bgarray);
        cb1.setForeground(new Color(136,4,4));
        cb1.setBounds(230, 250, 200, 50);
        cb1.setFont(f);
        c.add(cb1);

        t6 = new JTextField();
        t6.setBounds(230, 310, 200, 50);
        t6.setForeground(new Color(136,4,4));
        t6.setFont(f);
        c.add(t6);

        b1 = new JButton("Register");
        b1.setBackground(Color.white);
        b1.setForeground(new Color(136,4,4));
        b1.setFont(f);
        b1.setBounds(200, 470, 100, 40);
        c.add(b1);

        b2 = new JButton("Back To Previous Page");
        b2.setBackground(Color.white);
        b2.setFont(f);
        b2.setForeground(new Color(136,4,4));
        b2.setBounds(145, 520, 200, 40);
        c.add(b2);

        rb1 = new JRadioButton("Male");
        rb1.setBounds(100, 400, 100, 40);
        rb1.setForeground(new Color(136,4,4));
        rb2 = new JRadioButton("Female");
        rb2.setForeground(new Color(136,4,4));
        rb2.setBounds(300, 400, 100, 40);
        c.add(rb1);
        c.add(rb2);

        grp = new ButtonGroup();
        grp.add(rb1);
        grp.add(rb2);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainWindo frame = new MainWindo();
                frame.setVisible(true);
            }
        });

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String phoneNumberToCheck = t3.getText();

                if (isPhoneRegistered(phoneNumberToCheck)) {
                    JOptionPane.showMessageDialog(null, "Phone number is already registered.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        FileWriter fw = new FileWriter("Information.text", true);
                        String gender = "";
                        if (rb1.isSelected()) {
                            gender = "Male";
                        } else if (rb2.isSelected()) {
                            gender = "Female";
                        }

                        String bloodgroup = cb1.getItemAt(cb1.getSelectedIndex()).toString();

                        Person person = new Doners(t1.getText(), Integer.parseInt(t2.getText()),
                                phoneNumberToCheck, gender, t4.getText(), bloodgroup, t6.getText());

                        Doners doner = (Doners) person;

                        if (t1.getText().isEmpty() || t2.getText().isEmpty() || phoneNumberToCheck.isEmpty() ||
                                t4.getText().isEmpty() || t6.getText().isEmpty() || gender.isEmpty()) {

                            JOptionPane.showMessageDialog(null, "Fill Up All The Information", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            fw.write(doner.getName() + "\t" + doner.getAge() +
                                    "\t" + doner.getPhone() + "\t" + gender + "\t" + doner.getAdd()
                                    + "\t" + bloodgroup + "\t" + doner.getDate() + "\n");
                            fw.close();
                            JOptionPane.showMessageDialog(null, "Registration Successful");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "An error occurred. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println(ex);
                    }
                }
            }
        });
    }

    private boolean isPhoneRegistered(String phoneNumber) {
        try {
            Scanner scanner = new Scanner(new File("Information.text"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                if (parts.length >= 3 && parts[2].equals(phoneNumber)) {
                    scanner.close();
                    return true;
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        Register frame = new Register();
        frame.setVisible(true);
    }
}
