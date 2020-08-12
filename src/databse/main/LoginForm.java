package databse.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
                                                  // LoginForm �̳��� JFrame ʵ��ActionListener�ӿ�
public class LoginForm extends JFrame implements ActionListener // ��½���� 
{   
	private static final long serialVersionUID = 1L;

	JLabel labName=new JLabel("����");             // ������ǩ
    JLabel labPwd =new JLabel("����");             // �����ǩ
    JLabel labName1=new JLabel("��������ҵ�����ϵͳ"); // ϵͳ��ǩ
    
    JTextField    txtName=new JTextField(10);    // �����ı���
    JPasswordField txtPwd=new JPasswordField(10);// �����ı���
    
    JButton btnOk    =new JButton("��¼");        // ��½��ť
    JButton btnCancel=new JButton("ȡ��");        // ȡ����ť
    
    JPanel pan =new JPanel();                    // �½���壬��ť���ı���ȶ����Է������������
    JPanel pan1=new JPanel();                    // JPanel��屾���ǲ�����Ϊ���ڽ�����ʾ������������JFrame�����Ƚ�����ʾ��
    JPanel pan2=new JPanel();
    JPanel pan3=new JPanel();
    JPanel pan4=new JPanel();
    JPanel pan5=new JPanel();
    
    Connection cnn;                             // ���ݿ����Ӷ���
    Statement  stm;                             // ���ݿ��������
    ResultSet  rs;                              // ���ݿ�����
    
    LoginForm()                                 // ���췽����ɳ�ʼ��
    {
        super("��������ҵ�����ϵͳ");                 // ���ø���ĳ�ʼ��public����
        
        setSize(300,200);                       // ���ô�С 
        setLocation(500,250);                   // ����λ��
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ����Ĭ�Ϲرղ���
        
        pan.setBorder(BorderFactory.createTitledBorder("�û���¼")); // �û���¼�߽����
        pan.setLayout(new GridLayout(2,1));     // ����һ�е����񲼾�
        
        pan1.add(labName);                      // ���������ǩ
        pan1.add(txtName);                      // ��������ı���
        
        pan2.add(labPwd);                       // ��������ǩ
        pan2.add(txtPwd);                       // ��������ı���
         
        pan.add(pan1);                          // pan1��ӵ�pan������
        pan.add(pan2);                          // pan2��ӵ�pan������
        
        pan3.add(btnOk);                        // ��ӵ�½��ť
        pan3.add(btnCancel);                    // ���ȡ����ť
        
        pan4.add(pan);                          // ���pan��pan4
        
        pan5.add(labName1);                     // ���ϵͳ��ǩ��pan5
        
        getContentPane().add(pan5,"North");     // ���pan5�ڱ���
        getContentPane().add(pan4,"Center");    // ���pan4���м�
        getContentPane().add(pan3,"South");     // ���pan3���ϱ�
        
        txtName.addActionListener(this);        // ��������ı��������
        txtPwd.addActionListener(this);         // ��������ı��������
        
        btnOk.addActionListener(this);          // ��ӵ�½��ť������
        btnCancel.addActionListener(this);      // ���ȡ����ť������
        
        setVisible(true);                       // ����Ϊ�ɼ�
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // װ����������������и����ַ����������ӿ�������� Class���� 
        } 
        catch (ClassNotFoundException ex)   // û���ҵ�����ָ�����Ƶ���Ķ���
        {                                   // ex�Ǵ˶����������ƣ�Ȼ��ex���Զ�����Exception����ָ���ķ���
            ex.printStackTrace();           // ��ӡ�쳣��ջ��Ϣ������̨�����������д�ӡ�쳣��Ϣ�ڳ����г����λ�ü�ԭ��
        }
        
        try 
        {                                   // ���������ݿ�����ӣ�DriverManager ����һ�� JDBC��������Ļ�������
            cnn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=database","sd","123");
            stm=cnn.createStatement();      // ����һ�� Statement�������� SQL��䷢�͵����ݿ�
        }                                   // Statement����ִ�о�̬ SQL��䲢�����������ɽ���Ķ���
        catch (SQLException ex)             // SQL���ݿ��쳣����
        {
            ex.printStackTrace();           // ��ӡ�쳣��Ϣ�ڳ����г����λ�ü�ԭ��
        }
        
        txtName.requestFocus();             // �ѽ��������������ťtxtName�ϣ�����л��������ı���
    }
    
        public void actionPerformed(ActionEvent ae) // �������ڲ�Ҫ��дactionPerformed����
        {                                           // ��д�ӿ�ActionListener���涨���һ�����󷽷�����������������塱���¼�ʱ������������
            if(ae.getSource()==txtName)             // ���û��������������س�
                txtPwd.requestFocus();              // �����ʾ�������ı���
            
            else if(ae.getSource()==txtPwd)         // ���û�������������س�
                btnOk.requestFocus();               // ������ʾ�ڵ�½�ı���
            
            else if(ae.getSource()==btnCancel)      // ���û����ȡ��ʱ
            {
                txtName.setText("");                // �����ı����������
                txtPwd.setText("");                 // �����ı����������
                txtName.requestFocus();             // �����ʾ�������ı���
                
            }
            else if(ae.getSource()==btnOk)          // ���û������½ʱ
            {                                       // ��admin���ű��У���ѯ���û�����txtName��������txtPwd���û����������ֵ�Ƕ�̬��õġ�          	
                String str="select * from admin where Username='"+txtName.getText()+"'and Password='"+new String(txtPwd.getPassword())+"'";
                try 
                {
                    rs=stm.executeQuery(str);       // rs����ResultSet���� ��executeQuery()��java�����Դ���ִ�в�ѯ�ķ���
                } 
                catch (SQLException ex)             // SQL���ݿ��쳣����
                {
                    ex.printStackTrace();           // ��ӡ�쳣��Ϣ�ڳ����г����λ�ü�ԭ��
                }
                try 
                {
                    if(rs.next())    // ��һ��ʹ��next()�ͽ�ָ��ָ�򷵻ؽ�����ĵ�һ�С�ÿʹ��һ��next()��ָ���ָ����һ��
                    {                // ��������Ϊ "Message" ����Ϣ��Ϣ�Ի�����ʾ"��֤ͨ��!"
                        JOptionPane.showMessageDialog(this,"��֤ͨ��!","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
                        
                        rs.close();  // �ص����ݿ�           
                        stm.close(); // �ص�ִ�����
                        cnn.close(); // �ر����ӣ��ͷ���Դ
                        
                        new MainForm().setVisible(true); // ���ô��ڿɼ�
                        this.dispose();                  // ��������֮��Źرմ��塣
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"�û��������벻��ȷ! ����������","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
                    }
                } 
                catch (SQLException ex)                // SQL���ݿ��쳣����
                {
                    ex.printStackTrace();              // ��ӡ�쳣��Ϣ�ڳ����г����λ�ü�ԭ��
                }
            }
        }
        
        public static void main(String[] args)         // ������
        {
            new LoginForm();                           // ��½����
        }
}
