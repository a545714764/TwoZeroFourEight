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

import game.Coordinates;

public class Number2 extends JPanel {
	private Coordinates coordinate;
	private JLabel numberLabel;
	public Number2(){
		this.setLayout(new BorderLayout());
		numberLabel = new JLabel();
		numberLabel.setFont(new Font("Arial",Font.BOLD,60));//设置字体样式
		//设置字体颜色
		numberLabel.setForeground(Color.black);							
		//设置字体水平居中
		numberLabel.setHorizontalAlignment(JLabel.CENTER);		
		//设置标签内容为2
		numberLabel.setText("2");
		//设置标签在容器中心
		this.add(numberLabel,BorderLayout.CENTER);
		//设置容器背景颜色
		this.setBackground(new Color(187,173,160));
	}
	public Number2(Coordinates coordinate){
		//设置坐标
		this.coordinate = coordinate;
		//设置容器布局为BorderLayout
		this.setLayout(new BorderLayout());
		numberLabel = new JLabel();
		numberLabel.setFont(new Font("Arial",Font.BOLD,60));//设置字体样式
		//设置字体颜色
		numberLabel.setForeground(Color.black);							
		//设置字体水平居中
		numberLabel.setHorizontalAlignment(JLabel.CENTER);		
		//设置标签内容为2
		numberLabel.setText("2");
		//设置标签在容器中心
		this.add(numberLabel,BorderLayout.CENTER);
		//设置容器背景颜色
		this.setBackground(new Color(187,173,160));
		
//		this.setOpaque(false);
	}
	//加载图片
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Image bgImg = null;
		 try {
			 bgImg = ImageIO.read(new File("TwoZeroFourEight/src/image/2.png"));
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		 arg0.drawImage(bgImg, -25, -25,
					null);
	}
//	 
	public Coordinates getCoordinates(){
		return this.coordinate;
	}
  
}
