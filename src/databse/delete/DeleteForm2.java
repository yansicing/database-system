package databse.delete;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

//ɾ��������Ŀ����ģ�����//
public class DeleteForm2 extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
		
	JLabel labNum=new JLabel("������Ŀ�ţ�");
	JLabel labName=new JLabel("������Ŀ���ƣ�");
	JLabel labClass=new JLabel("������Ŀ���");
	JLabel labFee=new JLabel("������Ŀ�շ�(��/��)��");
	
	JTextField txtNum=new JTextField(10);
	JTextField txtName=new JTextField(8);
	JTextField txtClass=new JTextField(8);
	JTextField txtFee=new JTextField(10);
	
	JButton btnDel=new JButton("ɾ��");
	JButton btnCancel=new JButton("ȡ��");
	JButton btnQuery=new JButton("��ѯ");
	
	JPanel pan=new JPanel();
	JPanel pan1=new JPanel();
	JPanel pan2=new JPanel();
	JPanel pan3=new JPanel();
	JPanel pan4=new JPanel();
	JPanel pan5=new JPanel();
	
	Connection cnn;
	Statement stm;
	ResultSet rs;
	
	public DeleteForm2()
	{
	    super("ɾ��������Ŀ��Ϣ");
	    
	    setSize(400,250);
	    setLocation(500,150);
	    
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    
	    pan.setBorder(BorderFactory.createEtchedBorder());
	    
	    pan1.add(labNum);
	    pan1.add(txtNum);
	    
	    pan2.add(labName);
	    pan2.add(txtName);
	    
	    pan3.add(labClass);
	    pan3.add(txtClass);
	    
	    pan4.add(labFee);
	    pan4.add(txtFee);
	    
	    pan5.add(btnQuery);
	    pan5.add(btnDel);
	    pan5.add(btnCancel);
	    
	    pan.setLayout(new GridLayout(4,1));
	    
	    pan.add(pan1);
	    pan.add(pan2);
	    pan.add(pan3);
	    pan.add(pan4);
	    
	    getContentPane().add(pan,"Center");
	    getContentPane().add(pan5,"South");
	    
	    btnQuery.addActionListener(this);
	    btnDel.addActionListener(this);
	    btnCancel.addActionListener(this);
	    
	    btnDel.setEnabled(false);
	    txtName.setEditable(false);
	    txtClass.setEditable(false);
	    txtFee.setEditable(false);
	    
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
	            rs=stm.executeQuery("select * from Service where Seno='"+txtNum.getText()+"'");
	        
	            if(rs.next())
	            {
	                txtNum.setText(rs.getString("Seno"));
	                txtName.setText(rs.getString("Sename"));
	                txtClass.setText(rs.getString("Seliebie"));
	                txtFee.setText(rs.getString("Secostmonth"));
	               
	                btnDel.setEnabled(true);
	               
//	                txtName.setEditable(true);
//	                txtClass.setEditable(true);
//	                txtFee.setEditable(true);
	            }
	            else
	            {
	                JOptionPane.showMessageDialog(this,"�����ڸÿͻ���¼��");
	               
	                btnDel.setEnabled(false);
	                
	                txtNum.requestFocus();
	                
	                txtNum.setText("");
	                txtName.setText("");
	                txtFee.setText("");
	                txtClass.setText("");
	               
//	                txtName.setEditable(false);
//	                txtClass.setEditable(false);
//	                txtFee.setEditable(false);
	            }
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	    else if(ae.getSource()==btnDel)
	    {
	        try{
	        	if(JOptionPane.YES_OPTION==JOptionPane.showConfirmDialog
	                    (this,"ȷ��Ҫɾ���ü�¼��","��Ϣ",JOptionPane.YES_NO_OPTION))
	                  {
	                      stm.executeUpdate("delete from  Service where Seno='"+txtNum.getText()+"'");
	                      
				            btnDel.setEnabled(false);
				            
				            txtNum.requestFocus();
				           
				            txtNum.setText("");
				            txtName.setText("");
				            txtFee.setText("");
				            txtClass.setText("");
				            
//				            txtName.setEditable(false);
//				            txtClass.setEditable(false);
//				            txtFee.setEditable(false);
//				            
//				            stm.close();
//				            cnn.close();
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
	    new DeleteForm2();
	}
}