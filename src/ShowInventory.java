import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class ShowInventory extends JFrame{
    private Container c;
    private JLabel l1;
    private JButton b1;
    private Font f,f2;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private ImageIcon icon;

    private String [] coloum={"Name","Age","Phone","gender","Address","Blood Group","Date"};

    ShowInventory(){
        setthings();
    }
public void setthings(){

    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setSize(600,600);
    this.setLocationRelativeTo(null);
    this.setTitle("List of all doners");

    icon = new ImageIcon(getClass().getResource("image.jpeg"));
    this.setIconImage(icon.getImage());

    Color color=new Color(136, 4, 4);

    c=this.getContentPane();
    c.setLayout(null);
    c.setBackground(color);
    f=new Font("Times New Roman",Font.BOLD,16);
    f2=new Font("Times New Roman",Font.BOLD,14);


    l1=new JLabel("LIST OF ALL DONORS INFORMATION----");
    l1.setBounds(50,20,350,50);
    l1.setForeground(Color.white);
    l1.setFont(f);
    c.add(l1);

    b1=new JButton("Back To Previous Page");
    b1.setBounds(200,490,200,40);
    b1.setForeground(color);
    b1.setFont(f2);
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
        File fr = new File("Information.text");
        Scanner sc = new Scanner(fr);
        int count = 0;
        while (sc.hasNext()) {
            String nm = sc.nextLine();
            count++;
        }

        Doners[] arr = new Doners[count];
         String [] row=new String[7];

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

            row[0]=n;
            row[1] = Integer.toString(a);
            row[2] = n1;
            row[3] = g;
            row[4] = n2;
            row[5] = n3;
            row[6] = n4;
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
    public static void main(String[] args) {
        ShowInventory frame=new ShowInventory();
        frame.setVisible(true);
    }
}
