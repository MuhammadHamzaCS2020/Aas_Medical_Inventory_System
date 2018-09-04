import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;

public class OuterFrame extends JFrame implements ActionListener{
	//private ArrayList<JMenu> addMenu = new ArrayList<>();
	final int SIZE=5;
	JDesktopPane outerPane;
	private JMenuBar menubar;

	private JMenu[] addMenu=new JMenu[SIZE-1];
	private String[] menuName={"Medicine","Report","About","Help"}; 

	private JMenuItem[] menuItem0=new JMenuItem[SIZE];
	private String[] menuItemName0={"Add New","Search","Update","Delete","Stock"};
	private String[] menuitemImage0={"images//addnew.png","images//search.png","images//update.png",
			"images//delete.png","images//all.png"};
	//	private JButton[] buttons0=new JButton[SIZE];

	private JMenuItem[] menuItem1=new JMenuItem[SIZE-4];
	private String[] menuItemName1={"Medicine Report"};
	private String menuitemimage1= "images//report.png";
	//	private JButton[] buttons1=new JButton[SIZE];

	private JMenuItem[] menuItem2=new JMenuItem[SIZE-3];
	private String[] menuitemName2={"Dispensary","Developer"};
	private String[] menuitemimage2={"images//help.png","images//help.png"};
	//	private JButton[] buttons2=new JButton[SIZE-3];

	private JMenuItem[] menuItem3=new JMenuItem[SIZE-3];
	private String[] menuitemName3={"Help","Exit"};
	private String[] menuitemimage3={"images//help.png","images//exit.png"};
	//	private JButton[] buttons3=new JButton[SIZE-3];
	
	private static OuterFrame singleObject;
	public static OuterFrame getouterFrameObject(){
		if(singleObject==null){
			singleObject=new OuterFrame();
		}
		return singleObject;
	}
	private OuterFrame(){
		super( "AAS DISPENSARY" );

		outerPane = new JDesktopPane();   // create pane for outer frame

		menubar=new JMenuBar();
		addMenu[0]=new JMenu(menuName[0]);
		int k=15;
		for(int i=0; i<SIZE; i++){
			menuItem0[i]=new JMenuItem(menuItemName0[i],new ImageIcon(menuitemImage0[i]));
			menuItem0[i].addActionListener(this);
			addMenu[0].add(menuItem0[i]);
		}

		addMenu[1]=new JMenu(menuName[1]);
		for(int i=0; i<menuItemName1.length; i++){
			menuItem1[i]=new JMenuItem(menuItemName1[i],new ImageIcon(menuitemimage1));
			menuItem1[i].addActionListener(this);
			addMenu[1].add(menuItem1[i]);
		}

		addMenu[2]=new JMenu(menuName[2]);
		for(int i=0; i<SIZE-3; i++){
			menuItem2[i]=new JMenuItem(menuitemName2[i],new ImageIcon(menuitemimage2[i]));
			menuItem2[i].addActionListener(this);
			addMenu[2].add(menuItem2[i]);
		}

		addMenu[3]=new JMenu(menuName[3]);
		for(int i=0; i<SIZE-3; i++){
			menuItem3[i]=new JMenuItem(menuitemName3[i],new ImageIcon(menuitemimage3[i]));
			menuItem3[i].addActionListener(this);
			addMenu[3].add(menuItem3[i]);
		}
		for(int i=0; i<menuName.length; i++){
			menubar.add( addMenu[i] ); // add Add menu to menu bar
		}
		setJMenuBar( menubar ); // set menu bar of outer frame
		add(outerPane); // add this pane to the outer frame

		//		menubar = new JMenuBar(); // create menu bar
		//		addMenu = new JMenu( "New" ); // create Add menu
		//		newFrame = new JMenuItem( "Customer" );
		//
		//		addMenu.add(newFrame); // add menu item to Add menu


		//		newFrame.addActionListener(new ActionListener()	{  
		//			public void actionPerformed( ActionEvent event ){
		//				// create internal frame
		//				System.out.println(event.getSource());
		//				System.out.println(newFrame);
		//
		//				if(event.getSource()==newFrame){
		//					JInternalFrame frame = new JInternalFrame( 
		//							"CLIENT INTERFACE", true, true, true, true );
		//
		//					//CustomerGUI customer = new CustomerGUI();  // Creation of New Customer with GUI
		//					//	frame.add(customer);
		//					frame.pack();         // set internal frame to size of contents
		//					frame.setSize(500,350); //set frame size
		//					outerPane.add( frame ); // add internal frame to outer frame
		//					frame.setVisible( true ); // show internal frame
		//				}
		//				else{
		//					System.out.println("Hi");
		//				}
		//			} 
		//		}); 
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==menuItem0[0]){
			new AddNewMedicine();
		}
		else if(arg0.getSource()==menuItem0[1]){
			new SearchMedicine();
		}
		else if(arg0.getSource()==menuItem0[2]){
			new UpdateMedicine();
		}
		else if(arg0.getSource()==menuItem0[3]){
			new DeleteMedicine();
		}
		else if(arg0.getSource()==menuItem0[4]){
			new MedicineList();
		}
		else if(arg0.getSource()==menuItem1[0]){
			new DailyPurchaseReport();
		}
		else if(arg0.getSource()==menuItem2[0]){
//			new DeveloperInfo();
		}
		else if(arg0.getSource()==menuItem2[1]){
	//		new AasDispensaryInfo();
		}
		else if(arg0.getSource()==menuItem3[0]){
			new Help();
		}
		else if(arg0.getSource()==menuItem3[1]){
			System.exit(0);
		}



	}
} 












