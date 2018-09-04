import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class MedicineList extends AbstractMedicine{	
	private JInternalFrame jf;
	private JLabel ln;
	private PreparedStatement ps;
	

	public MedicineList(){
		jf= new JInternalFrame( 
				"Medicine Details", true, true, true, true );

		jf.setLayout(null);

		ln=new JLabel("Medicine details");
		ln.setFont(new Font("Times New Roman",Font.BOLD,40));
		ln.setForeground(Color.black);
		ln.setBounds(300,30,400,40);
		jf.add(ln);
		scrlPane.setBounds(0,80,900,600);
		jf.add(scrlPane);
		tableGrid.setFont(font);

		jf.setTitle("Medicine Details");
		jf.setSize(910,700);
		jf.setLocation(290,10);

		for(int i=0; i<SIZE; i++){
			modelTable.addColumn(modelTableLabels[i]);
		}
		int record=0;
		try{

			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,user,password);
			System.out.println("Connected to database.");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("select * from medicine");
			while(rs.next()){
				modelTable.insertRow(record++,new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)});

			}
			con.close();
		}
		catch(SQLException se)
		{
			System.err.println(se);
			JOptionPane.showMessageDialog(null,"SQL Error:"+se);
		}
		catch(Exception e)
		{
			System.err.println(e);
			JOptionPane.showMessageDialog(null,"Error:"+e);
		}

		refference.outerPane.add(jf);
		jf.setResizable(false);
		jf.getContentPane().setBackground(Color.green);
		jf.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public boolean checkEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
}
