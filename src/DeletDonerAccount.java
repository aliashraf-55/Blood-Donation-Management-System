import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class DeletDonerAccount extends JFrame {

    private Container c;
    private JLabel l1,l2;
    private JTextField t1;
    private JButton b1,b2,b3;
    private Font f,f2;
    private ImageIcon icon;


    DeletDonerAccount(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setTitle("Delete Account");

        icon = new ImageIcon(getClass().getResource("image.jpeg"));
        this.setIconImage(icon.getImage());


        f=new Font("Times New Roman",Font.BOLD,18);
        f2=new Font("Times New Roman",Font.BOLD,16);

        c=this.getContentPane();
        c.setLayout(null);
        Color color=new Color(136, 4, 4);
        c.setBackground(color );

        l1=new JLabel("Enter your number to delete your account");
        l1.setBounds(85,50,400,50);
        l1.setForeground(Color.white);
        l1.setFont(f);
        c.add(l1);

        l2=new JLabel("Are you sure you want to delete your account?");
        l2.setBounds(70,190,400,50);
        l2.setForeground(Color.white);
        l2.setFont(f);
        c.add(l2);

        t1=new JTextField();
        t1.setBounds(155,125,170,30);
        t1.setForeground(new Color(136,4,4));
        t1.setFont(f);
        c.add(t1);

        b1=new JButton("YES");
        b1.setBounds(115,275,100,30);
        b1.setForeground(color);
        b1.setFont(f2);
        c.add(b1);

        b2=new JButton("NO");
        b2.setBounds(265,275,100,30);
        b2.setForeground(color);
        b2.setFont(f2);
        c.add(b2);

        b3=new JButton("Back To Previous Page");
        b3.setBounds(150,340,200,30);
        b3.setForeground(color);
        b3.setFont(f2);
        c.add(b3);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String phone = t1.getText();
                    File fr = new File("Information.text");
                    Scanner sc = new Scanner(fr);
                    int count = 0;
                    while (sc.hasNext()) {
                        String nm = sc.nextLine();
                        count++;
                    }

                    Doners[] arr =new Doners[count];
                    sc = new Scanner(fr);
                    int i = 0;
                    while(sc.hasNext())
                    {
                        String n = sc.next();
                        int a = sc.nextInt();
                        String n1 = sc.next();
                        String g=sc.next();
                        String n2 = sc.next();
                        String n3= sc.next();
                        String n4 = sc.next();
                        arr[i]=new Doners(n,a,n1,g,n2,n3,n4);
                        i++;
                    }
                    sc.close();


//                    FileWriter fw = new FileWriter("Information.text");
                    int found=-1;
                    for(int j = 0; j< count; j++) {
                        if(arr[j].getPhone().equals(phone)){
                            found=j;
                            break;
                        }
                    }
                    if (found != -1) {
                        for (int k = found; k < count-1 ; k++) {
                            Doners temp = arr[k];
                            arr[k] = arr[k + 1];
                        }
                        arr[count - 1] = null;
                        JOptionPane.showMessageDialog(null,"Delete Successfull");

                        FileWriter fw = new FileWriter("Information.text");

                        for(int l = 0; l< count-1; l++){
                            fw.write(arr[l].getName() + "\t"+ arr[l].getAge()+ "\t"+
                                    arr[l].getPhone() + "\t"+arr[l].getGender()+"\t"+arr[l].getAdd()
                                    +"\t"+ arr[l].getBg()+"\t"+ arr[l].getDate()+"\n");
                        }

                        fw.close();
                    }else{

                        JOptionPane.showMessageDialog(null,"Number Not Found");
                    }

//                    FileWriter fw = new FileWriter("Information.text");
//
//                    for(int l = 0; l< count-1; l++){
//                        fw.write(arr[l].getName() + "\t"+ arr[l].getAge()+ "\t"+
//                                arr[l].getPhone() + "\t"+arr[l].getGender()+"\t"+arr[l].getAdd()
//                                +"\t"+ arr[l].getBg()+"\t"+ arr[l].getDate()+"\n");
//                    }
//
//                    fw.close();

                }catch(Exception e1){
                    System.out.println(e1);
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
                dispose();
                MainWindo frame=new MainWindo();
                frame.setVisible(true);
            }
        });



    }


    public static void main(String[] args) {
        DeletDonerAccount frame=new DeletDonerAccount();
        frame.setVisible(true);
    }
}
