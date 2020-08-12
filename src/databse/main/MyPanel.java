package databse.main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

 public class MyPanel extends JPanel
 {
	private static final long serialVersionUID = 1L; 
	
    Image img=Toolkit.getDefaultToolkit().getImage("d:/a.jpg");// 获取图片
    
    public void paint(Graphics g)  // 画图
    {
     // g.drawImage(img,0,0,this); // 随着窗口改变，图片大小固定不变,要想实现图片随窗口大小改变，只需要以下代码
    	g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
    }
}

