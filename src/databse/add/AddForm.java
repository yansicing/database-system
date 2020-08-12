package databse.add;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

//��ӿͻ���ģ�����//
public class AddForm extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;
  
  JLabel labNum=new JLabel("�ͻ��ţ�");
  JLabel labName=new JLabel("�ͻ�������");
  JLabel labSex=new JLabel("�ͻ��Ա�");
  JLabel labTel=new JLabel("�ͻ���ϵ�绰��");
  JLabel labAdr=new JLabel("�ͻ�סַ��");
  
  JTextField txtNum=new JTextField(10);
  JTextField txtName=new JTextField(10);
  JTextField txtSex=new JTextField(2);
  JTextField txtTel=new JTextField(11);
  JTextField txtAdr=new JTextField(20);
  
  JButton btnOk=new JButton("ȷ��");
  JButton btnClear=new JButton("���");
  
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

  public AddForm()
  {
      super("����¿ͻ�");   // ����Ϊ"����¿ͻ�"
      
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
      
      pan5.add(labAdr);
      pan5.add(txtAdr);
      
      pan6.add(btnOk);
      pan6.add(btnClear);
      
      pan.setLayout(new GridLayout(6,1));
      
      pan.add(pan1);
      pan.add(pan2);
      pan.add(pan3);
      pan.add(pan4);
      pan.add(pan5);
      
      getContentPane().add(pan,"Center");
      getContentPane().add(pan6,"South");
      
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
          txtSex.setText("");
          txtTel.setText("");
          txtAdr.setText("");
          txtNum.requestFocus();
          txtName.requestFocus();
      }
      else if(ae.getSource()==btnOk)
      {
          String strNum=txtNum.getText();
          String strName=txtName.getText();
          String strSex=txtSex.getText();
          String strTel=txtTel.getText();
          String strAdr=txtAdr.getText();
          
          if(strNum.equals(""))
              JOptionPane.showMessageDialog(this,"�ͻ��Ų���Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
          else if(strName.equals(""))
              JOptionPane.showMessageDialog(this,"�ͻ���������Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
          else if(strSex.equals(""))
              JOptionPane.showMessageDialog(this,"�ͻ��Ա���Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
          else if(strTel.equals(""))
              JOptionPane.showMessageDialog(this,"�ͻ���ϵ�绰����Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
          else if(strAdr.equals(""))
              JOptionPane.showMessageDialog(this,"�ͻ�סַ����Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
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
                  rs = stm.executeQuery("select * from Custom where Cno='" +strNum + "'");
                  
                  if (rs.next()) 
                  {
                      JOptionPane.showMessageDialog(this,"�Բ��𣬸ÿͻ���Ϣ�Ѵ��ڣ�");
                  } 
                  else  // ��������¼
                  {
                      stm.executeUpdate("insert into Custom values('"+strNum+"','"+strName+"','"+strSex+"','"+strTel+"','"+strAdr+"')");
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
      new AddForm();
  }
}

