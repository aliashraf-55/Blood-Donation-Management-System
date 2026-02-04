import javax.management.modelmbean.ModelMBeanAttributeInfo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

public class Rating implements InterfaceAndException{
    public int exceptionfind=-1;
    private int rating=1;
    Rating(){

    }
    Rating(int rating){
        try {
            setRating(rating);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);

        }
    }

    public void setRating(int Rating) {
        if (Rating >= 1 && Rating<=5) {
            this.rating = Rating;
            exceptionfind = 1;
        }
        else
            throw new IllegalArgumentException("Invalid rating");

    };


    public int getRating() {
        return rating;
    }

    public static void main(String[] args) {
        Rating a=new Rating(1);
//        System.out.println(a.getRating());
//        System.out.println(a.exceptionfind);
    }
}
class RatingWindow extends JFrame{
    private Container c;
    private JLabel l1;
    private JButton b1,b2,b3;
    private JComboBox c1;
    private Font f,f2,f3;
    private ImageIcon icon;


    RatingWindow(){
        setthings();
    }
    public void setthings(){

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(450,420);
        this.setLocationRelativeTo(null);
        this.setTitle("Rating");

        icon = new ImageIcon(getClass().getResource("image.jpeg"));
        this.setIconImage(icon.getImage());

        Color color=new Color(136, 4, 4);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(color);

        String []rate={"1","2","3","4","5"};

        f=new Font("Times New Roman",Font.BOLD,14);
        f2=new Font("Times New Roman",Font.BOLD,20);
        f3=new Font("Times New Roman",Font.BOLD,12);


        l1=new JLabel("RATE THE SERVICE PLEASE");
        l1.setBounds(80,20,300,50);
        l1.setForeground(Color.white);
        l1.setFont(f2);
        c.add(l1);

        c1=new JComboBox(rate);
        c1.setEditable(true);
        c1.setForeground(new Color(136,4,4));
        c1.setBounds(170,100,100,30);
        c1.setFont(f);
        c.add(c1);

        b1=new JButton("SUBMIT");
        b1.setFont(f3);
        b1.setBounds(170,200,100,30);
        b1.setForeground(color);
        c.add(b1);

        b2=new JButton("Back To Main Page");
        b2.setBounds(145,250,150,30);
        b2.setFont(f3);
        b2.setForeground(color);
        c.add(b2);

        b3=new JButton("Submit And Exit From Program ");
        b3.setBounds(105,300,230,30);
        b3.setForeground(color);
        b3.setFont(f3);
        c.add(b3);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rate1=Integer.parseInt(c1.getSelectedItem().toString());

                    Rating rate2 = new Rating(rate1);
                   int find= rate2.exceptionfind;
               if(find == -1)
                    JOptionPane.showMessageDialog(null,"Try Again");
               else{

                   File f=new File("Rating.text");
                   try{
                       FileWriter fw = new FileWriter("Rating.text",true);
                       fw.write(rate1+"\n");
                       JOptionPane.showMessageDialog(null,"Rating Done");
                       fw.close();
                   }catch(Exception E){
                       System.out.println(E);
                   }
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

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rate1=Integer.parseInt(c1.getSelectedItem().toString());

                Rating rate2 = new Rating(rate1);
                int find= rate2.exceptionfind;
                if(find == -1)
                    JOptionPane.showMessageDialog(null,"Try Again");
                else{

                    File f=new File("Rating.text");
                    try{
                        FileWriter fw = new FileWriter("Rating.text",true);
                        fw.write(rate1+"\n");
                        JOptionPane.showMessageDialog(null,"Rating Done");
                        fw.close();
                        System.exit(1);

                    }catch(Exception E){
                        System.out.println(E);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        RatingWindow frame=new RatingWindow();
        frame.setVisible(true);
    }
}
