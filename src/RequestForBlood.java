import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class RequestForBlood extends JFrame {

    public static void main(String[] args) {
        AskForBlook a=new AskForBlook();
        a.setVisible(true);
    }
}
class AskForBlook extends JFrame{

    private Container c;
    private JTextField t1,t2,t3,t4,t5,t6;
    private JLabel l1,l2,l3,l4,l5,l6;
    private JButton b1,b2;
    private Font f;
    private ImageIcon icon;

    private JComboBox<String> cb1;

    AskForBlook(){
        setthings();

    }
    public void setthings(){

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setTitle("Request for Blood");

        f=new Font("Times New Roman",Font.BOLD,16);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(136,4,4));
        icon = new ImageIcon(getClass().getResource("image.jpeg"));
        this.setIconImage(icon.getImage());

        l1=new JLabel("Name :");
        l1.setBounds(30,20,150,50);
        l1.setForeground(Color.white);
        l1.setFont(f);
        c.add(l1);

        l2=new JLabel("Blood Group :");
        l2.setBounds(30,80,150,50);
        l2.setForeground(Color.white);
        l2.setFont(f);
        c.add(l2);

        l3=new JLabel("Address :");
        l3.setBounds(30,140,150,50);
        l3.setForeground(Color.white);
        l3.setFont(f);
        c.add(l3);

        l4=new JLabel("Phone :");
        l4.setBounds(30,205,150,50);
        l4.setForeground(Color.white);
        l4.setFont(f);
        c.add(l4);

        t1=new JTextField();
        t1.setBounds(180,20,200,50);
        t1.setForeground(new Color(136,4,4));
        t1.setFont(f);
        c.add(t1);

//        t2=new JTextField();
//        t2.setBounds(180,80,200,50);
//        t2.setFont(f);
//        c.add(t2);

        String[] bgarray = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        cb1 = new JComboBox<>(bgarray);
        cb1.setForeground(new Color(136,4,4));
        cb1.setBounds(180,80,200,50);
        cb1.setForeground(new Color(136,4,4));
        cb1.setFont(f);
        c.add(cb1);

        t3=new JTextField();
        t3.setBounds(180,140,200,50);
        t3.setForeground(new Color(136,4,4));
        t3.setFont(f);
        c.add(t3);

        t4=new JTextField();
        t4.setBounds(180,205,200,50);
        t4.setForeground(new Color(136,4,4));
        t4.setFont(f);
        c.add(t4);

        b1=new JButton("Register");
        b1.setBackground(Color.white);
        b1.setForeground(new Color(136,4,4));
        b1.setBounds(200,310,100,40);
        b1.setFont(f);
        c.add(b1);

        b2=new JButton("Back To Main Window");
        b2.setBackground(Color.white);
        b2.setForeground(new Color(136,4,4));
        b2.setBounds(150,375,200,40);
        b2.setFont(f);
        c.add(b2);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainWindo frame=new MainWindo();
                frame.setVisible(true);
            }
        });

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File f=new File("Request.text");
                try {
                    FileWriter fw = new FileWriter("Request.text",true);

                    String bloodgroup = cb1.getItemAt(cb1.getSelectedIndex()).toString();


                    Person person = new requestperson(t1.getText(),bloodgroup,t3.getText(),t4.getText());
                    requestperson requestp =(requestperson) person;


                    if (t1.getText().isEmpty() || cb1.getItemAt(cb1.getSelectedIndex()).isEmpty() ||
                            t3.getText().isEmpty() || t4.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null,"Fill Up All The Information","login",0);

                    }else {
                        fw.write(requestp.getName() + "\t" + requestp.getBg() +
                                "\t" + requestp.getAdd() + "\t" + requestp.getPhone() + "\n");
                        fw.close();
                        JOptionPane.showMessageDialog(null,"Register Successfull");
                    }

                }catch(Exception E){
                    System.out.println(e);
                }

            }
        });
    }
}

class Requestlist extends JFrame{
    private Container c;
    private JLabel l1;
    private JButton b1;
    private Font f,f2;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private ImageIcon icon;
    private String [] coloum={"Name","Blood Group","Address","Phone"};


    Requestlist(){
        setthings();

    }
    public void setthings(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setTitle("Show Request List");

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(136,4,4));

        icon = new ImageIcon(getClass().getResource("image.jpeg"));
        this.setIconImage(icon.getImage());

        f=new Font("Times New Roman",Font.BOLD,14);
        f2=new Font("Times New Roman",Font.BOLD,18);


        l1=new JLabel("LIST OF REQUEST BLOOD----");
        l1.setForeground(Color.white);
        l1.setBounds(50,20,300,50);
        l1.setFont(f2);
        c.add(l1);

        b1=new JButton("Back To Previous Page");
        b1.setBackground(Color.white);
        b1.setFont(f);
        b1.setForeground(new Color(136,4,4));
        b1.setBounds(200,490,200,40);
        c.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainWindo frame=new MainWindo();
                frame.setVisible(true);
            }
        });
        model =new DefaultTableModel();
        model.setColumnIdentifiers(coloum);



        try {
            File fr = new File("Request.text");
            Scanner sc = new Scanner(fr);
            int count = 0;
            while (sc.hasNext()) {
                String nm = sc.nextLine();
                count++;
            }

            requestperson[] arr = new requestperson[count];
            String [] row=new String[4];

            sc = new Scanner(fr);
            int i = 0;

            while (sc.hasNext()) {

                String n1= sc.next();
                String n2 = sc.next();
                String n3 = sc.next();
                String n4 = sc.next();
                arr[i] = new requestperson(n1,n2,n3,n4);

                row[0]=n1;
                row[1] = n2;
                row[2] = n3;
                row[3] = n4;

                model.addRow(row);
                table=new JTable();

                scroll=new JScrollPane(table);

                table.setModel(model);
                scroll=new JScrollPane(table);

                i++;
            }
            scroll.setBounds(50,70,500,400);
            c.add(scroll);
            sc.close();
        }catch(Exception E){
            System.out.println(E);
        }

    }

}