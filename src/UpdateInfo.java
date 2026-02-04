import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class UpdateInfo extends JFrame{
    private Container c;
    private Font f,f2;
    private JLabel l1,l2;
    private JTextField t1;
    private JButton b1,b2;
    private ImageIcon icon;

     private static String phone;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public  String getPhone() {
        return phone;
    }


    UpdateInfo(){
        setthing();
    }
    public void setthing(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setTitle("Update Information");

        icon = new ImageIcon(getClass().getResource("image.jpeg"));
        this.setIconImage(icon.getImage());

        Color color=new Color(136, 4, 4);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(color);

        f=new Font("Times New Roman",Font.BOLD,20);
        f2=new Font("Times New Roman",Font.BOLD,16);

        l1=new JLabel("Enter number to update your account");
        l1.setBounds(80,50,400,50);
        l1.setForeground(Color.white);
        l1.setFont(f);
        c.add(l1);

        l2=new JLabel("Are you sure you want to update your account?");
        l2.setBounds(50,190,405,50);
        l2.setForeground(Color.white);
        l2.setFont(f);
        c.add(l2);

        t1=new JTextField();
        t1.setBounds(150,120,170,30);
        t1.setForeground(new Color(136,4,4));
        t1.setFont(f);
        c.add(t1);



        b1=new JButton("YES");
        b1.setBounds(120,270,100,40);
        b1.setForeground(color);
        b1.setFont(f);
        c.add(b1);

        b2=new JButton("NO");
        b2.setBounds(260,270,100,40);
        b2.setForeground(color);
        b2.setFont(f);
        c.add(b2);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phone =t1.getText().toString();
                try {
                    File fr = new File("Information.text");
                    Scanner sc = new Scanner(fr);
                    int count = 0;
                    while (sc.hasNext()) {
                        String nm = sc.nextLine();
                        count++;
                    }

                    Doners[] arr = new Doners[count];
                    sc = new Scanner(fr);
                    int i = 0;
                    while (sc.hasNext()) {
                        String n = sc.next();
                        int a = sc.nextInt();
                        String n1 = sc.next();
                        String g = sc.next();
                        String n2 = sc.next();
                        String n3 = sc.next();
                        String n4 = sc.next();
                        arr[i] = new Doners(n, a, n1, g, n2, n3, n4);
                        i++;

                    }
                    int find =-1;
                    for(int j=0;j<count ;j++){
                        if (arr[j].getPhone().equalsIgnoreCase(phone)) {
                            find=j;
                            break;
                        }
                    }
                    if(find == -1){
                        JOptionPane.showMessageDialog(null, "Phone number not found", "login", 0);
                    }else{
                        dispose();
                        UpdateInfo2 frame2=new UpdateInfo2();
                        frame2.setVisible(true);
                    }

                    sc.close();
                }catch(Exception ee){
                    System.out.println(ee);
                }


            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainWindo frame=new MainWindo();
                frame.setVisible(true);
            }
        });

    }
    public static void main(String[] args) {
        UpdateInfo frame=new UpdateInfo();
        frame.setVisible(true);
    }

}
