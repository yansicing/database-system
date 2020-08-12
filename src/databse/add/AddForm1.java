package databse.add;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

//���Ա����ģ�����//
public class AddForm1 extends JFrame implements ActionListener
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
	    
	    JButton btnOk=new JButton("ȷ��");
	    JButton btnClear=new JButton("���");
	    
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
	        super("�����Ա��");
	        
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
	                JOptionPane.showMessageDialog(this,"Ա���Ų���Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strName.equals(""))
	                JOptionPane.showMessageDialog(this,"Ա����������Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strID.equals(""))
	                JOptionPane.showMessageDialog(this,"Ա�����֤�Ų���Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strSex.equals(""))
	                JOptionPane.showMessageDialog(this,"Ա���Ա���Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strAge.equals(""))
	                JOptionPane.showMessageDialog(this,"Ա�����䲻��Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strJob.equals(""))
	                JOptionPane.showMessageDialog(this,"Ա��ְλ����Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strDep.equals(""))
	                JOptionPane.showMessageDialog(this,"Ա�����ڲ��Ų���Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strSer.equals(""))
	                JOptionPane.showMessageDialog(this,"Ա��������Ŀ��Χ����Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strTel.equals(""))
	                JOptionPane.showMessageDialog(this,"Ա����ϵ�绰����Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strAddress.equals(""))
	                JOptionPane.showMessageDialog(this,"Ա��סַ����Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
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
	                        JOptionPane.showMessageDialog(this,"�Բ��𣬸�Ա����Ϣ�Ѵ��ڣ�");
	                    } 
	                	else  // ��������¼
	                    {
	                        stm.executeUpdate("insert into Staff values('"+strNum+"','"+strName+"','"+strID+"','"+strSex+"','"+strAge+"','"+strJob+"','"+strDep+"','"+strSer+"','"+strTel+"','"+strAddress+"')");
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
	        new AddForm1();
	    }
	}


