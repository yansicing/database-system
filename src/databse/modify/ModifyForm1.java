package databse.modify;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

//修改员工表单模块设计//
public class ModifyForm1 extends JFrame implements ActionListener
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
  JTextField txtSer=new JTextField(10);
  JTextField txtTel=new JTextField(11);
  JTextField txtAddress=new JTextField(25);
  
  JButton btnModify=new JButton("修改");
  JButton btnCancel=new JButton("取消");
  JButton btnQuery=new JButton("查询");
  
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

  public ModifyForm1()
  {
      super("修改员工信息");
      
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
      
      pan11.add(btnQuery);
      pan11.add(btnModify);
      pan11.add(btnCancel);
      
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
      
      btnQuery.addActionListener(this);
      btnModify.addActionListener(this);
      btnCancel.addActionListener(this);
      
      btnModify.setEnabled(false);
      txtName.setEditable(false);
      txtID.setEditable(false);
      txtSex.setEditable(false);
      txtAge.setEditable(false);
      txtJob.setEditable(false);
      txtDep.setEditable(false);
      txtSer.setEditable(false);
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
          try
          {
        	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
              
        	  cnn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=database","sd","123");
              
        	  stm=cnn.createStatement();
              rs=stm.executeQuery("select * from Staff where Sno='"+txtNum.getText()+"'");
              
              if(rs.next())
              {
                  txtNum.setText(rs.getString("Sno"));
                  txtName.setText(rs.getString("Sname"));
                  txtID.setText(rs.getString("Sid"));
                  
                  txtSex.setText(rs.getString("Ssex"));
                  txtAge.setText(rs.getString("Sage"));
                  txtJob.setText(rs.getString("Spost"));
                  txtDep.setText(rs.getString("Sbranch"));
                  txtSer.setText(rs.getString("Sfanwei"));
                  
                  txtTel.setText(rs.getString("Sphone"));
                  txtAddress.setText(rs.getString("Saddress"));
                  
                  btnModify.setEnabled(true);
                  
                  txtName.setEditable(true);
                  txtID.setEditable(true);
                  
                  txtSex.setEditable(true);
                  txtAge.setEditable(true);
                  txtJob.setEditable(true);
                  txtDep.setEditable(true);
                  txtSer.setEditable(true);
                  
                  txtTel.setEditable(true);
                  txtAddress.setEditable(true);
              }
              else
              {
                  JOptionPane.showMessageDialog(this,"不存在该员工记录！");
                  
                  btnModify.setEnabled(false);
                  
                  txtNum.requestFocus();
                  
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
                  
                  txtName.setEditable(false);
                  txtID.setEditable(false);
                  
                  txtSex.setEditable(false);
                  txtAge.setEditable(false);
                  txtJob.setEditable(false);
                  txtDep.setEditable(false);
                  txtSer.setEditable(false);
                  
                  txtTel.setEditable(false);
                  txtAddress.setEditable(false);
              }
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
      }
      else if(ae.getSource()==btnModify)
      {
          try
          {
              System.out.println("Update  Staff set Sname="+txtName.getText()+",Sid="+txtID.getText()+",Ssex="+txtSex.getText()+",Sage="+txtAge.getText()+",Spost="+txtJob.getText()+",Sbranch="+txtDep.getText()+",Sfanwei="+txtSer.getText()+",Sphone="+txtTel.getText()+",Saddress="+txtAddress.getText()+" where Sno='"+txtNum.getText()+"'");
              stm.executeUpdate("Update  Staff set Sname='"+txtName.getText()+"',Sid='"+txtID.getText()+"',Ssex='"+txtSex.getText()+"',Sage='"+txtAge.getText()+"',Spost='"+txtJob.getText()+"',Sbranch='"+txtDep.getText()+"',Sfanwei='"+txtSer.getText()+"',Sphone='"+txtTel.getText()+"',Saddress='"+txtAddress.getText()+"'where Sno='"+txtNum.getText()+"'");
             
              JOptionPane.showMessageDialog(this,"记录修改完毕！");
             
              btnModify.setEnabled(false);
             
              txtNum.requestFocus();
             
              txtNum.setText("");
              txtName.setText("");
              txtID.setText("");
              
              txtTel.setText("");
              txtAddress.setText("");
              
              txtSex.setText("");
              txtAge.setText("");
              txtJob.setText("");
              txtDep.setText("");
              txtSer.setText("");
              
              txtName.setEditable(false);
              txtID.setEditable(false);
              
              txtSex.setEditable(false);
              txtAge.setEditable(false);
              txtJob.setEditable(false);
              txtDep.setEditable(false);
              txtSer.setEditable(false);
              
              txtTel.setEditable(false);
              txtAddress.setEditable(false);
              
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
      new ModifyForm1();
  }
}

