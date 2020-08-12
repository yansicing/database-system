package databse.brower;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

//浏览业务表单模块设计//
public class BrowserForm3 extends JFrame 
{
  private static final long serialVersionUID = 1L;
  
  String []str={"业务名称","业务号","客户姓名","客户号","员工姓名","员工号","业务收费（￥/月）","服务时间"};
  
  Object[][] data;
  JTable table;
  JTableHeader head;
  JScrollPane jsp;
  
  Connection conn;
  Statement stmt;
  ResultSet rs;
  
  public BrowserForm3()
  {
      super("浏览业务安排信息");
      
      setSize(1050,200);
      setLocation(200,200);
      
      int i=0,j=0;
   // int row;
      
      try
      {
    	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=database","sd","123");
       
          stmt=conn.createStatement();
          rs=stmt.executeQuery("select * from CS");
          rs.next();
         /* row=rs.getInt("1107");*/
          rs.close();
       
          data=new Object[20][8];
        
          rs=stmt.executeQuery("select * from CS");
       
          while(rs.next())
          {
              data[i][j++]=rs.getString("Sename");
              data[i][j++]=rs.getString("CSno");
              data[i][j++]=rs.getString("Cname");
              data[i][j++]=rs.getString("Cno");
              data[i][j++]=rs.getString("Sname");
              data[i][j++]=rs.getString("Sno");
              data[i][j++]=rs.getString("Secostmonth");
              data[i][j++]=rs.getString("Setime");
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
      new BrowserForm3();
  }
}
