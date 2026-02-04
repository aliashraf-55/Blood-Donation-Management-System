import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindo extends JFrame {
    private ImageIcon image,icon;

    private Container c;
    private Font f;
    private JLabel l1;
    private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    MainWindo(){
        setthings();
    }
    public void setthings(){

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(710,670);
        this.setLocationRelativeTo(null);
        this.setTitle("Main Window");

        icon = new ImageIcon(getClass().getResource("image.jpeg"));
        this.setIconImage(icon.getImage());


        c=this.getContentPane();
        c.setLayout(null);
        Color color=new Color(136, 4, 4);
        c.setBackground(color);


        image=new ImageIcon(getClass().getResource("ali11.jpeg"));

        f=new Font("Times New Roman",Font.BOLD,14);

        l1 =new JLabel(image);
        l1.setBounds(15,15, 670, 200);
        c.add(l1);

        b1=new JButton("List of all doner");
        b1.setBounds(15,225,325,70);
        b1.setForeground(color);
        b1.setFont(f);
        c.add(b1);

        b2=new JButton("Search for blood");
        b2.setBounds(365,225,320,70);
        b2.setForeground(color);
        b2.setFont(f);
        c.add(b2);

        b3=new JButton("Register as donor");
        b3.setBounds(15,305,325,70);
        b3.setForeground(color);
        b3.setFont(f);
        c.add(b3);

        b4=new JButton("Update donor details");
        b4.setBounds(365,305,320,70);
        b4.setForeground(color);
        b4.setFont(f);
        c.add(b4);

        b5=new JButton("Delete donor account");
        b5.setBounds(15,385,325,70);
        b5.setForeground(color);
        b5.setFont(f);
        c.add(b5);

        b6=new JButton("View available donors");
        b6.setBounds(365,385,320,70);
        b6.setForeground(color);
        b6.setFont(f);
        c.add(b6);

        b7=new JButton("View blood stock report");
        b7.setBounds(15,465,325,70);
        b7.setForeground(color);
        b7.setFont(f);
        c.add(b7);

        b8=new JButton("Request for Blood");
        b8.setBounds(365,465,320,70);
        b8.setFont(f);
        b8.setForeground(color);
        c.add(b8);

        b9=new JButton("Show the list of Request for Blood ");
        b9.setBounds(15,545,325,70);
        b9.setFont(f);
        b9.setForeground(color);
        c.add(b9);

        b10=new JButton("  Exit  ");
        b10.setBounds(365,545,320,70);
        b10.setFont(f);
        b10.setForeground(color);
        c.add(b10);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ShowInventory frame=new ShowInventory();
                frame.setVisible(true);            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SearchForBlood frame=new SearchForBlood();
                frame.setVisible(true);            }
        });


        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Register frame=new Register();
                frame.setVisible(true);

            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                UpdateInfo frame=new UpdateInfo();
                frame.setVisible(true);

            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                DeletDonerAccount frame=new DeletDonerAccount();
                frame.setVisible(true);
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AvailableDoner frame=new AvailableDoner();
                frame.setVisible(true);
            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                BloodStock frame=new BloodStock();
                frame.setVisible(true);         }
        });

        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AskForBlook frame=new AskForBlook();
                frame.setVisible(true);       }
        });

        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Requestlist frame=new Requestlist();
                frame.setVisible(true);          }
        });

        b10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                RatingWindow frame2 = new RatingWindow();
                frame2.setVisible(true);
            }
        });

    }
    public static void main(String[] args) {
        MainWindo frame=new MainWindo();
        frame.setVisible(true);
    }
}
