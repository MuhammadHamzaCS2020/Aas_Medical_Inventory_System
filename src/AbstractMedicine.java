import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public abstract class AbstractMedicine implements ActionListener {
	final int SIZE=12;
	final int butSIZE=3;
	OuterFrame refference=OuterFrame.getouterFrameObject();
	Label[] label=new Label[SIZE];
	MyTextField[] textfield=new MyTextField[SIZE];
	final String[] labelNames={"Medicine Batch no","Medicine name","Medicine company","Medicine quantity",
		"Med expiry date","Med purchase date","Medicine type","Medicine purchase price",
		"Medicine sale price","Medicine rack no","Supplier name","Supplier ID"};
	final String[] comboxName={"Select Type","Tablet","Capsule","Syrup","Insulin","Cream","Balm","Drop",
			                   "Granul","Oil","Powder"};
	
	// Buttons Part Variables...
	JButton[] buttons=new JButton[butSIZE]; 
	String[] buttonsImages={"images//save.png","images//clear.png","images//all.png"};
	
	// For DataBase Table Variables
	protected static final String url = "jdbc:mysql://localhost:3306/MedicalStore";
	protected static final String user = "root";
	protected static final String password = "root";

	protected static Connection con;
	protected static Statement stmt;
	protected static ResultSet rs;
	String[] modelTableLabels={"BATCH NO","NAME","COMPANY","QUANTITY","EXPDATE","PURDATE",
								"TYPE","SALEPRICE","PURPRICE","RACK NO","SUP ID","SUP NAME"};
	// DB PArts Variables

	
	// Internal Frame parts
	protected JLabel ln;
	protected Font font = new Font("Times New Roman",Font.BOLD,15);
	protected DefaultTableModel modelTable = new DefaultTableModel();
	protected JTable tableGrid = new JTable(modelTable);
	protected JScrollPane scrlPane = new JScrollPane(tableGrid);
	
	// Abstract Methods...
	public abstract boolean checkEmpty();
}
