import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Authentication implements ActionListener{
	private JFrame jframe;
	private final int SIZE=4;
	private String[] buttonsimagelink={"images//Login.png","images//clear.png","images//exit.png"};
	private String[] buttonslabel={"Login","Clear","Exit"};
	private JButton[] buttons=new JButton[SIZE-1];
	private JLabel ShopeName;
	private JLabel userimage,username,userpass,passimage;
	private MyTextField logintextfield;
	private JPasswordField passwordtextfield;
	private Font font;
	private OuterFrame outerFrame;
	int cnt=0,cnt1=0;
	

	Authentication(){
		jframe=new JFrame();
		font = new Font("Impact",Font.BOLD,20);
		jframe.setLayout(null);

		ShopeName = new JLabel("AAS DISPENSARY");
		ShopeName.setFont(new Font("Impact",Font.BOLD,40));
		ShopeName.setBounds(250,100,300,40);
		jframe.add(ShopeName);

		userimage = new JLabel(new ImageIcon("images//users.png"));
		userimage.setBounds(150,250,50,25);
		jframe.add(userimage);

		username = new JLabel("User Name : "); 
		username.setFont(font);
		username.setBounds(200,250,200,25);
		jframe.add(username);

		logintextfield = new MyTextField(20);
		logintextfield.setBounds(350,250,200,25);
		//t1.setToolTipText("Enter Username");
		jframe.add(logintextfield);

		passimage = new JLabel(new ImageIcon("images//pass.png"));
		passimage.setBounds(150,300,50,25);
		jframe.add(passimage);

		userpass = new JLabel("Password  : "); 
		userpass.setFont(font);
		userpass.setBounds(200,300,200,25);
		jframe.add(userpass);

		passwordtextfield = new JPasswordField(20);
		passwordtextfield.setBounds(350,300,200,25);
		//p1.setToolTipText("Enter Password");
		jframe.add(passwordtextfield);

		int buttonsadjust=200;
		for(int i=0; i<buttonslabel.length; i++){
			buttons[i] = new JButton(buttonslabel[i],new ImageIcon(buttonsimagelink[i]));
			buttons[i].setBounds(buttonsadjust,400,100,35);
			jframe.add(buttons[i]);
			buttons[i].addActionListener(this);
			buttonsadjust+=120;
		}
		jframe.setTitle("AAS DISPENSARY / LOGIN");
		jframe.setLocation(50,50);
		jframe.setSize(800,600);
		jframe.setResizable(true);
		jframe.getContentPane().setBackground(Color.LIGHT_GRAY);
		jframe.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==buttons[0]){		
			String s0=logintextfield.getText();
			String s1=new String(passwordtextfield.getPassword());
			if( (s0.equals("admin")) && (s1.equals("admin")) ){	
//				JOptionPane.showMessageDialog(null," Welcome !!! You are valid user ...!!!  ","WELCOME",JOptionPane.INFORMATION_MESSAGE);
				jframe.setVisible(false);
				//new MainMenu();
				outerFrame= OuterFrame.getouterFrameObject();  
				outerFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				outerFrame.setSize( 1200, 700); 
				outerFrame.setVisible( true ); 
			}
			else{
				JOptionPane.showMessageDialog(null,"User Name or Password invalid !  ","WRONG",JOptionPane.INFORMATION_MESSAGE);
			}
		}

		else if(arg0.getSource()==buttons[1])
		{
			username=null;
			passwordtextfield=null;
		}

		else if(arg0.getSource()==buttons[2])
		{
			System.exit(0);
		}

	}

}
