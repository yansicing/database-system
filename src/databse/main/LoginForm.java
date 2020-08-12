package databse.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
                                                  // LoginForm 继承自 JFrame 实现ActionListener接口
public class LoginForm extends JFrame implements ActionListener // 登陆界面 
{   
	private static final long serialVersionUID = 1L;

	JLabel labName=new JLabel("姓名");             // 姓名标签
    JLabel labPwd =new JLabel("密码");             // 密码标签
    JLabel labName1=new JLabel("家政服务业务管理系统"); // 系统标签
    
    JTextField    txtName=new JTextField(10);    // 姓名文本框
    JPasswordField txtPwd=new JPasswordField(10);// 密码文本框
    
    JButton btnOk    =new JButton("登录");        // 登陆按钮
    JButton btnCancel=new JButton("取消");        // 取消按钮
    
    JPanel pan =new JPanel();                    // 新建面板，按钮、文本框等都可以放在这个容器中
    JPanel pan1=new JPanel();                    // JPanel面板本身是不能作为窗口进行显示，必须依赖于JFrame容器等进行显示。
    JPanel pan2=new JPanel();
    JPanel pan3=new JPanel();
    JPanel pan4=new JPanel();
    JPanel pan5=new JPanel();
    
    Connection cnn;                             // 数据库连接对象
    Statement  stm;                             // 数据库操作对象
    ResultSet  rs;                              // 数据库结果集
    
    LoginForm()                                 // 构造方法完成初始化
    {
        super("家政服务业务管理系统");                 // 调用父类的初始化public方法
        
        setSize(300,200);                       // 设置大小 
        setLocation(500,250);                   // 设置位置
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 设置默认关闭操作
        
        pan.setBorder(BorderFactory.createTitledBorder("用户登录")); // 用户登录边界标题
        pan.setLayout(new GridLayout(2,1));     // 两行一列的网格布局
        
        pan1.add(labName);                      // 添加姓名标签
        pan1.add(txtName);                      // 添加姓名文本框
        
        pan2.add(labPwd);                       // 添加密码标签
        pan2.add(txtPwd);                       // 添加密码文本框
         
        pan.add(pan1);                          // pan1添加到pan容器中
        pan.add(pan2);                          // pan2添加到pan容器中
        
        pan3.add(btnOk);                        // 添加登陆按钮
        pan3.add(btnCancel);                    // 添加取消按钮
        
        pan4.add(pan);                          // 添加pan到pan4
        
        pan5.add(labName1);                     // 添加系统标签到pan5
        
        getContentPane().add(pan5,"North");     // 添加pan5在北边
        getContentPane().add(pan4,"Center");    // 添加pan4在中间
        getContentPane().add(pan3,"South");     // 添加pan3在南边
        
        txtName.addActionListener(this);        // 添加姓名文本框监听器
        txtPwd.addActionListener(this);         // 添加密码文本框监听器
        
        btnOk.addActionListener(this);          // 添加登陆按钮监听器
        btnCancel.addActionListener(this);      // 添加取消按钮监听器
        
        setVisible(true);                       // 设置为可见
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // 装载驱动，返回与带有给定字符串名的类或接口相关联的 Class对象 
        } 
        catch (ClassNotFoundException ex)   // 没有找到具有指定名称的类的定义
        {                                   // ex是此对象引用名称，然后ex会自动调用Exception类中指定的方法
            ex.printStackTrace();           // 打印异常堆栈信息到控制台，即在命令行打印异常信息在程序中出错的位置及原因
        }
        
        try 
        {                                   // 建立和数据库的连接，DriverManager 管理一组 JDBC驱动程序的基本服务
            cnn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=database","sd","123");
            stm=cnn.createStatement();      // 创建一个 Statement对象来将 SQL语句发送到数据库
        }                                   // Statement用于执行静态 SQL语句并返回它所生成结果的对象
        catch (SQLException ex)             // SQL数据库异常报错
        {
            ex.printStackTrace();           // 打印异常信息在程序中出错的位置及原因
        }
        
        txtName.requestFocus();             // 把焦点设置在这个按钮txtName上，光标切换到姓名文本框
    }
    
        public void actionPerformed(ActionEvent ae) // 侦听器内部要编写actionPerformed方法
        {                                           // 重写接口ActionListener里面定义的一个抽象方法，组件发生“有意义”的事件时会调用这个方法
            if(ae.getSource()==txtName)             // 当用户输入姓名后键入回车
                txtPwd.requestFocus();              // 光标显示在密码文本框
            
            else if(ae.getSource()==txtPwd)         // 当用户输入密码后键入回车
                btnOk.requestFocus();               // 焦点显示在登陆文本框
            
            else if(ae.getSource()==btnCancel)      // 当用户点击取消时
            {
                txtName.setText("");                // 姓名文本框清空输入
                txtPwd.setText("");                 // 密码文本框清空输入
                txtName.requestFocus();             // 光标显示在姓名文本框
                
            }
            else if(ae.getSource()==btnOk)          // 当用户点击登陆时
            {                                       // 从admin这张表中，查询出用户名是txtName和密码是txtPwd的用户，它里面的值是动态获得的。          	
                String str="select * from admin where Username='"+txtName.getText()+"'and Password='"+new String(txtPwd.getPassword())+"'";
                try 
                {
                    rs=stm.executeQuery(str);       // rs返回ResultSet集合 ，executeQuery()是java环境自带的执行查询的方法
                } 
                catch (SQLException ex)             // SQL数据库异常报错
                {
                    ex.printStackTrace();           // 打印异常信息在程序中出错的位置及原因
                }
                try 
                {
                    if(rs.next())    // 第一次使用next()就将指针指向返回结果集的第一行。每使用一次next()，指针就指向下一行
                    {                // 调出标题为 "Message" 的信息消息对话框，显示"验证通过!"
                        JOptionPane.showMessageDialog(this,"验证通过!","信息",JOptionPane.INFORMATION_MESSAGE);
                        
                        rs.close();  // 关掉数据库           
                        stm.close(); // 关掉执行语句
                        cnn.close(); // 关闭连接，释放资源
                        
                        new MainForm().setVisible(true); // 设置窗口可见
                        this.dispose();                  // 弹出窗体之后才关闭窗体。
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"用户名或密码不正确! 请重新输入","信息",JOptionPane.INFORMATION_MESSAGE);
                    }
                } 
                catch (SQLException ex)                // SQL数据库异常报错
                {
                    ex.printStackTrace();              // 打印异常信息在程序中出错的位置及原因
                }
            }
        }
        
        public static void main(String[] args)         // 主方法
        {
            new LoginForm();                           // 登陆方法
        }
}
