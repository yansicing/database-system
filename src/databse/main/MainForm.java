package databse.main;

import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import databse.add.*;
import databse.brower.*;
import databse.delete.*;
import databse.modify.*;
import databse.query.*;

//ϵͳ������ģ������
class MainForm extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;
  
  JMenu mSystem  =new JMenu("ϵͳ");               // "ϵͳ"�˵�
  JMenuItem mExit=new JMenuItem("�˳�");           // "�˳�"�˵���
  
  JMenu mOperate    =new JMenu("����");            // "����"�˵�
  JMenuItem mAdd    =new JMenuItem("��ӿͻ���Ϣ");   // "���"�˵���
  JMenuItem mAdd1   =new JMenuItem("���Ա����Ϣ");
  JMenuItem mAdd2   =new JMenuItem("��ӷ�����Ŀ");
  JMenuItem mAdd3   =new JMenuItem("���ҵ����");
  
  JMenuItem mDel    =new JMenuItem("ɾ���ͻ���Ϣ");   // "ɾ��"�˵���
  JMenuItem mDel1   =new JMenuItem("ɾ��Ա����Ϣ");  
  JMenuItem mDel2   =new JMenuItem("ɾ��������Ŀ");   
  JMenuItem mDel3   =new JMenuItem("ɾ��ҵ����");   
  
  JMenuItem mModify =new JMenuItem("�޸Ŀͻ���Ϣ");   // "�޸�"�˵���
  JMenuItem mModify1=new JMenuItem("�޸�Ա����Ϣ");
  JMenuItem mModify2=new JMenuItem("�޸ķ�����Ŀ");
  JMenuItem mModify3=new JMenuItem("�޸�ҵ����");
  
  JMenuItem mBrowse =new JMenuItem("����ͻ���Ϣ");   // "���"�˵���
  JMenuItem mBrowse1=new JMenuItem("���Ա����Ϣ");
  JMenuItem mBrowse2=new JMenuItem("���������Ŀ");
  JMenuItem mBrowse3=new JMenuItem("���ҵ����");
  
  JMenu mQuery  =new JMenu("��ѯ");                // "��ѯ"�˵�
  JMenuItem mCno=new JMenuItem("���ͻ��Ų�ѯ�ͻ���Ϣ"); //  �Ӳ˵���
  JMenuItem mSno=new JMenuItem("��Ա���Ų�ѯԱ����Ϣ"); //  �Ӳ˵���
  
  JMenu mHelp     =new JMenu("����");             // "����"�˵�
  JMenuItem mAbout=new JMenuItem("����");         // "����"�˵���
  
  JMenuBar mBar   =new JMenuBar();               //  �˵���
  
  MainForm()                                     // ϵͳ������ģ�鹹�췽��
  {
      super("�����������ϵͳ by����");                 // ���ø���ĳ�ʼ��public����
      setSize(1500,730);                         // ���ô�С 
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ����Ĭ�Ϲرղ���
      
      mSystem.add(mExit);                        // ���"�˳�"�˵��"ϵͳ"�˵�
      
      mOperate.add(mAdd);                        // ���"��ӿͻ���Ϣ"�˵��"����"�˵�
      mOperate.add(mAdd1);                       // ���"���Ա����Ϣ"�˵��"����"�˵�
      mOperate.add(mAdd2);						 // ���"��ӷ�����Ŀ"�˵��"����"�˵�
      mOperate.add(mAdd3);                       // ���"���ҵ����"�˵��"����"�˵�
      
      mOperate.add(mDel);                        // ���"ɾ���ͻ���"�˵��"����"�˵�
      mOperate.add(mDel1);                       // ���"ɾ��Ա����"�˵��"����"�˵�
      mOperate.add(mDel2);                       // ���"ɾ��������Ŀ"�˵��"����"�˵�
      mOperate.add(mDel3);                       // ���"ɾ��ҵ���¼"�˵��"����"�˵�
      
      mOperate.add(mModify);                     // ���"�޸Ŀͻ���Ϣ"�˵��"����"�˵�
      mOperate.add(mModify1);                    // ���"�޸�Ա����Ϣ"�˵��"����"�˵�
      mOperate.add(mModify2);                    // ���"�޸ķ�����Ŀ"�˵��"����"�˵�
      mOperate.add(mModify3);                    // ���"�޸�ҵ����"�˵��"����"�˵�
      
      mOperate.add(mBrowse);                     // ���"����ͻ���Ϣ"�˵��"����"�˵�
      mOperate.add(mBrowse1);                    // ���"���Ա����Ϣ"�˵��"����"�˵�
      mOperate.add(mBrowse2);                    // ���"���������Ŀ"�˵��"����"�˵�
      mOperate.add(mBrowse3);                    // ���"���ҵ����"�˵��"����"�˵�
      
      mQuery.add(mCno);                          // ���"���ͻ��Ų�ѯ�ͻ���Ϣ"�˵��"��ѯ"�˵�
      mQuery.add(mSno);                          // ���"��Ա���Ų�ѯԱ����Ϣ"�˵��"��ѯ"�˵�
      
      mHelp.add(mAbout);                         // ���"����"�˵��"����"�˵�       
      
      mBar.add(mSystem);                         // ���"ϵͳ"�˵����˵���
      mBar.add(mOperate);                        // ���"����"�˵����˵���
      mBar.add(mQuery);                          // ���"��ѯ"�˵����˵���
      mBar.add(mHelp);                           // ���"����"�˵����˵���
      
      setJMenuBar(mBar);                         // ���˵������봰��
      
      mExit.addActionListener(this);             // ���"�˳�"�˵��������
      
      mAdd.addActionListener(this);              // ���"��ӿͻ���Ϣ"�˵��������
      mAdd1.addActionListener(this);             // ���"���Ա����Ϣ"�˵��������
      mAdd2.addActionListener(this);             // ���"��ӷ�����Ŀ"�˵��������
      mAdd3.addActionListener(this);             // ���"���ҵ����"�˵��������
      
      mDel.addActionListener(this);              // ���"ɾ���ͻ���"�˵��������
      mDel1.addActionListener(this);             // ���"ɾ��Ա����"�˵��������
      mDel2.addActionListener(this);             // ���"ɾ��������Ŀ"�˵��������
      mDel3.addActionListener(this);             // ���"ɾ��ҵ���¼"�˵��������
      
      mModify.addActionListener(this);           // ���"�޸Ŀͻ���Ϣ"�˵��������
      mModify1.addActionListener(this);          // ���"�޸�Ա����Ϣ"�˵��������
      mModify2.addActionListener(this);          // ���"�޸ķ�����Ŀ"�˵��������
      mModify3.addActionListener(this);          // ���"�޸�ҵ����"�˵��������
      
      mBrowse.addActionListener(this);           // ���"����ͻ���Ϣ"�˵��������
      mBrowse1.addActionListener(this);          // ���"���Ա����Ϣ"�˵��������
      mBrowse2.addActionListener(this);          // ���"���������Ŀ"�˵��������
      mBrowse3.addActionListener(this);          // ���"���ҵ����"�˵��������
      
      mCno.addActionListener(this);              // ���"���ͻ��Ų�ѯ�ͻ���Ϣ"�˵��������
      mSno.addActionListener(this);              // ���"��Ա���Ų�ѯԱ����Ϣ"�˵��������
      
      mAbout.addActionListener(this);            // ���"����"�˵��������
      
      setContentPane(new MyPanel());             // ��setContentPane()��������JPanel����ΪJFrame��ܵ��������
  
      setSize(640,460);                          // ���ô�С 
      setLocation(350,150);                      // ����λ��
    
      setVisible(true);                          // ���ÿɼ�
  }
  
  public void actionPerformed(ActionEvent ae)    // �������ڲ�Ҫ��дactionPerformed����
  {  
      if(ae.getSource()==mExit)                  // �û����"�˳�"
          System.exit(0);
      
      else if(ae.getSource()==mAbout)            // �û����"����"
          JOptionPane.showMessageDialog          // ��ʾ�����Ϣ
          (this,"��������ҵ�����ϵͳV1.0 \n\n���Ϲ�ҵ��ѧ\n\n14����������������\n\n2017��1��9��","����",JOptionPane.INFORMATION_MESSAGE);
     
      else if(ae.getSource()==mAdd)              // �û����"��ӿͻ���Ϣ"�˵���
          new AddForm().setVisible(true);
      else if(ae.getSource()==mAdd1)             // �û����"���Ա����Ϣ"�˵���
          new AddForm1().setVisible(true);
      else if(ae.getSource()==mAdd2)             // �û����"��ӷ�����Ŀ"�˵���
          new AddForm2().setVisible(true);
      else if(ae.getSource()==mAdd3)             // �û����"���ҵ����Ϣ"�˵���
          new AddForm3().setVisible(true);
     
      else if(ae.getSource()==mDel)              // �û����"ɾ���ͻ���Ϣ"�˵���
          new DeleteForm().setVisible(true);
      else if(ae.getSource()==mDel1)             // �û����"ɾ��Ա����Ϣ"�˵���
          new DeleteForm1().setVisible(true);
      else if(ae.getSource()==mDel2)             // �û����"ɾ��������Ŀ¼"�˵���
          new DeleteForm2().setVisible(true);
      else if(ae.getSource()==mDel3)             // �û����"ɾ��ҵ���¼"�˵���
          new DeleteForm3().setVisible(true);
     
      else if(ae.getSource()==mModify)           // �û����"�޸Ŀͻ���Ϣ"�˵���
          new ModifyForm().setVisible(true);
      else if(ae.getSource()==mModify1)          // �û����"�޸�Ա����Ϣ"�˵���
          new ModifyForm1().setVisible(true);
      else if(ae.getSource()==mModify2)          // �û����"�޸ķ�����Ŀ"�˵���
          new ModifyForm2().setVisible(true);
      else if(ae.getSource()==mModify3)          // �û����"�޸�ҵ����"�˵���
          new ModifyForm3().setVisible(true);
     
      else if(ae.getSource()==mBrowse)           // �û����"����ͻ���Ϣ"�˵���
          new BrowserForm().setVisible(true);
      else if(ae.getSource()==mBrowse1)          // �û����"���Ա����Ϣ"�˵���
          new BrowserForm1().setVisible(true);
      else if(ae.getSource()==mBrowse2)          // �û����"���������Ŀ"�˵���
          new BrowserForm2().setVisible(true);
      else if(ae.getSource()==mBrowse3)          // �û����"���ҵ����"�˵���
          new BrowserForm3().setVisible(true);
   
      else if(ae.getSource()==mCno)              // �û����"���ͻ��Ų�ѯ�ͻ���Ϣ"�˵���
          new CnoQueryForm().setVisible(true);
      else if(ae.getSource()==mSno)              // �û����"��Ա���Ų�ѯԱ����Ϣ"�˵���
          new SnoQueryForm().setVisible(true);
  }
  public static void main(String[] args) 
  {
      new MainForm();
  }
}

