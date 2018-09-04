import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class AddNewMedicine extends AbstractMedicine{
	private JInternalFrame jf; 
	private String[] buttonName={"Save","Clear","All"}; 
	private String medicineType=null;
	private JComboBox msname,tabtype;
	private String s,sid1,tabt;
	private Date date1;
	private GregorianCalendar calendar;
	private String strDate;

	private PreparedStatement ps;


	AddNewMedicine(){
		jf= new JInternalFrame( 
				"Add New Medicine", true, true, true, true );
		jf.setLayout(null);

		ln=new JLabel("New Medicine details");
		ln.setFont(new Font("Times New Roman",Font.BOLD,40));
		ln.setForeground(Color.black);
		ln.setBounds(300,30,400,40);
		jf.add(ln);

		int k=100;
		for(int i=0; i<labelNames.length-6; i++){
			label[i] = new Label(labelNames[i]+"*");
			label[i].setBounds(50,k,200,25);
			label[i].setFont(font);
			jf.add(label[i]);
			textfield[i] = new MyTextField(20);
			textfield[i].setBounds(250,k,120,25);
			//t1.setToolTipText("Enter medicine batch no");
			jf.add(textfield[i]);
			k+=40;	
		}

		k=100;
		for(int i=6; i<labelNames.length; i++){
			label[i] = new Label(labelNames[i]+"*");		
			label[i].setBounds(470,k,200,25);
			label[i].setFont(font);
			jf.add(label[i]);

			if(i==6){
				tabtype=new JComboBox();
				for(int j=0; j<comboxName.length; j++){
					tabtype.addItem(comboxName[j]);
				}
				tabtype.setBounds(700,k,120,25);
				tabtype.setToolTipText("Select medicine type");
				jf.add(tabtype);
				tabtype.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						medicineType =(String)tabtype.getSelectedItem();
					}
				});
				jf.add(tabtype);
			}
			else {
				textfield[i] = new MyTextField(20);
				textfield[i].setBounds(700,k,120,25);
				jf.add(textfield[i]);	
			}			
			k+=40;
		}


		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,user,password);
			System.out.println("Connected to database.");
			ps=con.prepareStatement("select sname from supplier");
			rs=ps.executeQuery();
			while(rs.next()){
				String sname1=rs.getString(1);
				msname.addItem(sname1);
			}

			con.close();
		}
		catch(SQLException se){
			System.out.println(se);
		}
		catch(Exception e){
			System.out.println(e);
		}
		// Buttons Loading...
		int j=250;
		for(int i=0; i<buttonName.length; i++){
			buttons[i]=new JButton(buttonName[i],new ImageIcon(buttonsImages[i]));
			buttons[i].setBounds(j,330,110,35);
			buttons[i].addActionListener(this);
			jf.add(buttons[i]);
			j+=150;

		}

		scrlPane.setBounds(0,380,900,600);
		jf.add(scrlPane);
		tableGrid.setFont(font);

		for(int i=0; i<SIZE; i++){
			modelTable.addColumn(modelTableLabels[i]);
		}
		jf.setTitle("Add New Medicine ");
		jf.setSize(910,700);
		jf.setLocation(290,10);
		refference.outerPane.add(jf);
		jf.setResizable(true);
		jf.getContentPane().setBackground(Color.green);
		jf.setVisible(true);
	}

	public boolean checkEmpty(){
		for(int i=0; i<textfield.length; i++){
			if(i==7)
				continue;
			if(textfield[i].getText().equals("")){
				return false;
			}
		}
		return true;
	}

	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==buttons[0]){
			try{
				if(checkEmpty()){
					JOptionPane.showMessageDialog(null,"* Details are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
				}
				else{
					float a=Float.parseFloat(textfield[7].getText());
					float b=Float.parseFloat(textfield[8].getText());
					if(b<a){
						JOptionPane.showMessageDialog(null,"sale price should be greater than puchase price!","Warning!!!",JOptionPane.WARNING_MESSAGE);
					}
					else{

						Class.forName("com.mysql.jdbc.Driver");
						con=DriverManager.getConnection(url,user,password);
						System.out.println("Connected to database.");

						ps=con.prepareStatement("Select sid from supplier where sname='"+s+"'");
						rs=ps.executeQuery();
						while(rs.next()){
							sid1=rs.getString(1);
						}
						ps=con.prepareStatement("insert into medicine (mbno,mname,mcompany,mqty,mexpdate,mpurdate,mtype,mpurprice,msaleprice,mrackno,sid,sname)values(?,?,?,?,?,?,?,?,?,?,?,?)");

						ps.setString(1,textfield[0].getText());
						ps.setString(2,textfield[1].getText());
						ps.setString(3,textfield[2].getText());
						ps.setInt(4,Integer.parseInt(textfield[3].getText()));
						ps.setString(5,textfield[4].getText());
						ps.setString(6,textfield[5].getText());
						ps.setString(7,medicineType);
						ps.setFloat(8,Float.parseFloat(textfield[7].getText()));
						ps.setFloat(9,Float.parseFloat(textfield[8].getText()));
						ps.setString(10,textfield[9].getText());
						ps.setInt(11,Integer.parseInt(sid1));
						ps.setString(12,s);
						ps.executeUpdate();

						int reply=JOptionPane.showConfirmDialog(null,"Medicine added successfully.Do you want add more Medicines?","Added Medicine",JOptionPane.YES_NO_OPTION);

						if (reply == JOptionPane.YES_OPTION){
							jf.setVisible(false);
							new AddNewMedicine();
						}
						else if (reply == JOptionPane.NO_OPTION){
							jf.setVisible(false);
						}
					}
				}

				con.close();
			}
			catch(SQLException se){
				System.out.println(se);
				JOptionPane.showMessageDialog(null,"SQL Error:"+se);
			}
			catch(Exception e){
				System.out.println(e);
				JOptionPane.showMessageDialog(null,"Error:"+e);
			}

		}
		else if(ae.getSource()==buttons[1]){   
			for(int i=0; i<textfield.length; i++){
				textfield[i].setText("");
			}
		}

		else if(ae.getSource()==buttons[2]){//list
			int r = 0;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(url,user,password);
				System.out.println("Connected to database.");
				stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rs = stmt.executeQuery("SELECT * from medicine" );
				while(rs.next()){
					modelTable.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12) });
				}
				con.close();
			}
			catch(SQLException se){
				System.out.println(se);
				JOptionPane.showMessageDialog(null,"SQL Error:"+se);
			}
			catch(Exception e){
				System.out.println(e);
				JOptionPane.showMessageDialog(null,"Error:"+e);
			}
		}
	}

}

