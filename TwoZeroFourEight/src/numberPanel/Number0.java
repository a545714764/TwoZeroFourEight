package numberPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Coordinates;

public class Number0 extends JPanel {
	private Coordinates coordinate;
	private JLabel numberLabel;
	public Number0(Coordinates coordinate){
//		this.setSize(150,150);
		//设置坐标
		this.coordinate = coordinate;
		//设置容器布局为BorderLayout
		this.setLayout(new BorderLayout());
		numberLabel = new JLabel();
		numberLabel.setFont(new Font("Arial",Font.BOLD,60));//设置字体样式
		//设置字体颜色,"4"以下(不包括4)字体颜色显示为黑色
		numberLabel.setForeground(Color.BLACK);							
		//设置字体水平居中
		numberLabel.setHorizontalAlignment(JLabel.CENTER);		
		//设置标签内容为2
//		numberLabel.setText("0");
		//设置标签在容器中心
		this.add(numberLabel,BorderLayout.CENTER);
		//设置容器背景颜色
		this.setBackground(new Color(187,173,160));
//		this.setBackground(Color.white);
	}
	//加载图片
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Image bgImg = null;
		 try {
			 bgImg = ImageIO.read(new File("src/image/0.png"));
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		 arg0.drawImage(bgImg, -25, -25,
					null);
	}
	 
  
}
