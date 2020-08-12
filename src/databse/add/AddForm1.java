package databse.add;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

//添加员工表单模块设计//
public class AddForm1 extends JFrame implements ActionListener
{

	    private static final long serialVersionUID = 1L;
	    
		JLabel labNum=new JLabel("员工号：");
	    JLabel labName=new JLabel("员工姓名：");
	    JLabel labID=new JLabel("员工身份证号：");
	    JLabel labSex=new JLabel("员工性别：");
	    JLabel labAge=new JLabel("员工年龄：");
	    JLabel labJob=new JLabel("员工职位：");
	    JLabel labDep=new JLabel("员工所在部门：");
	    JLabel labSer=new JLabel("员工服务项目范围：");
	    JLabel labTel=new JLabel("员工联系电话：");
	    JLabel labAddress=new JLabel("员工住址：");
	    
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
	    
	    JButton btnOk=new JButton("确定");
	    JButton btnClear=new JButton("清空");
	    
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
	    JPanel pan11=new JPanel();
	    
	    Connection cnn;
	    Statement stm;
	    ResultSet rs;

	    public AddForm1()
	    {
	        super("添加新员工");
	        
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
	        
	        pan11.add(btnOk);
	        pan11.add(btnClear);
	        
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
	        
	        btnOk.addActionListener(this);
	        btnClear.addActionListener(this);
	        
	        setVisible(true);
	        
	        txtNum.requestFocus();
	    }
	    public void actionPerformed(ActionEvent ae)
	    {
	        if(ae.getSource()==btnClear)
	        {
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
	            
	            txtNum.requestFocus();
	            txtName.requestFocus();
	            txtID.requestFocus();
	            
	        }
	        else if(ae.getSource()==btnOk)
	        {
	            String strNum=txtNum.getText();
	            String strName=txtName.getText();
	            String strID=txtID.getText();           
	            String strSex=txtSex.getText();
	            String strAge=txtAge.getText();
	            String strJob=txtJob.getText();
	            String strDep=txtDep.getText();
	            String strSer=txtSer.getText();
	            
	            String strTel=txtTel.getText();
	            String strAddress=txtAddress.getText();
	            
	            if(strNum.equals(""))
	                JOptionPane.showMessageDialog(this,"员工号不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strName.equals(""))
	                JOptionPane.showMessageDialog(this,"员工姓名不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strID.equals(""))
	                JOptionPane.showMessageDialog(this,"员工身份证号不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strSex.equals(""))
	                JOptionPane.showMessageDialog(this,"员工性别不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strAge.equals(""))
	                JOptionPane.showMessageDialog(this,"员工年龄不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strJob.equals(""))
	                JOptionPane.showMessageDialog(this,"员工职位不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strDep.equals(""))
	                JOptionPane.showMessageDialog(this,"员工所在部门不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strSer.equals(""))
	                JOptionPane.showMessageDialog(this,"员工服务项目范围不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strTel.equals(""))
	                JOptionPane.showMessageDialog(this,"员工联系电话不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strAddress.equals(""))
	                JOptionPane.showMessageDialog(this,"员工住址不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else
	            {
	            	try 
	            	{
	              	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	                } 
	            	catch (ClassNotFoundException ex) 
	            	{
	                    ex.printStackTrace();
	                }
	            	
	                try 
	                {
	              	    cnn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=database","sd","123");
	                    stm=cnn.createStatement();
	                } 
	                catch (SQLException ex) 
	                {
	                    ex.printStackTrace();
	                }
	                try
	                {
	                	ResultSet rs = stm.executeQuery("select Sno from Staff where Sno='" +strNum + "'");
	                    
	                	if (rs.next()) 
	                    {
	                        JOptionPane.showMessageDialog(this,"对不起，该员工信息已存在！");
	                    } 
	                	else  // 否则插入记录
	                    {
	                        stm.executeUpdate("insert into Staff values('"+strNum+"','"+strName+"','"+strID+"','"+strSex+"','"+strAge+"','"+strJob+"','"+strDep+"','"+strSer+"','"+strTel+"','"+strAddress+"')");
	                        JOptionPane.showMessageDialog(null,"记录已经成功添加！");
	                    }
	                         // 断开连接
	                    stm.close();
	                    cnn.close();
	                } 
	                catch (SQLException ex) 
	                {
	                    System.out.println("SQLException:" + ex.getMessage());
	                }

	            }
	        }
	    }
	    public static void main(String[] args) 
	    {
	        new AddForm1();
	    }
	}


