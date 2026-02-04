import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UpdateInfo2 extends JFrame {
    private Container c;
    private JTextField t1,t2,t3,t4,t5,t6;
    private JLabel l1,l2,l3,l4,l5,l6;
    private JRadioButton rb1,rb2;
    private JButton b1,b2;
    private JPasswordField p1;
    private Font f,f2;
    private ButtonGroup grp;

    private ImageIcon icon;
    private JComboBox cb1;

    UpdateInfo2(){
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,650);
        this.setLocationRelativeTo(null);
        this.setTitle("Update Information");

        c=this.getContentPane();
        c.setLayout(null);

        Color color=new Color(136, 4, 4);
        c.setBackground(color);

        icon = new ImageIcon(getClass().getResource("image.jpeg"));
        this.setIconImage(icon.getImage());

        f=new Font("Times New Roman",Font.BOLD,14);
        f2=new Font("Times New Roman",Font.BOLD,16);
        l1=new JLabel("Name :");
        l1.setBounds(30,20,150,50);
        l1.setForeground(Color.white);
        l1.setFont(f);
        c.add(l1);

        l2=new JLabel("Age :");
        l2.setBounds(30,80,150,50);
        l2.setForeground(Color.white);
        l2.setFont(f);
        c.add(l2);

        l3=new JLabel("Phone :");
        l3.setBounds(30,140,150,50);
        l3.setForeground(Color.white);
        l3.setFont(f);
        c.add(l3);

        l4=new JLabel("Address :");
        l4.setBounds(30,190,150,50);
        l4.setForeground(Color.white);
        l4.setFont(f);
        c.add(l4);

        l5=new JLabel("Blood Group :");
        l5.setBounds(30,250,150,50);
        l5.setForeground(Color.white);
        l5.setFont(f);
        c.add(l5);

        l6=new JLabel("Last Donate(yyyy-mm-dd):");
        l6.setBounds(30,310,200,50);
        l6.setFont(f);
        l6.setForeground(Color.white);
        c.add(l6);

        t1=new JTextField();
        t1.setBounds(230,20,200,50);
        t1.setForeground(new Color(136,4,4));
        t1.setFont(f);
        c.add(t1);


        t2=new JTextField();
        t2.setBounds(230,80,200,50);
        t2.setForeground(new Color(136,4,4));
        t2.setFont(f);
        c.add(t2);

        t3=new JTextField();
        t3.setBounds(230,140,200,50);
        t3.setForeground(new Color(136,4,4));
//        t3.setForeground(new Color(136,4,4));
        t3.setFont(f);
        c.add(t3);

        t4=new JTextField();
        t4.setBounds(230,195,200,50);
        t4.setForeground(new Color(136,4,4));
        t4.setFont(f);
        c.add(t4);

        String [] bgarray={"A+","A-","B+","B-","AB+","AB-","O+","O-"};
        cb1=new JComboBox(bgarray);
        cb1.setBounds(230,250,200,50);
        cb1.setForeground(new Color(136,4,4));
        cb1.setFont(f);
        c.add(cb1);

        t6=new JTextField();
        t6.setBounds(230,310,200,50);
        t6.setForeground(new Color(136,4,4));
        t6.setFont(f);
        c.add(t6);

        b1=new JButton("Update");
        b1.setBackground(Color.white);
        b1.setForeground(color);
        b1.setFont(f);
        b1.setBounds(200,470,100,40);
        c.add(b1);

        b2=new JButton("Back To Previous Page");
        b2.setBackground(Color.white);
        b2.setForeground(color);
        b2.setFont(f);
        b2.setBounds(145,520,200,40);
        c.add(b2);


        rb1=new JRadioButton("Male");
        rb1.setForeground(color);
        rb1.setFont(f);
        rb1.setBounds(100,400,100,40);
        rb2=new JRadioButton("Female");
        rb2.setForeground(color);
        rb2.setFont(f);
        rb2.setBounds(300,400,100,40);
        c.add(rb1);
        c.add(rb2);

        grp=new ButtonGroup();
        grp.add(rb1);
        grp.add(rb2);


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File fr = new File("Information.text");
                    Scanner sc = new Scanner(fr);
                    int count = 0;
                    while (sc.hasNextLine()) {
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
                    sc.close();


                    UpdateInfo frame=new UpdateInfo();
                    String phone= frame.getPhone();



                    int found = -1;

                    for ( int j = 0; j < count; j++) {
                        if (arr[j].getPhone().equals(phone)) {
                            found = j;
                            break;
                        }
                    }

                    System.out.println(found);
                if(found>=0){
                    String gender="m";
                    if(rb1.isSelected()){
                        gender="Male";
                    }else if(rb2.isSelected()){
                        gender="Female";
                    }

                    String bloodgroup = cb1.getItemAt(cb1.getSelectedIndex()).toString();

                    arr[found].setName(t1.getText());
                    arr[found].setAge(Integer.parseInt(t2.getText()));
                    arr[found].setPhone(t3.getText());
                    arr[found].setGender(gender);
                    arr[found].setAdd(t4.getText());
                    arr[found].setBg(bloodgroup);
                    arr[found].setDate(t6.getText());


                  Doners  dn= new Doners(arr[found].getName(), arr[found].getAge(),
                          arr[found].getPhone(), arr[found].getGender() ,
                          arr[found].getAdd(), arr[found].getBg(), arr[found].getDate());


                    if (t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() ||
                            t4.getText().isEmpty() || t6.getText().isEmpty() || gender.isEmpty()) {

                        JOptionPane.showMessageDialog(null, "Fill Up All The Information", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {

                        System.out.println(dn);
                        if (found != -1) {
                            for (int k = found; k < count-1 ; k++) {
                                Doners temp = arr[k];
                                arr[k] = arr[k + 1];
                            }
                            arr[count - 1] = dn;

                            FileWriter fw2= new FileWriter("Information.text");

                            for(int l = 0; l< count; l++){
                                fw2.write(arr[l].getName() + "\t"+ arr[l].getAge()+ "\t"+
                                        arr[l].getPhone() + "\t"+arr[l].getGender()+"\t"+arr[l].getAdd()
                                        +"\t"+ arr[l].getBg()+"\t"+ arr[l].getDate()+"\n");}
                            fw2.close();
                            JOptionPane.showMessageDialog(null,"done");
                            dispose();
                            MainWindo frame2=new MainWindo();
                            frame2.setVisible(true);

                        }else{
                            JOptionPane.showMessageDialog(null, "Phone number not found", "login", 0);
                        }

                    }
//                    System.out.println(dn);
//                    if (found != -1) {
//                        for (int k = found; k < count-1 ; k++) {
//                            Doners temp = arr[k];
//                            arr[k] = arr[k + 1];
//                        }
//                        arr[count - 1] = dn;
//
//                        FileWriter fw2= new FileWriter("Information.text");
//
//                        for(int l = 0; l< count; l++){
//                            fw2.write(arr[l].getName() + "\t"+ arr[l].getAge()+ "\t"+
//                                    arr[l].getPhone() + "\t"+arr[l].getGender()+"\t"+arr[l].getAdd()
//                                    +"\t"+ arr[l].getBg()+"\t"+ arr[l].getDate()+"\n");}
//                        fw2.close();
//
//                    }else{
//                        JOptionPane.showMessageDialog(null, "Phone number not found", "login", 0);
//                    }

//                    FileWriter fw2= new FileWriter("Information.text");
//
//                    for(int l = 0; l< count; l++){
//                        fw2.write(arr[l].getName() + "\t"+ arr[l].getAge()+ "\t"+
//                                arr[l].getPhone() + "\t"+arr[l].getGender()+"\t"+arr[l].getAdd()
//                                +"\t"+ arr[l].getBg()+"\t"+ arr[l].getDate()+"\n");
//                    }
//                    fw2.close();

                        }

//                    dispose();
//                    MainWindo frame2=new MainWindo();
//                    frame2.setVisible(true);

                }catch(Exception e1){
                    e1.printStackTrace();
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


}
