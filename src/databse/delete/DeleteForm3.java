package databse.delete;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

//删除业务安排表单模块设计//
public class DeleteForm3 extends JFrame implements ActionListener
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
    
  JButton btnDel=new JButton("删除");
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
  
  Connection cnn;
  Statement stm;
  ResultSet rs;

  public DeleteForm3()
  {
      super("删除业务记录");
      
      setSize(400,300);
      setLocation(500,100);
      
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
      
      pan9.add(btnQuery);
      pan9.add(btnDel);
      pan9.add(btnCancel);
      
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
      
      btnQuery.addActionListener(this);
      btnDel.addActionListener(this);
      btnCancel.addActionListener(this);
      
      btnDel.setEnabled(false);
      txtSName.setEditable(false);
      txtKName.setEditable(false);
      txtKNum.setEditable(false);
      txtYName.setEditable(false);
      txtYNum.setEditable(false);
      txtFee.setEditable(false);
      txtTime.setEditable(false);
      
      setVisible(true);
      
      txtSNum.requestFocus();

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
              rs=stm.executeQuery("select * from CS where CSno='"+txtSNum.getText()+"'");
             
              if(rs.next())
              {
                  txtSName.setText(rs.getString("Sename"));
                  txtSNum.setText(rs.getString("CSno"));
                  txtKName.setText(rs.getString("Cname"));
                  
                  txtKNum.setText(rs.getString("Cno"));
                  txtYName.setText(rs.getString("Sname"));
                  txtYNum.setText(rs.getString("Sno"));
                  txtFee.setText(rs.getString("Secostmonth"));
                  txtTime.setText(rs.getString("Setime"));
                  
                  btnDel.setEnabled(true);
              }
              else
              {
                  JOptionPane.showMessageDialog(this,"不存在该客户记录！");
                  
                  btnDel.setEnabled(false);
                  
                  txtSName.setText("");
                  txtSNum.setText("");
                  txtKName.setText("");
                
                  txtKNum.setText("");
                  txtYName.setText("");
                  txtYNum.setText("");
                  txtFee.setText("");
                  txtTime.setText("");
              }
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
      }
	  else if(ae.getSource()==btnDel)
	  {
          try 
          {
              if(JOptionPane.YES_OPTION==JOptionPane.showConfirmDialog
                (this,"确定要删除该记录？","信息",JOptionPane.YES_NO_OPTION))
              {
                  stm.executeUpdate("delete from  CS where CSno='"+txtSNum.getText()+"'");
                  
                  btnDel.setEnabled(false);
                
                  txtSName.setText("");
                  txtSNum.setText("");
                  txtKName.setText("");
                 
                  txtKNum.setText("");
                  txtYName.setText("");
                  txtYNum.setText("");
                  txtFee.setText("");
                  txtTime.setText("");
              }
          }
          catch (SQLException ex) 
          {
              ex.printStackTrace();
          }
      }
  }

  public static void main(String[] args) 
  {
      new DeleteForm3();
  }
}

