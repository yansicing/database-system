package databse.brower;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

//浏览客户表单模块设计//
public class BrowserForm extends JFrame 
{
  private static final long serialVersionUID = 1L;
  
  String []str={"客户号","客户姓名","客户性别","客户电话","客户住址"};
  
  Object[][] data;    // 数据初始化并存储在二维数组
  JTable table;       // 创建表格控件
  JTableHeader head;  // 管理 JTable 的头的对象
  JScrollPane jsp;    // 创建滚动面板
  
  Connection conn;
  Statement stmt;
  ResultSet rs;
  
  public BrowserForm()
  {
      super("浏览客户信息");
      
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
       // JTable类，可以以表格的形式展示数据，可设置允许用户编辑数据
          table=new JTable(data,str);  // 表格使用数据和列名构造一个表格
          head=table.getTableHeader(); // 设置用户是否可以拖动列头
          jsp=new JScrollPane(table);  // 创建滚动面板
          
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



