package databse.add;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

//添加新业务安排表单模块设计//
public class AddForm3 extends JFrame implements ActionListener
{
	    private static final long serialVersionUID = 1L;
	    JLabel labSName=new JLabel("业务名称：");
	    JLabel labSNum=new JLabel("业务号：");
	    JLabel labKName=new JLabel("客户姓名：");
	    JLabel labKNum=new JLabel("客户号：");
	    JLabel labYName=new JLabel("员工姓名：");
	    JLabel labYNum=new JLabel("员工号：");
	    JLabel labFee=new JLabel("业务收费(￥/月)：");
	    JLabel labTime=new JLabel("服务时间：");
	    
	    JTextField txtSName=new JTextField(8);
	    JTextField txtSNum=new JTextField(10);
	    JTextField txtKName=new JTextField(8);
	    JTextField txtKNum=new JTextField(10);
	    JTextField txtYName=new JTextField(8);
	    JTextField txtYNum=new JTextField(10);
	    JTextField txtFee=new JTextField(10);
	    JTextField txtTime=new JTextField(20);
	    
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
	    
	    Connection cnn;
	    Statement stm;
	    ResultSet rs;

	    public AddForm3()
	    {
	        super("添加新业务安排");
	        
	        setSize(400,500);
	        setLocation(500,50);
	        
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        
	        pan.setBorder(BorderFactory.createEtchedBorder());
	        
	        pan1.add(labSName);
	        pan1.add(txtSName);
	        
	        pan2.add(labSNum);
	        pan2.add(txtSNum);
	        
	        pan3.add(labKName);
	        pan3.add(txtKName);
	        
	        pan4.add(labKNum);
	        pan4.add(txtKNum);
	        
	        pan5.add(labYName);
	        pan5.add(txtYName);
	        
	        pan6.add(labYNum);
	        pan6.add(txtYNum);
	        
	        pan7.add(labFee);
	        pan7.add(txtFee);
	        
	        pan8.add(labTime);
	        pan8.add(txtTime);
	        
	        pan9.add(btnOk);
	        pan9.add(btnClear);
	        
	        pan.setLayout(new GridLayout(8,1));
	        
	        pan.add(pan1);
	        pan.add(pan2);
	        pan.add(pan3);
	        pan.add(pan4);
	        pan.add(pan5);
	        pan.add(pan6);
	        pan.add(pan7);
	        pan.add(pan8);
	        
	        getContentPane().add(pan,"Center");
	        getContentPane().add(pan9,"South");
	        
	        btnOk.addActionListener(this);
	        btnClear.addActionListener(this);
	        
	        setVisible(true);
	        
	        txtSName.requestFocus();
	    }
	    public void actionPerformed(ActionEvent ae)
	    {
	        if(ae.getSource()==btnClear)
	        {
	            txtSName.setText("");
	            txtSNum.setText("");
	            txtKName.setText("");          
	            txtKNum.setText("");
	            txtYName.setText("");
	            txtYNum.setText("");
	            txtFee.setText("");
	            txtTime.setText("");
	            
	            txtSName.requestFocus();
	            txtSNum.requestFocus();
	            txtKName.requestFocus();
	            
	        }
	        else if(ae.getSource()==btnOk)
	        {
	            String strSName=txtSName.getText();
	            String strSNum=txtSNum.getText();
	            String strKName=txtKName.getText();            
	            String strKNum=txtKNum.getText();
	            String strYName=txtYName.getText();
	            String strYNum=txtYNum.getText();
	            String strFee=txtFee.getText();
	            String strTime=txtTime.getText();
	            
	            if(strSName.equals(""))
	                JOptionPane.showMessageDialog(this,"业务名称不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strSNum.equals(""))
	                JOptionPane.showMessageDialog(this,"业务号不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strKName.equals(""))
	                JOptionPane.showMessageDialog(this,"客户姓名不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strKNum.equals(""))
	                JOptionPane.showMessageDialog(this,"客户号不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strYName.equals(""))
	                JOptionPane.showMessageDialog(this,"员工姓名不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strYNum.equals(""))
	                JOptionPane.showMessageDialog(this,"员工号不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strFee.equals(""))
	                JOptionPane.showMessageDialog(this,"业务收费不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strTime.equals(""))
	                JOptionPane.showMessageDialog(this,"服务时间不能为空！","警告",JOptionPane.ERROR_MESSAGE);
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
	                	ResultSet rs = stm.executeQuery("select Sno from CS where CSno='" +strSNum + "'");
	                    
	                	if (rs.next()) 
	                	{
	                        JOptionPane.showMessageDialog(this,"对不起，该客服安排信息已存在！");
	                    } 
	                	else  // 否则插入记录
	                    {
	                          // System.out.println("insert into CS values('"+strSName+"','"+strSNum+"','"+strKName+"','"+strKNum+"','"+strYName+"','"+strYNum+"','"+strFee+"','"+strTime+"')");
	                        stm.executeUpdate("insert into CS values('"+strSName+"','"+strSNum+"','"+strKName+"','"+strKNum+"','"+strYName+"','"+strYNum+"','"+strFee+"','"+strTime+"')");
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
	        new AddForm3();
	    }
	}

