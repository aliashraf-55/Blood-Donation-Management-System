import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Reglog extends JFrame {
    private Container c;
    private JTextField t1;
    private JLabel l1,l2;
    private JButton b1,b2;
    private JPasswordField p1;
    private Font f;
    private ImageIcon icon;

    Reglog(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(445,400);
        this.setLocationRelativeTo(null);
        this.setTitle("Log in");

        c=this.getContentPane();
        c.setLayout(null);
        Color color=new Color(136, 4, 4);
        c.setBackground(color);

        icon = new ImageIcon(getClass().getResource("image.jpeg"));
        this.setIconImage(icon.getImage());

        f=new Font("Times New Roman",Font.BOLD,20);


        l1=new JLabel("Username :");
        l1.setBounds(50,50,150,50);
        l1.setForeground(Color.white);
        l1.setFont(f);
        c.add(l1);

        t1=new JTextField();
        t1.setBounds(170,55,200,40);
        t1.setFont(f);
        c.add(t1);

        l2=new JLabel("Password :");
        l2.setForeground(Color.white);
        l2.setBounds(50,120,150,40);
        l2.setFont(f);
        c.add(l2);

        p1=new JPasswordField();
        p1.setBounds(170,120,200,40);
        p1.setFont(f);
        c.add(p1);

        b1=new JButton("Sign Up");
        b1.setBounds(50,210,150,40);
        b1.setFont(f);
        c.add(b1);

        b2=new JButton("Log in");
        b2.setBounds(220,210,150,40);
        b2.setFont(f);
        c.add(b2);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Signup frame=new Signup();
                frame.setVisible(true);

            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = t1.getText();
                String pass = p1.getText();


                try {
                    File fl = new File("signupinfo.txt");
                    Scanner sc = new Scanner(fl);
                    Boolean flag = false;

                    int count=0;
                    while(sc.hasNext()){
                        String nm=sc.nextLine();
                        count++;
                    }

                    sc=new Scanner(fl);

                    worker [] arr =new worker[count];

                    int i=0;
                    while (sc.hasNext()) {
                        String nam = sc.next();
                        String pas = sc.next();
                        String id = sc.next();

                        arr[i]=new worker(nam,pas,id);
                        i++;
                    }

                    int find =-1;

                    for(int j=0;j<count ;j++){
                        if (arr[j].getWname().equals(name) && arr[j].getPass().equals(pass))
                        {
                            find=j;
                            break;
                        }
                    }

                    if(find == -1){
                        JOptionPane.showMessageDialog(null, "Access Denied", "login", 0);
                    }else{
                        JOptionPane.showMessageDialog(null, "log in Successful", "Log in", 1);
                        dispose();
                        MainWindo frame=new MainWindo();
                        frame.setVisible(true);
                    }
                    sc.close();
                } catch (Exception EE) {
                    System.out.println(EE);
                }

            }
        });

    }


    public static void main(String[] args) {

        Reglog frame=new Reglog();
        frame.setVisible(true);
    }
}
