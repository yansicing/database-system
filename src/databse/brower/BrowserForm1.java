package databse.brower;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

//���Ա����ģ�����//
public class BrowserForm1 extends JFrame 
{
  private static final long serialVersionUID = 1L;
  
  String []str={"Ա����","Ա������","Ա�����֤��","Ա���Ա�","Ա������","Ա��ְλ","Ա�����ڲ���","Ա������Χ","Ա���绰","Ա��סַ"};
  
  Object[][] data;
  
  JTable table;
  JTableHeader head;
  JScrollPane jsp;
 
  Connection conn;
  Statement stmt;
  ResultSet rs;
  
  public BrowserForm1()
  {
      super("���Ա����Ϣ");
    
      setSize(1000,200);
      setLocation(200,200);
     
      int i=0,j=0;
//    int row;
      try
      {
    	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
    	  conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=database","sd","123");
        
    	  stmt=conn.createStatement();
        
    	  rs=stmt.executeQuery("select * from Staff");
          rs.next();
       /*   row=rs.getInt("3610");*/
          rs.close();
         
          data=new Object[20][10];
     
          rs=stmt.executeQuery("select * from Staff");
        
          while(rs.next())
          {
              data[i][j++]=rs.getString("Sno");
              data[i][j++]=rs.getString("Sname");
              data[i][j++]=rs.getString("Sid");
              data[i][j++]=rs.getString("Ssex");
              data[i][j++]=rs.getString("Sage");
              data[i][j++]=rs.getString("Spost");
              data[i][j++]=rs.getString("Sbranch");
              data[i][j++]=rs.getString("Sfanwei");
              data[i][j++]=rs.getString("Sphone");
              data[i][j++]=rs.getString("Saddress");
              i++;j=0;
          }
          
          table=new JTable(data,str);
          head=table.getTableHeader();
          jsp=new JScrollPane(table);
         
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
      new BrowserForm1();
  }
}
