package databse.add;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

//����·�����Ŀ��ģ�����//
public class AddForm2 extends JFrame implements ActionListener
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
	    
	    JButton btnOk=new JButton("ȷ��");
	    JButton btnClear=new JButton("���");
	    
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
	        super("����·�����Ŀ");
	        
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
	                JOptionPane.showMessageDialog(this,"ҵ��Ų���Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strName.equals(""))
	                JOptionPane.showMessageDialog(this,"ҵ�����Ʋ���Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strClass.equals(""))
	                JOptionPane.showMessageDialog(this,"ҵ�������Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strFee.equals(""))
	                JOptionPane.showMessageDialog(this,"ҵ���շѲ���Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
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
	                        JOptionPane.showMessageDialog(this,"�Բ��𣬸�ҵ����Ϣ�Ѵ��ڣ�");
	                    } 
	                    else  // ��������¼
	                    {
	                          // System.out.println("insert into Service values('"+strNum+"','"+strName+"',#"+strClass+"#,"+strFee+")");
	                        stm.executeUpdate("insert into Service values('"+strNum+"','"+strName+"','"+strClass+"',"+strFee+")");
	                        JOptionPane.showMessageDialog(null,"��¼�Ѿ��ɹ���ӣ�");
	                    }
	                         // �Ͽ�����
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

