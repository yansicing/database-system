package databse.brower;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

//浏览服务项目表单模块设计//
public class BrowserForm2 extends JFrame 
{
  private static final long serialVersionUID = 1L;
  
  String []str={"服务项目号","服务项目名称","服务项目类别","服务项目收费（￥/月）"};
  
  Object[][] data;
  JTable table;
  JTableHeader head;
  JScrollPane jsp;
  
  Connection conn;
  Statement stmt;
  ResultSet rs;
  
  public BrowserForm2()
  {
      super("浏览服务项目信息");
      
      setSize(550,300);
      setLocation(450,150);
      
      int i=0,j=0;
   // int row;
      
      try
      {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=database","sd","123");
          
          stmt=conn.createStatement();

          rs=stmt.executeQuery("select * from Service");
          rs.next();    
          /*  row=rs.getInt("1101");*/
          rs.close();
       
          data=new Object[20][4];
      
          rs=stmt.executeQuery("select * from Service");
      
          while(rs.next())
          {
              data[i][j++]=rs.getString("Seno");
              data[i][j++]=rs.getString("Sename");
              data[i][j++]=rs.getString("Seliebie");
              data[i][j++]=rs.getString("Secostmonth");
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
      new BrowserForm2();
  }
}

