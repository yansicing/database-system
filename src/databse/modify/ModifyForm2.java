package databse.modify;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

//修改服务项目表单模块设计//
public class ModifyForm2 extends JFrame implements ActionListener
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
  
  JButton btnModify=new JButton("修改");
  JButton btnCancel=new JButton("取消");
  JButton btnQuery=new JButton("查询");
  
  JPanel pan=new JPanel();
  JPanel pan1=new JPanel();
  JPanel pan2=new JPanel();
  JPanel pan3=new JPanel();
  JPanel pan4=new JPanel();
  JPanel pan5=new JPanel();
  
  Connection cnn;
  Statement stm;
  ResultSet rs;

  public ModifyForm2()
  {
      super("修改服务项目信息");
      
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
      
      pan5.add(btnQuery);
      pan5.add(btnModify);
      pan5.add(btnCancel);
      
      pan.setLayout(new GridLayout(4,1));
      
      pan.add(pan1);
      pan.add(pan2);
      pan.add(pan3);
      pan.add(pan4);
      
      getContentPane().add(pan,"Center");
      getContentPane().add(pan5,"South");
      
      btnQuery.addActionListener(this);
      btnModify.addActionListener(this);
      btnCancel.addActionListener(this);
      
      btnModify.setEnabled(false);
      txtName.setEditable(false);
      txtClass.setEditable(false);
      txtFee.setEditable(false);
      
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
              rs=stm.executeQuery("select * from Service where Seno='"+txtNum.getText()+"'");
          
              if(rs.next())
              {
                  txtNum.setText(rs.getString("Seno"));
                  txtName.setText(rs.getString("Sename"));
                  txtClass.setText(rs.getString("Seliebie"));
                  txtFee.setText(rs.getString("Secostmonth"));
                 
                  btnModify.setEnabled(true);
                 
                  txtName.setEditable(true);
                  txtClass.setEditable(true);
                  txtFee.setEditable(true);
              }
              else
              {
                  JOptionPane.showMessageDialog(this,"不存在该客户记录！");
                 
                  btnModify.setEnabled(false);
                  
                  txtNum.requestFocus();
                  
                  txtNum.setText("");
                  txtName.setText("");
                  txtFee.setText("");
                  txtClass.setText("");
                 
                  txtName.setEditable(false);
                  txtClass.setEditable(false);
                  txtFee.setEditable(false);
              }
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
      }
      else if(ae.getSource()==btnModify)
      {
          try{
              System.out.println("Update  Service set Sename="+txtName.getText()+",Seliebie="+txtClass.getText()+",Secostmonth="+txtFee.getText()+" where Seno='"+txtNum.getText()+"'");
              stm.executeUpdate("Update  Service set [Sename]='"+txtName.getText()+"',[Seliebie]='"+txtClass.getText()+"',[Secostmonth]='"+txtFee.getText()+"' where [Seno]='"+txtNum.getText()+"'");
             
              JOptionPane.showMessageDialog(this,"记录修改完毕！");
            
              btnModify.setEnabled(false);
              
              txtNum.requestFocus();
             
              txtNum.setText("");
              txtName.setText("");
              txtFee.setText("");
              txtClass.setText("");
              txtName.setEditable(false);
              txtClass.setEditable(false);
              txtFee.setEditable(false);
              
              stm.close();
              cnn.close();
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
      }
  }

  public static void main(String[] args) 
  {
      new ModifyForm2();
  }
}
