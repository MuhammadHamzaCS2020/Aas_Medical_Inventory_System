import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class AasDispensaryInfo {
	JFrame jf;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton b1,b2,b3;

	AasDispensaryInfo(){
		jf=new JFrame();

		jf.setLayout(null);

		l1 = new JLabel("AAS MEDICAL DISPENSARY");
		l1.setFont(new Font("Times New Roman",Font.BOLD,30));
		l1.setBounds(200,30,600,40);
		l1.setForeground(Color.blue);
		jf.add(l1);



		l2 = new JLabel("This System developed by,");
		l2.setFont(new Font("Times New Roman",Font.BOLD,20));
		l2.setBounds(100,150,600,40);
		jf.add(l2);

		l3 = new JLabel("Muhammad Hamza");
		l3.setFont(new Font("Times New Roman",Font.BOLD,30));
		l3.setBounds(300,200,400,40);
		l3.setForeground(Color.red);
		jf.add(l3);

		l5 = new JLabel("This System you can use for Dispensary or Medical Store Record");
		l5.setFont(new Font("Times New Roman",Font.BOLD,20));
		l5.setBounds(100,300,800,40);
		jf.add(l5);

		l6 = new JLabel("We can also upadte,delete & search the existing details.");
		l6.setFont(new Font("Times New Roman",Font.BOLD,20));
		l6.setBounds(100,350,800,40);
		jf.add(l6);

//		l7 = new JLabel("It is helpfull for stock of Medicine & whrere we placed the medicine in store.");
//		l7.setFont(new Font("Times New Roman",Font.BOLD,20));
//		l7.setBounds(100,400,800,40);
//		jf.add(l7);

		jf.setTitle("About Dispensary ");
		jf.setSize(900,700);
		jf.setLocation(20,20);
		jf.setResizable(false);
		jf.getContentPane().setBackground(Color.green);
		jf.setVisible(true);
	}
//	public static void main(String[] args) {
//		new AasDispensaryInfo();
//	}
}
