package databse.modify;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

//�޸�ҵ���ű�ģ�����//
public class ModifyForm3 extends JFrame implements ActionListener
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
  
  JButton btnModify=new JButton("�޸�");
  JButton btnCancel=new JButton("ȡ��");
  JButton btnQuery=new JButton("��ѯ");
  
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

  public ModifyForm3()
  {
      super("�޸�ҵ����Ϣ");
      
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
      
      pan9.add(btnQuery);
      pan9.add(btnModify);
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
      btnModify.addActionListener(this);
      btnCancel.addActionListener(this);
      
      btnModify.setEnabled(false);
      
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
                  
                  btnModify.setEnabled(true);
                  
                  txtSName.setEditable(true);
                  txtKName.setEditable(true);
                 
                  txtKNum.setEditable(true);
                  txtYName.setEditable(true);
                  txtYNum.setEditable(true);
                  txtFee.setEditable(true);
                  txtTime.setEditable(true);
              }
              else
              {
                  JOptionPane.showMessageDialog(this,"�����ڸ�ҵ���¼��");
                  
                  btnModify.setEnabled(false);
                  
                  txtSNum.requestFocus();
                 
                  txtSName.setText("");
                  txtSNum.setText("");
                  txtKName.setText("");
                  
                  txtKNum.setText("");
                  txtYName.setText("");
                  txtYNum.setText("");
                  txtFee.setText("");
                  txtTime.setText("");
                  
                  txtSName.setEditable(false);
                  txtKName.setEditable(false);
                  txtKNum.setEditable(false);
                  txtYName.setEditable(false);
                  txtYNum.setEditable(false);
                  txtFee.setEditable(false);
                  txtTime.setEditable(false);
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
              System.out.println("Update CS set Sename="+txtSName.getText()+",Cname="+txtKName.getText()+",Cno="+txtKNum.getText()+",Sname="+txtYName.getText()+",Sno="+txtYNum.getText()+",Secostmonth="+txtFee.getText()+",Setime="+txtTime.getText()+" where CSno='"+txtSNum.getText()+"'");
              stm.executeUpdate("Update CS set [Sename]='"+txtSName.getText()+"',[Cname]='"+txtKName.getText()+"',[Cno]='"+txtKNum.getText()+"',[Sname]='"+txtYName.getText()+"',[Sno]='"+txtYNum.getText()+"',[Secostmonth]='"+txtFee.getText()+"',[Setime]='"+txtTime.getText()+"'where [CSno]='"+txtSNum.getText()+"'");
              
              JOptionPane.showMessageDialog(this,"��¼�޸���ϣ�");
             
              btnModify.setEnabled(false);
             
              txtSNum.requestFocus();
             
              txtSName.setText("");
              txtSNum.setText("");
              txtKName.setText("");
             
              txtKNum.setText("");
              txtYName.setText("");
              txtYNum.setText("");
              txtFee.setText("");
              txtTime.setText("");
             
              txtSName.setEditable(false);
              txtKName.setEditable(false);
             
              txtKNum.setEditable(false);
              txtYName.setEditable(false);
              txtYNum.setEditable(false);
              txtFee.setEditable(false);
              txtTime.setEditable(false);
             
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
      new ModifyForm3();
  }
}

