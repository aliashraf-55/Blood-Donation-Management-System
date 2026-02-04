import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;


public class Wellcome extends JFrame{

    private Container c;

    private Font f,f1,f2;
    private ImageIcon icon;
    private JLabel imgLbl;
    private ImageIcon img;

    private JLabel label1,label2,label3,label4,label5,label6,label7;

    private JButton b1,b2;

    Wellcome()
    {

        settings();
    }
    public void settings()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(700,650);
        this.setLocationRelativeTo(null);
        this.setTitle("Welcome Window");

        try {
            icon = new ImageIcon("image.jpeg");
            this.setIconImage(icon.getImage());
        } catch (Exception e) {
            System.out.println("Could not load icon: " + e.getMessage());
        }

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(153,0,0) );

        f = new Font("Comic Sans MS",Font.BOLD,22);
        f1 = new Font("Constantia",Font.BOLD,14);
        f2 = new Font("Times New Roman",Font.BOLD,14);


        try {
            img = new ImageIcon("can.jpg");
        } catch (Exception e) {
            System.out.println("Could not load image: " + e.getMessage());
            img = new ImageIcon(); // Create empty icon
        }

        imgLbl = new JLabel(img);
        imgLbl.setBounds(0,80,700,310);
        c.add(imgLbl);

        label1 = new JLabel();
        label1.setText("WELCOME TO BLOOD DONATION MANAGEMNT SYSTEM");
        label1.setBounds(10,10,1000,50);
        label1.setFont(f);
        label1.setForeground(Color.white);
        label1.setBackground(Color.CYAN);
        c.add(label1);



        label2 = new JLabel();
        label2.setText("THIS PROJECT IS DONE BY: ");
        label2.setBounds(250,435,1000,20);
        label2.setFont(f1);
        label2.setForeground(Color.white);
        c.add(label2);

        label3 = new JLabel();
        label3.setText("MD ALI ASHRAF ");
        label3.setBounds(290,525,1000,20);
        label3.setFont(f1);
        label3.setForeground(Color.white);
        c.add(label3);

        label4 = new JLabel();
        label4.setText("FAIZUR RAHMAN ZUNAYED ");
        label4.setBounds(250,465,1000,20);
        label4.setFont(f1);
        label4.setForeground(Color.white);
        c.add(label4);

        label5 = new JLabel();
        label5.setText("SHOAIB BIN HABIB ");
        label5.setBounds(280,495,1000,20);
        label5.setFont(f1);
        label5.setForeground(Color.white);
        c.add(label5);

        double rating=0;
        try {
            File f = new File("Rating.text");
            Scanner sc = new Scanner(f);
            int count = 0;
            while(sc.hasNext())
            {
                String nm = sc.nextLine();
                count++;
            }
            int[] arr = new int[count];
            sc = new Scanner(f);
            int i = 0;
            double sum = 0.0;

            while(sc.hasNext())
            {
                int id = sc.nextInt();
                arr[i] = id;
                sum+=arr[i];
                i++;
            }
            rating=sum/count;
            sc.close();

        }catch(Exception ex){
                System.out.println(ex);
            }

        double rating2 = Math.round(rating * 10.0) / 10.0;

        label7 = new JLabel();
        label7.setText("Average Rating : "+rating2);
        label7.setBounds(275,580,1000,20);
        label7.setFont(f1);
        label7.setForeground(Color.gray);
        c.add(label7);



        b1 = new JButton("Exit");
        b1.setBounds(10,500,100,50);
        b1.setForeground(new Color(136,4,4));
        b1.setBackground(Color.white);
        b1.setFont(f2);
        c.add(b1);

        b2 = new JButton("Next");
        b2.setBounds(550,500,100,50);
        b2.setForeground(new Color(136,4,4));
        b2.setBackground(Color.white);
        b2.setFont(f2);
        c.add(b2);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Reglog frame=new Reglog();
                frame.setVisible(true);
            }
        });

    }
    public static void main(String[] args) {
        Wellcome frame = new Wellcome();
        frame.setVisible(true);

    }
}
