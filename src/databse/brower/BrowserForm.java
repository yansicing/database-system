package databse.brower;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

//����ͻ���ģ�����//
public class BrowserForm extends JFrame 
{
  private static final long serialVersionUID = 1L;
  
  String []str={"�ͻ���","�ͻ�����","�ͻ��Ա�","�ͻ��绰","�ͻ�סַ"};
  
  Object[][] data;    // ���ݳ�ʼ�����洢�ڶ�ά����
  JTable table;       // �������ؼ�
  JTableHeader head;  // ���� JTable ��ͷ�Ķ���
  JScrollPane jsp;    // �����������
  
  Connection conn;
  Statement stmt;
  ResultSet rs;
  
  public BrowserForm()
  {
      super("����ͻ���Ϣ");
      
      setSize(1000,300);
      setLocation(170,50);
      
      int i=0,j=0;
 //   int row;
      try
      {
    	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      
    	  conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=database","sd","123");
         
    	  stmt=conn.createStatement();
         
    	  rs=stmt.executeQuery("select * from Custom");
          rs.next();
       
          /* row=rs.getInt("1010421054");*/
        
          rs.close();
          
          data=new Object[20][5]; 
          
          rs=stmt.executeQuery("select * from Custom");
      
          while(rs.next())
          {
              data[i][j++]=rs.getString("Cno");
              data[i][j++]=rs.getString("Cname");
              data[i][j++]=rs.getString("Csex");
              data[i][j++]=rs.getString("Cphone");
              data[i][j++]=rs.getString("Caddress");
              i++;j=0;
          }
       // JTable�࣬�����Ա�����ʽչʾ���ݣ������������û��༭����
          table=new JTable(data,str);  // ���ʹ�����ݺ���������һ�����
          head=table.getTableHeader(); // �����û��Ƿ�����϶���ͷ
          jsp=new JScrollPane(table);  // �����������
          
          getContentPane().add(head,"North");
          getContentPane().add(jsp,"Center");
         
          rs.close();
          stmt.close();
          conn.close();
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
     
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setVisible(true);
  }
  public static void main(String[] args) 
  {
      new BrowserForm();
  }
}



