package databse.add;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

//添加新服务项目表单模块设计//
public class AddForm2 extends JFrame implements ActionListener
{
	    private static final long serialVersionUID = 1L;
	    JLabel labNum=new JLabel("服务项目号：");
	    JLabel labName=new JLabel("服务项目名称：");
	    JLabel labClass=new JLabel("服务项目类别：");
	    JLabel labFee=new JLabel("服务项目收费(￥/月)：");
	    
	    JTextField txtNum=new JTextField(10);
	    JTextField txtName=new JTextField(8);
	    JTextField txtClass=new JTextField(8);
	    JTextField txtFee=new JTextField(10);
	    
	    JButton btnOk=new JButton("确定");
	    JButton btnClear=new JButton("清空");
	    
	    JPanel pan=new JPanel();
	    JPanel pan1=new JPanel();
	    JPanel pan2=new JPanel();
	    JPanel pan3=new JPanel();
	    JPanel pan4=new JPanel();
	    JPanel pan5=new JPanel();
	    
	    Connection cnn;
	    Statement stm;
	    ResultSet rs;

	    public AddForm2()
	    {
	        super("添加新服务项目");
	        
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
	        
	        pan5.add(btnOk);
	        pan5.add(btnClear);
	        
	        pan.setLayout(new GridLayout(4,1));
	        
	        pan.add(pan1);
	        pan.add(pan2);
	        pan.add(pan3);
	        pan.add(pan4);
	        
	        getContentPane().add(pan,"Center");
	        getContentPane().add(pan5,"South");
	        
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
	            txtClass.setText("");
	            txtFee.setText("");
	            txtNum.requestFocus();
	            txtName.requestFocus();
	            
	        }
	        else if(ae.getSource()==btnOk)
	        {
	            String strNum=txtNum.getText();
	            String strName=txtName.getText();
	            String strClass=txtClass.getText();
	            String strFee=txtFee.getText();
	            
	            if(strNum.equals(""))
	                JOptionPane.showMessageDialog(this,"业务号不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strName.equals(""))
	                JOptionPane.showMessageDialog(this,"业务名称不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strClass.equals(""))
	                JOptionPane.showMessageDialog(this,"业务类别不能为空！","警告",JOptionPane.ERROR_MESSAGE);
	            else if(strFee.equals(""))
	                JOptionPane.showMessageDialog(this,"业务收费不能为空！","警告",JOptionPane.ERROR_MESSAGE);
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
	                    rs = stm.executeQuery("select * from Service where Seno='" +strNum + "'");
	                   
	                    if (rs.next()) 
	                    {
	                        JOptionPane.showMessageDialog(this,"对不起，该业务信息已存在！");
	                    } 
	                    else  // 否则插入记录
	                    {
	                          // System.out.println("insert into Service values('"+strNum+"','"+strName+"',#"+strClass+"#,"+strFee+")");
	                        stm.executeUpdate("insert into Service values('"+strNum+"','"+strName+"','"+strClass+"',"+strFee+")");
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
	        new AddForm2();
	    }
	}

