import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Signup extends JFrame {
    private Container c;
    private JTextField t1,t2,t3;
    private JLabel l1,l2,l3;
    private JButton b1,b2;
    private JPasswordField p1;
    private Font f;
    private ImageIcon icon;
    Signup() {

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(445, 400);
        this.setLocationRelativeTo(null);
        this.setTitle("Log in");

        c = this.getContentPane();
        c.setLayout(null);
        Color color = new Color(136, 4, 4);
        c.setBackground(color);

        icon = new ImageIcon(getClass().getResource("image.jpeg"));
        this.setIconImage(icon.getImage());

//        f=new Font("Arial",Font.BOLD,20);
        f = new Font("Times New Roman", Font.BOLD, 20);


        l1 = new JLabel("Username :");
        l1.setBounds(50, 50, 150, 50);
        l1.setForeground(Color.white);
        l1.setFont(f);
        c.add(l1);

        t1 = new JTextField();
        t1.setBounds(170, 55, 200, 40);
        t1.setFont(f);
        c.add(t1);

        l2 = new JLabel("Password :");
        l2.setForeground(Color.white);
        l2.setBounds(50, 120, 150, 40);
        l2.setFont(f);
        c.add(l2);

        p1 = new JPasswordField();
        p1.setBounds(170, 120, 200, 40);
        p1.setFont(f);
        c.add(p1);

        l3 = new JLabel("ID :");
        l3.setForeground(Color.white);
        l3.setBounds(50, 190, 150, 40);
        l3.setFont(f);
        c.add(l3);

        t3 = new JTextField();
        t3.setBounds(170, 190, 200, 40);
        t3.setFont(f);
        c.add(t3);


        b1 = new JButton("Sign Up");
        b1.setBounds(150, 270, 150, 40);
        b1.setFont(f);
        b1.setForeground(color);
        c.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    File fl2 = new File("signupinfo.txt");
                    FileWriter fw = new FileWriter(fl2, true);
                    if(t1.getText().isEmpty()|| t3.getText().isEmpty()||p1.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"PLEASE Fill up all information");
                    }
                    else{

                    String row = t1.getText() + "\t"+ t3.getText()+"\t"+p1.getText();
                    fw.write(row + "\n");
                    fw.close();
                   dispose();
                   JOptionPane.showMessageDialog(null,"Sing up Successfull");
                    Reglog frame=new Reglog();
                    frame.setVisible(true);}
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        });
    }
        public static void main(String[] args) {
        Signup frame=new Signup();
        frame.setVisible(true);


    }
}
