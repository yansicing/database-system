package databse.add;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

//添加客户表单模块设计//
public class AddForm extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;
  
  JLabel labNum=new JLabel("客户号：");
  JLabel labName=new JLabel("客户姓名：");
  JLabel labSex=new JLabel("客户性别：");
  JLabel labTel=new JLabel("客户联系电话：");
  JLabel labAdr=new JLabel("客户住址：");
  
  JTextField txtNum=new JTextField(10);
  JTextField txtName=new JTextField(10);
  JTextField txtSex=new JTextField(2);
  JTextField txtTel=new JTextField(11);
  JTextField txtAdr=new JTextField(20);
  
  JButton btnOk=new JButton("确定");
  JButton btnClear=new JButton("清空");
  
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
      super("添加新客户");   // 标题为"添加新客户"
      
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
              JOptionPane.showMessageDialog(this,"客户号不能为空！","警告",JOptionPane.ERROR_MESSAGE);
          else if(strName.equals(""))
              JOptionPane.showMessageDialog(this,"客户姓名不能为空！","警告",JOptionPane.ERROR_MESSAGE);
          else if(strSex.equals(""))
              JOptionPane.showMessageDialog(this,"客户性别不能为空！","警告",JOptionPane.ERROR_MESSAGE);
          else if(strTel.equals(""))
              JOptionPane.showMessageDialog(this,"客户联系电话不能为空！","警告",JOptionPane.ERROR_MESSAGE);
          else if(strAdr.equals(""))
              JOptionPane.showMessageDialog(this,"客户住址不能为空！","警告",JOptionPane.ERROR_MESSAGE);
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
                      JOptionPane.showMessageDialog(this,"对不起，该客户信息已存在！");
                  } 
                  else  // 否则插入记录
                  {
                      stm.executeUpdate("insert into Custom values('"+strNum+"','"+strName+"','"+strSex+"','"+strTel+"','"+strAdr+"')");
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
      new AddForm();
  }
}

