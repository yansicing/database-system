package databse.main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

 public class MyPanel extends JPanel
 {
	private static final long serialVersionUID = 1L; 
	
    Image img=Toolkit.getDefaultToolkit().getImage("d:/a.jpg");// ��ȡͼƬ
    
    public void paint(Graphics g)  // ��ͼ
    {
     // g.drawImage(img,0,0,this); // ���Ŵ��ڸı䣬ͼƬ��С�̶�����,Ҫ��ʵ��ͼƬ�洰�ڴ�С�ı䣬ֻ��Ҫ���´���
    	g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
    }
}

