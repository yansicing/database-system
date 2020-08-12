package databse.query;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

//��Ա���Ų�ѯԱ����Ϣģ�����//
public class SnoQueryForm extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	JLabel labNum=new JLabel("Ա���ţ�");
    JLabel labName=new JLabel("Ա��������");
    JLabel labID=new JLabel("Ա�����֤�ţ�");
    JLabel labSex=new JLabel("Ա���Ա�");
    JLabel labAge=new JLabel("Ա�����䣺");
    JLabel labJob=new JLabel("Ա��ְλ��");
    JLabel labDep=new JLabel("Ա�����ڲ��ţ�");
    JLabel labSer=new JLabel("Ա��������Ŀ��Χ��");
    JLabel labTel=new JLabel("Ա����ϵ�绰��");
    JLabel labAddress=new JLabel("Ա��סַ��");
    
    JTextField txtNum=new JTextField(10);
    JTextField txtName=new JTextField(8);
    JTextField txtID=new JTextField(18);
    JTextField txtSex=new JTextField(2);
    JTextField txtAge=new JTextField(2);
    JTextField txtJob=new JTextField(8);
    JTextField txtDep=new JTextField(10);
    JTextField txtSer=new JTextField(20);
    JTextField txtTel=new JTextField(11);
    JTextField txtAddress=new JTextField(25);
    
	JButton btnCancel=new JButton("ȡ��");
	JButton btnQuery=new JButton("��ѯ");
	
	JPanel pan=new JPanel();
	JPanel pan1=new JPanel();
	JPanel pan2=new JPanel();
	JPanel pan3=new JPanel();
	JPanel pan4=new JPanel();
	JPanel pan5=new JPanel();
	JPanel pan6=new JPanel();
	JPanel pan7=new JPanel();
	JPanel pan8=new JPanel();
	JPanel pan9=new JPanel();
	JPanel pan10=new JPanel();
	JPanel pan11=new JPanel();;
	
	Connection cnn;
	Statement stm;
	ResultSet rs;
	
	public SnoQueryForm()
	{
	   super("��Ա���Ų�ѯ");
	   
	   setSize(400,500);
	   setLocation(500,50);
	   
	   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   
	   pan.setBorder(BorderFactory.createEtchedBorder());
	   
	   pan1.add(labNum);
	   pan1.add(txtNum);
	   
	   pan2.add(labName);
	   pan2.add(txtName);
	   
	   pan3.add(labID);
	   pan3.add(txtID);
	   
	   pan4.add(labSex);
	   pan4.add(txtSex);
	   
	   pan5.add(labAge);
	   pan5.add(txtAge);
	   
	   pan6.add(labJob);
	   pan6.add(txtJob);
	   
	   pan7.add(labDep);
	   pan7.add(txtDep);
	   
	   pan8.add(labSer);
	   pan8.add(txtSer);
	   
	   pan9.add(labTel);
	   pan9.add(txtTel);
	   
	   pan10.add(labAddress);
	   pan10.add(txtAddress);
	   
	   pan11.add(btnQuery);
	   pan11.add(btnCancel);
	   
	   pan.setLayout(new GridLayout(10,1));
	   
	   pan.add(pan1);
	   pan.add(pan2);
	   pan.add(pan3);
	   pan.add(pan4);
	   pan.add(pan5);
	   pan.add(pan6);
	   pan.add(pan7);
	   pan.add(pan8);
	   pan.add(pan9);
	   pan.add(pan10);
	   
	   getContentPane().add(pan,"Center");
	   getContentPane().add(pan11,"South");
	   
	   btnQuery.addActionListener(this);
	   btnCancel.addActionListener(this);
	   
	   txtName.setEditable(false);
	   txtID.setEditable(false);
	   txtSex.setEditable(false);
	   txtAge.setEditable(false);
	   txtJob.setEditable(false);
	   txtDep.setEditable(false);
	   txtSer.setEditable(false);
	   txtTel.setEditable(false);
	   txtAddress.setEditable(false);
	   
	   setVisible(true);
	   
	   txtNum.requestFocus();

	}
	public void actionPerformed(ActionEvent ae)
	{
	   if(ae.getSource()==btnCancel)
	   {
	       try 
	       {
	           if(stm!=null)
	               stm.close();
	           if(cnn!=null)
	               cnn.close();
	       } 
	       catch (SQLException ex) 
	       {
	           ex.printStackTrace();
	       }
	       this.dispose();
	   } 
	   else if(ae.getSource()==btnQuery)
	   {
	       try
	       {   	   
	    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	           
	    	   cnn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=database","sd","123");
	          
	    	   stm=cnn.createStatement();
	           rs=stm.executeQuery("select * from Staff where Sno='"+txtNum.getText()+"'");
	          
	           if(rs.next())
	           {
	          	   txtNum.setText(rs.getString("Sno"));
	               txtName.setText(rs.getString("Sname"));
	               txtID.setText(rs.getString("Sid"));
	               txtSex.setText(rs.getString("Ssex"));
	               txtAge.setText(rs.getString("Sage"));
	               txtJob.setText(rs.getString("Spost"));
	               txtDep.setText(rs.getString("Sbranch"));
	               txtSer.setText(rs.getString("Sfanwei"));
	               txtTel.setText(rs.getString("Sphone"));
	               txtAddress.setText(rs.getString("Saddress"));
	           }
	           else
	           {
	               JOptionPane.showMessageDialog(this,"�����ڸü�¼��");
	               
	               txtNum.setText("");
	               txtName.setText("");
	               txtID.setText("");
	               txtSex.setText("");
	               txtAge.setText("");
	               txtJob.setText("");
	               txtDep.setText("");
	               txtSer.setText("");
	               txtTel.setText("");
	               txtAddress.setText("");
	           }
	       }
	       catch(Exception e)
	       {
	           e.printStackTrace();
	       }
	
	   }
	}

	public static void main(String[] args) 
	{
	   new SnoQueryForm();
	}
}

