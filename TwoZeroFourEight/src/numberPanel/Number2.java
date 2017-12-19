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
		numberLabel.setFont(new Font("Arial",Font.BOLD,60));//����������ʽ
		//����������ɫ
		numberLabel.setForeground(Color.black);							
		//��������ˮƽ����
		numberLabel.setHorizontalAlignment(JLabel.CENTER);		
		//���ñ�ǩ����Ϊ2
		numberLabel.setText("2");
		//���ñ�ǩ����������
		this.add(numberLabel,BorderLayout.CENTER);
		//��������������ɫ
		this.setBackground(new Color(187,173,160));
	}
	public Number2(Coordinates coordinate){
		//��������
		this.coordinate = coordinate;
		//������������ΪBorderLayout
		this.setLayout(new BorderLayout());
		numberLabel = new JLabel();
		numberLabel.setFont(new Font("Arial",Font.BOLD,60));//����������ʽ
		//����������ɫ
		numberLabel.setForeground(Color.black);							
		//��������ˮƽ����
		numberLabel.setHorizontalAlignment(JLabel.CENTER);		
		//���ñ�ǩ����Ϊ2
		numberLabel.setText("2");
		//���ñ�ǩ����������
		this.add(numberLabel,BorderLayout.CENTER);
		//��������������ɫ
		this.setBackground(new Color(187,173,160));
		
//		this.setOpaque(false);
	}
	//����ͼƬ
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
