package databse.main;

import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import databse.add.*;
import databse.brower.*;
import databse.delete.*;
import databse.modify.*;
import databse.query.*;

//系统主界面模块的设计
class MainForm extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;
  
  JMenu mSystem  =new JMenu("系统");               // "系统"菜单
  JMenuItem mExit=new JMenuItem("退出");           // "退出"菜单项
  
  JMenu mOperate    =new JMenu("操作");            // "操作"菜单
  JMenuItem mAdd    =new JMenuItem("添加客户信息");   // "添加"菜单项
  JMenuItem mAdd1   =new JMenuItem("添加员工信息");
  JMenuItem mAdd2   =new JMenuItem("添加服务项目");
  JMenuItem mAdd3   =new JMenuItem("添加业务安排");
  
  JMenuItem mDel    =new JMenuItem("删除客户信息");   // "删除"菜单项
  JMenuItem mDel1   =new JMenuItem("删除员工信息");  
  JMenuItem mDel2   =new JMenuItem("删除服务项目");   
  JMenuItem mDel3   =new JMenuItem("删除业务安排");   
  
  JMenuItem mModify =new JMenuItem("修改客户信息");   // "修改"菜单项
  JMenuItem mModify1=new JMenuItem("修改员工信息");
  JMenuItem mModify2=new JMenuItem("修改服务项目");
  JMenuItem mModify3=new JMenuItem("修改业务安排");
  
  JMenuItem mBrowse =new JMenuItem("浏览客户信息");   // "浏览"菜单项
  JMenuItem mBrowse1=new JMenuItem("浏览员工信息");
  JMenuItem mBrowse2=new JMenuItem("浏览服务项目");
  JMenuItem mBrowse3=new JMenuItem("浏览业务安排");
  
  JMenu mQuery  =new JMenu("查询");                // "查询"菜单
  JMenuItem mCno=new JMenuItem("按客户号查询客户信息"); //  子菜单项
  JMenuItem mSno=new JMenuItem("按员工号查询员工信息"); //  子菜单项
  
  JMenu mHelp     =new JMenu("帮助");             // "帮助"菜单
  JMenuItem mAbout=new JMenuItem("关于");         // "关于"菜单项
  
  JMenuBar mBar   =new JMenuBar();               //  菜单栏
  
  MainForm()                                     // 系统主界面模块构造方法
  {
      super("家政服务管理系统 by杨庆");                 // 调用父类的初始化public方法
      setSize(1500,730);                         // 设置大小 
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 设置默认关闭操作
      
      mSystem.add(mExit);                        // 添加"退出"菜单项到"系统"菜单
      
      mOperate.add(mAdd);                        // 添加"添加客户信息"菜单项到"操作"菜单
      mOperate.add(mAdd1);                       // 添加"添加员工信息"菜单项到"操作"菜单
      mOperate.add(mAdd2);						 // 添加"添加服务项目"菜单项到"操作"菜单
      mOperate.add(mAdd3);                       // 添加"添加业务安排"菜单项到"操作"菜单
      
      mOperate.add(mDel);                        // 添加"删除客户表单"菜单项到"操作"菜单
      mOperate.add(mDel1);                       // 添加"删除员工表单"菜单项到"操作"菜单
      mOperate.add(mDel2);                       // 添加"删除服务项目"菜单项到"操作"菜单
      mOperate.add(mDel3);                       // 添加"删除业务记录"菜单项到"操作"菜单
      
      mOperate.add(mModify);                     // 添加"修改客户信息"菜单项到"操作"菜单
      mOperate.add(mModify1);                    // 添加"修改员工信息"菜单项到"操作"菜单
      mOperate.add(mModify2);                    // 添加"修改服务项目"菜单项到"操作"菜单
      mOperate.add(mModify3);                    // 添加"修改业务安排"菜单项到"操作"菜单
      
      mOperate.add(mBrowse);                     // 添加"浏览客户信息"菜单项到"操作"菜单
      mOperate.add(mBrowse1);                    // 添加"浏览员工信息"菜单项到"操作"菜单
      mOperate.add(mBrowse2);                    // 添加"浏览服务项目"菜单项到"操作"菜单
      mOperate.add(mBrowse3);                    // 添加"浏览业务安排"菜单项到"操作"菜单
      
      mQuery.add(mCno);                          // 添加"按客户号查询客户信息"菜单项到"查询"菜单
      mQuery.add(mSno);                          // 添加"按员工号查询员工信息"菜单项到"查询"菜单
      
      mHelp.add(mAbout);                         // 添加"关于"菜单项到"帮助"菜单       
      
      mBar.add(mSystem);                         // 添加"系统"菜单到菜单栏
      mBar.add(mOperate);                        // 添加"操作"菜单到菜单栏
      mBar.add(mQuery);                          // 添加"查询"菜单到菜单栏
      mBar.add(mHelp);                           // 添加"帮助"菜单到菜单栏
      
      setJMenuBar(mBar);                         // 将菜单栏放入窗口
      
      mExit.addActionListener(this);             // 添加"退出"菜单项监听器
      
      mAdd.addActionListener(this);              // 添加"添加客户信息"菜单项监听器
      mAdd1.addActionListener(this);             // 添加"添加员工信息"菜单项监听器
      mAdd2.addActionListener(this);             // 添加"添加服务项目"菜单项监听器
      mAdd3.addActionListener(this);             // 添加"添加业务安排"菜单项监听器
      
      mDel.addActionListener(this);              // 添加"删除客户表单"菜单项监听器
      mDel1.addActionListener(this);             // 添加"删除员工表单"菜单项监听器
      mDel2.addActionListener(this);             // 添加"删除服务项目"菜单项监听器
      mDel3.addActionListener(this);             // 添加"删除业务记录"菜单项监听器
      
      mModify.addActionListener(this);           // 添加"修改客户信息"菜单项监听器
      mModify1.addActionListener(this);          // 添加"修改员工信息"菜单项监听器
      mModify2.addActionListener(this);          // 添加"修改服务项目"菜单项监听器
      mModify3.addActionListener(this);          // 添加"修改业务安排"菜单项监听器
      
      mBrowse.addActionListener(this);           // 添加"浏览客户信息"菜单项监听器
      mBrowse1.addActionListener(this);          // 添加"浏览员工信息"菜单项监听器
      mBrowse2.addActionListener(this);          // 添加"浏览服务项目"菜单项监听器
      mBrowse3.addActionListener(this);          // 添加"浏览业务安排"菜单项监听器
      
      mCno.addActionListener(this);              // 添加"按客户号查询客户信息"菜单项监听器
      mSno.addActionListener(this);              // 添加"按员工号查询员工信息"菜单项监听器
      
      mAbout.addActionListener(this);            // 添加"关于"菜单项监听器
      
      setContentPane(new MyPanel());             // 用setContentPane()方法设置JPanel容器为JFrame框架的内容面板
  
      setSize(640,460);                          // 设置大小 
      setLocation(350,150);                      // 设置位置
    
      setVisible(true);                          // 设置可见
  }
  
  public void actionPerformed(ActionEvent ae)    // 侦听器内部要编写actionPerformed方法
  {  
      if(ae.getSource()==mExit)                  // 用户点击"退出"
          System.exit(0);
      
      else if(ae.getSource()==mAbout)            // 用户点击"关于"
          JOptionPane.showMessageDialog          // 显示相关信息
          (this,"家政服务业务管理系统V1.0 \n\n河南工业大学\n\n14级物联网工程杨庆\n\n2017年1月9日","关于",JOptionPane.INFORMATION_MESSAGE);
     
      else if(ae.getSource()==mAdd)              // 用户点击"添加客户信息"菜单项
          new AddForm().setVisible(true);
      else if(ae.getSource()==mAdd1)             // 用户点击"添加员工信息"菜单项
          new AddForm1().setVisible(true);
      else if(ae.getSource()==mAdd2)             // 用户点击"添加服务项目"菜单项
          new AddForm2().setVisible(true);
      else if(ae.getSource()==mAdd3)             // 用户点击"添加业务信息"菜单项
          new AddForm3().setVisible(true);
     
      else if(ae.getSource()==mDel)              // 用户点击"删除客户信息"菜单项
          new DeleteForm().setVisible(true);
      else if(ae.getSource()==mDel1)             // 用户点击"删除员工信息"菜单项
          new DeleteForm1().setVisible(true);
      else if(ae.getSource()==mDel2)             // 用户点击"删除服务项目录"菜单项
          new DeleteForm2().setVisible(true);
      else if(ae.getSource()==mDel3)             // 用户点击"删除业务记录"菜单项
          new DeleteForm3().setVisible(true);
     
      else if(ae.getSource()==mModify)           // 用户点击"修改客户信息"菜单项
          new ModifyForm().setVisible(true);
      else if(ae.getSource()==mModify1)          // 用户点击"修改员工信息"菜单项
          new ModifyForm1().setVisible(true);
      else if(ae.getSource()==mModify2)          // 用户点击"修改服务项目"菜单项
          new ModifyForm2().setVisible(true);
      else if(ae.getSource()==mModify3)          // 用户点击"修改业务安排"菜单项
          new ModifyForm3().setVisible(true);
     
      else if(ae.getSource()==mBrowse)           // 用户点击"浏览客户信息"菜单项
          new BrowserForm().setVisible(true);
      else if(ae.getSource()==mBrowse1)          // 用户点击"浏览员工信息"菜单项
          new BrowserForm1().setVisible(true);
      else if(ae.getSource()==mBrowse2)          // 用户点击"浏览服务项目"菜单项
          new BrowserForm2().setVisible(true);
      else if(ae.getSource()==mBrowse3)          // 用户点击"浏览业务安排"菜单项
          new BrowserForm3().setVisible(true);
   
      else if(ae.getSource()==mCno)              // 用户点击"按客户号查询客户信息"菜单项
          new CnoQueryForm().setVisible(true);
      else if(ae.getSource()==mSno)              // 用户点击"按员工号查询员工信息"菜单项
          new SnoQueryForm().setVisible(true);
  }
  public static void main(String[] args) 
  {
      new MainForm();
  }
}

