# database-system

- 语言：Java
- 工具：Eclipse
- 数据库：SqlServer2008


## 数据库连接主要代码
```
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
```