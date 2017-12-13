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
		//��������
		this.coordinate = coordinate;
		//������������ΪBorderLayout
		this.setLayout(new BorderLayout());
		numberLabel = new JLabel();
		numberLabel.setFont(new Font("Arial",Font.BOLD,60));//����������ʽ
		//����������ɫ,"4"����(������4)������ɫ��ʾΪ��ɫ
		numberLabel.setForeground(Color.BLACK);							
		//��������ˮƽ����
		numberLabel.setHorizontalAlignment(JLabel.CENTER);		
		//���ñ�ǩ����Ϊ2
//		numberLabel.setText("0");
		//���ñ�ǩ����������
		this.add(numberLabel,BorderLayout.CENTER);
		//��������������ɫ
		this.setBackground(new Color(187,173,160));
//		this.setBackground(Color.white);
	}
	//����ͼƬ
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
