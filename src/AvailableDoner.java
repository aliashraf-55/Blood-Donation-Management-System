import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class AvailableDoner extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel l1;
    private JButton b1;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private Font f,f2;
    AvailableDoner(){
        setthings();
    }
    public int monthcal(Month n){

        String mn=n.toString();
        if(mn.equals("JANUARY"))
            return 1;
        else if(mn.equals("FEBRUARY"))
            return 2;
        else if(mn.equals("MARCH"))
            return 3;
        else if(mn.equals("APRIL"))
            return 4;
        else if(mn.equals("MAY"))
            return 5;
        else if(mn.equals("JUNE"))
            return 6;
        else if(mn.equals("JULY"))
            return 7;
        else if(mn.equals("AUGUST"))
            return 8;
        else if(mn.equals("SEPTEMBER"))
            return 9;
        else if(mn.equals("OCTOBER"))
            return 10;
        else if(mn.equals("NOVEMBER"))
            return 11;
        else if(mn.equals("DECEMBER"))
            return 12;
        else
            return 0;

    }
    public void setthings(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setTitle("Available Donor");

        icon = new ImageIcon(getClass().getResource("image.jpeg"));
        this.setIconImage(icon.getImage());

        f=new Font("Times New Roman",Font.BOLD,14);
        f2=new Font("Times New Roman",Font.BOLD,22);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(136,4,4));


        l1=new JLabel("Available Doners List");
        l1.setBounds(50,40,250,50);
        l1.setForeground(Color.white);
        l1.setFont(f2);
        c.add(l1);

        String[]coloum={"Name","Blood Group","Phone","Address"};

        model =new DefaultTableModel();
        model.setColumnIdentifiers(coloum);

        LocalDate currentdate = LocalDate.now();
        int currentDay = currentdate.getDayOfMonth();
        Month currentMonth = currentdate.getMonth();
        int currentYear = currentdate.getYear();

        Month newMonth = currentMonth.minus(4);
        int cmonth=monthcal(newMonth);

        table = new JTable();

        scroll = new JScrollPane(table);


        try {
            File fr = new File("Information.text");
            Scanner sc = new Scanner(fr);
            int count = 0;
            while (sc.hasNext()) {
                String nm = sc.nextLine();
                count++;
            }

            Doners[] arr = new Doners[count];
            String [] row=new String[4];

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

                LocalDate currentDate = LocalDate.parse(n4);

                int day = currentDate.getDayOfMonth();
                Month month = currentDate.getMonth();
                int month2=monthcal(month);

                int year = currentDate.getYear();


                if((currentYear==year && cmonth >month2)|| currentYear>year){
                    arr[i] = new Doners(n, a, n1, g, n2, n3, n4);

                    if(i>=0) {
                        row[0] = n;
                        row[1] = n3;
                        row[2] = n1;
                        row[3] = n2;

                        model.addRow(row);
                        table.setModel(model);
                        scroll = new JScrollPane(table);

                    }
                }else continue;


                i++;
            }
            scroll.setBounds(50,90,500,380);
            c.add(scroll);
            sc.close();
        }catch(Exception E){
            System.out.println(E);
        }
        b1=new JButton("Back To Previous Page");
        b1.setFont(f);
        b1.setBackground(Color.white);
        b1.setForeground(new Color(136,4,4));
        b1.setBounds(200,485,200,40);
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
        AvailableDoner frame=new AvailableDoner();
        frame.setVisible(true);
    }
}
