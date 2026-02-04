import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class BloodStock extends JFrame {

    private Container c;
    private Font f,f2;
    private JButton b1;
    private ImageIcon icon;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    BloodStock(){
        setthings();
    }
    public void setthings(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,620);
        this.setLocationRelativeTo(null);
        this.setTitle("Blood Stock Report");

        icon = new ImageIcon(getClass().getResource("image.jpeg"));
        this.setIconImage(icon.getImage());


        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(136,4,4));

        int total=0,apositive=0,anegative=0,bpositive=0,bnegative=0,abpositive=0
                ,abnegative=0,opositive=0,onegative=0;

        try {
            File fr = new File("Information.text");
            Scanner sc = new Scanner(fr);
            int count = 0;
            while (sc.hasNext()) {
                String nm = sc.nextLine();
                count++;
            }

            Doners[] arr = new Doners[count];

            total=count;
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
                if(n3.equals("A+")){apositive++;}
                else if(n3.equals("A-")){anegative++;}
                else if(n3.equals("AB+")){abpositive++;}
                else if(n3.equals("AB-")){abnegative++;}
                else if(n3.equals("B-")){bnegative++;}
                else if(n3.equals("B+")){bpositive++;}
                else if(n3.equals("O+")){opositive++;}
                else if(n3.equals("O-")){onegative++;}
                }
            }catch(Exception E){
            System.out.println(E);
        }

        f=new Font("Times New Roman",Font.BOLD,16);
        f2=new Font("Times New Roman",Font.BOLD,26);

        l8=new JLabel("BLOOD STOCK REPORT");
        l8.setBounds(150,20,400,50);
        l8.setForeground(Color.white);
        l8.setFont(f2);
        c.add(l8);

        l1=new JLabel("Total doner in the Blood Bank is: "+total);
        l1.setBounds(100,90,300,40);
        l1.setFont(f);
        l1.setForeground(Color.white);
        c.add(l1);

        l2=new JLabel("A+ Blood Group Doner : "+apositive);
        l2.setBounds(100,130,250,40);
        l2.setFont(f);
        l2.setForeground(Color.white);
        c.add(l2);

        l3=new JLabel("A- Blood Group Doner : "+anegative);
        l3.setBounds(100,170,250,40);
        l3.setFont(f);
        l3.setForeground(Color.white);
        c.add(l3);

        l4=new JLabel("B- Blood Group Doner : "+bnegative);
        l4.setBounds(100,210,250,40);
        l4.setFont(f);
        l4.setForeground(Color.white);
        c.add(l4);

        l5=new JLabel("B+ Blood Group Doner : "+bpositive);
        l5.setBounds(100,250,250,40);
        l5.setFont(f);
        l5.setForeground(Color.white);
        c.add(l5);

        l6=new JLabel("AB+ Blood Group Doner : "+abpositive);
        l6.setBounds(100,290,250,40);
        l6.setFont(f);
        l6.setForeground(Color.white);
        c.add(l6);

        l7=new JLabel("AB- Blood Group Doner : "+abnegative);
        l7.setBounds(100,330,250,40);
        l7.setFont(f);
        l7.setForeground(Color.white);
        c.add(l7);

        l9=new JLabel("O+ Blood Group Doner : "+opositive);
        l9.setBounds(100,370,250,40);
        l9.setForeground(Color.white);
        l9.setFont(f);
        c.add(l9);

        l10=new JLabel("O+ Blood Group Doner : "+onegative);
        l10.setBounds(100,410,250,40);
        l10.setForeground(Color.white);
        l10.setFont(f);
        c.add(l10);

        b1=new JButton("Back To Previous Page");
        b1.setBackground(Color.white);
        b1.setForeground(new Color(136,4,4));
        b1.setBounds(200,500,200,40);
        c.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainWindo frame=new MainWindo();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        BloodStock frame=new BloodStock();
        frame.setVisible(true);
    }
}
