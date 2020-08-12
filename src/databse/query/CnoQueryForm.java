package databse.query;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

//���ͻ��Ų�ѯ�ͻ���Ϣģ�����//
public class CnoQueryForm extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
    JLabel labNum=new JLabel("�ͻ��ţ�");
    JLabel labName=new JLabel("�ͻ�������");
    JLabel labSex=new JLabel("�ͻ��Ա�");
    JLabel labTel=new JLabel("�ͻ���ϵ�绰��");
    JLabel labAddress=new JLabel("�ͻ�סַ��");
    
    JTextField txtNum=new JTextField(10);
    JTextField txtName=new JTextField(10);
    JTextField txtSex=new JTextField(2);
    JTextField txtTel=new JTextField(11);
    JTextField txtAddress=new JTextField(20);
    
    JButton btnCancel=new JButton("ȡ��");
    JButton btnQuery=new JButton("��ѯ");
    
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

    public CnoQueryForm()
    {
        super("���ͻ��Ų�ѯ");
        
        setSize(400,300);
        setLocation(500,150);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        pan.setBorder(BorderFactory.createEtchedBorder());
        
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
        btnCancel.addActionListener(this);
        
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
            try{
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
	                }
	                else
	                {
	                    JOptionPane.showMessageDialog(this,"�����ڸü�¼��");
	                   
	                    txtNum.setText("");
	                    txtName.setText("");
	                    txtSex.setText("");
	                    txtTel.setText("");
	                    txtAddress.setText("");
	                   
	                    txtNum.requestFocus();
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
        new CnoQueryForm();
    }
}

