package databse.delete;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

//删除客户表单模块设计//
public class DeleteForm extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	JLabel labNum=new JLabel("客户号：");
	JLabel labName=new JLabel("客户姓名：");
	JLabel labSex=new JLabel("客户性别：");
	JLabel labTel=new JLabel("客户联系电话：");
	JLabel labAddress=new JLabel("客户住址：");
	
	JTextField txtNum=new JTextField(10);
	JTextField txtName=new JTextField(10);
	JTextField txtSex=new JTextField(2);
	JTextField txtTel=new JTextField(11);
	JTextField txtAddress=new JTextField(20);
	
	JButton btnDel=new JButton("删除");
	JButton btnCancel=new JButton("取消");
	JButton btnQuery=new JButton("查询");
	
	JPanel pan=new JPanel();
	JPanel pan1=new JPanel();
	JPanel pan2=new JPanel();
	JPanel pan3=new JPanel();
	JPanel pan4=new JPanel();
	JPanel pan5=new JPanel();
	JPanel pan6=new JPanel();
	
	Connection cnn;
	Statement stm;
	ResultSet rs;
	
	public DeleteForm()
	{
	    super("删除客户信息");
	    
	    setSize(400,260);
	    setLocation(500,150);
	    
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    
	    pan.setBorder(BorderFactory.createEtchedBorder()); // BorderFactory是一个产生创建边框的的工厂类
	    
	    pan1.add(labNum);
	    pan1.add(txtNum);
	    
	    pan2.add(labName);
	    pan2.add(txtName);
	    
	    pan3.add(labSex);
	    pan3.add(txtSex);
	    
	    pan4.add(labTel);
	    pan4.add(txtTel);
	    
	    pan5.add(labAddress);
	    pan5.add(txtAddress);
	    
	    pan6.add(btnQuery);
	    pan6.add(btnDel);
	    pan6.add(btnCancel);
	    
	    pan.setLayout(new GridLayout(5,1));
	    
	    pan.add(pan1);
	    pan.add(pan2);
	    pan.add(pan3);
	    pan.add(pan4);
	    pan.add(pan5);
	    
	    getContentPane().add(pan,"Center");
	    getContentPane().add(pan6,"South");
	    
	    btnQuery.addActionListener(this);
	    btnDel.addActionListener(this);
	    btnCancel.addActionListener(this);
	    
	    btnDel.setEnabled(false);
	    txtName.setEditable(false);
	    txtSex.setEditable(false);
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
	            rs=stm.executeQuery("select * from Custom where Cno='"+txtNum.getText()+"'");
	           
	            if(rs.next())
	            {
	                txtNum.setText(rs.getString("Cno"));
	                txtName.setText(rs.getString("Cname"));
	                txtSex.setText(rs.getString("Csex"));
	                txtTel.setText(rs.getString("Cphone"));
	                txtAddress.setText(rs.getString("Caddress"));
	               
	                btnDel.setEnabled(true);
	               
//	                txtName.setEditable(true);
//	                txtSex.setEditable(true);
//	                txtTel.setEditable(true);
//	                txtAddress.setEditable(true);
	            }
	            else
	            {
	                JOptionPane.showMessageDialog(this,"不存在该客户记录！");
	              
	                btnDel.setEnabled(false);
	                
	                txtNum.requestFocus();
	                
	                txtNum.setText("");
	                txtName.setText("");
	                txtTel.setText("");
	                txtAddress.setText("");
	                txtSex.setText("");
	              
	                txtName.setEditable(false);
	                txtSex.setEditable(false);
	                txtTel.setEditable(false);
	                txtAddress.setEditable(false);
	            }
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	    else if(ae.getSource()==btnDel)
	    {
	        try
	        {
	        	if(JOptionPane.YES_OPTION==JOptionPane.showConfirmDialog
	                    (this,"确定要删除该记录？","信息",JOptionPane.YES_NO_OPTION))
	                  {
	                        stm.executeUpdate("delete from  Custom where Cno='"+txtNum.getText()+"'");
	                      	           
				            btnDel.setEnabled(false);
				            
				            txtNum.requestFocus();
				           
				            txtNum.setText("");
				            txtName.setText("");
				            txtTel.setText("");
				            txtAddress.setText("");
				            txtSex.setText("");
				            
			//	            txtName.setEditable(false);
			//	            txtSex.setEditable(false);
			//	            txtTel.setEditable(false);
			//	            txtAddress.setEditable(false);
			//	           
			//	            stm.close();
			//	            cnn.close();
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
	    new DeleteForm();
	}
}

