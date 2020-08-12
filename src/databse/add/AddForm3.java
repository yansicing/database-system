package databse.add;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

//�����ҵ���ű�ģ�����//
public class AddForm3 extends JFrame implements ActionListener
{
	    private static final long serialVersionUID = 1L;
	    JLabel labSName=new JLabel("ҵ�����ƣ�");
	    JLabel labSNum=new JLabel("ҵ��ţ�");
	    JLabel labKName=new JLabel("�ͻ�������");
	    JLabel labKNum=new JLabel("�ͻ��ţ�");
	    JLabel labYName=new JLabel("Ա��������");
	    JLabel labYNum=new JLabel("Ա���ţ�");
	    JLabel labFee=new JLabel("ҵ���շ�(��/��)��");
	    JLabel labTime=new JLabel("����ʱ�䣺");
	    
	    JTextField txtSName=new JTextField(8);
	    JTextField txtSNum=new JTextField(10);
	    JTextField txtKName=new JTextField(8);
	    JTextField txtKNum=new JTextField(10);
	    JTextField txtYName=new JTextField(8);
	    JTextField txtYNum=new JTextField(10);
	    JTextField txtFee=new JTextField(10);
	    JTextField txtTime=new JTextField(20);
	    
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
	    
	    Connection cnn;
	    Statement stm;
	    ResultSet rs;

	    public AddForm3()
	    {
	        super("�����ҵ����");
	        
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
	                JOptionPane.showMessageDialog(this,"ҵ�����Ʋ���Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strSNum.equals(""))
	                JOptionPane.showMessageDialog(this,"ҵ��Ų���Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strKName.equals(""))
	                JOptionPane.showMessageDialog(this,"�ͻ���������Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strKNum.equals(""))
	                JOptionPane.showMessageDialog(this,"�ͻ��Ų���Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strYName.equals(""))
	                JOptionPane.showMessageDialog(this,"Ա����������Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strYNum.equals(""))
	                JOptionPane.showMessageDialog(this,"Ա���Ų���Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strFee.equals(""))
	                JOptionPane.showMessageDialog(this,"ҵ���շѲ���Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	            else if(strTime.equals(""))
	                JOptionPane.showMessageDialog(this,"����ʱ�䲻��Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
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
	                        JOptionPane.showMessageDialog(this,"�Բ��𣬸ÿͷ�������Ϣ�Ѵ��ڣ�");
	                    } 
	                	else  // ��������¼
	                    {
	                          // System.out.println("insert into CS values('"+strSName+"','"+strSNum+"','"+strKName+"','"+strKNum+"','"+strYName+"','"+strYNum+"','"+strFee+"','"+strTime+"')");
	                        stm.executeUpdate("insert into CS values('"+strSName+"','"+strSNum+"','"+strKName+"','"+strKNum+"','"+strYName+"','"+strYNum+"','"+strFee+"','"+strTime+"')");
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
	        new AddForm3();
	    }
	}