//
//public OuterFrame(){
//	super( "AAS DISPENSARY" );
//
//	outerPane = new JDesktopPane();   // create pane for outer frame
//
//	menubar=new JMenuBar();
//	addMenu[0]=new JMenu(menuName[0]);
//	int k=15;
//	for(int i=0; i<SIZE; i++){
//		menuItem0[i]=new JMenuItem(menuItemName0[i],new ImageIcon(menuitemImage0[i]));
//		menuItem0[i].addActionListener(this);
//		addMenu[0].add(menuItem0[i]);
//		buttons0[i]=new JButton(menuItemName0[i],new ImageIcon(menuitemImage0[i]));
//		buttons0[i].addActionListener(this);
//		buttons0[i].setBounds(15,k,150,30);
//		outerPane.add(buttons0[i]);
//		k+=35;
//
//	}
//
//	addMenu[1]=new JMenu(menuName[1]);
//	for(int i=0; i<SIZE; i++){
//		menuItem1[i]=new JMenuItem(menuItemName1[i],new ImageIcon(menuitemimage1));
//		menuItem1[i].addActionListener(this);
//		addMenu[1].add(menuItem1[i]);
//		buttons1[i]=new JButton(menuItemName1[i],new ImageIcon(menuitemimage1));
//		buttons1[i].addActionListener(this);
//		buttons1[i].setBounds(15,k,150,30);
//		outerPane.add(buttons1[i]);
//		k+=35;
//	}
//
//	addMenu[2]=new JMenu(menuName[2]);
//	for(int i=0; i<SIZE-3; i++){
//		menuItem2[i]=new JMenuItem(menuitemName2[i],new ImageIcon(menuitemimage2[i]));
//		menuItem2[i].addActionListener(this);
//		addMenu[2].add(menuItem2[i]);
//		buttons2[i]=new JButton(menuitemName2[i],new ImageIcon(menuitemimage2[i]));
//		buttons2[i].addActionListener(this);
//		buttons2[i].setBounds(15,k,150,30);
//		outerPane.add(buttons2[i]);
//		k+=35;
//	}
//
//	addMenu[3]=new JMenu(menuName[3]);
//	for(int i=0; i<SIZE-3; i++){
//		menuItem3[i]=new JMenuItem(menuitemName3[i],new ImageIcon(menuitemimage3[i]));
//		menuItem3[i].addActionListener(this);
//		addMenu[3].add(menuItem3[i]);
//		buttons3[i]=new JButton(menuitemName3[i],new ImageIcon(menuitemimage3[i]));
//		buttons3[i].addActionListener(this);
//		buttons3[i].setBounds(15,k,150,30);
//		outerPane.add(buttons3[i]);
//		k+=35;
//	}
