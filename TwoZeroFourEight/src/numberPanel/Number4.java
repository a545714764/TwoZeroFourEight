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

public class Number4 extends JPanel {
	private Coordinates coordinate;
	private JLabel numberLabel;
	public Number4(){
		this.setLayout(new BorderLayout());
		numberLabel = new JLabel();
		numberLabel.setFont(new Font("Arial",Font.BOLD,60));//����������ʽ
		//����������ɫ,����ı�����Ϊ"4"����,����ʾ��ɫ
		numberLabel.setForeground(Color.BLACK);							
		//��������ˮƽ����
		numberLabel.setHorizontalAlignment(JLabel.CENTER);		
		//���ñ�ǩ����Ϊ2
		numberLabel.setText("4");
		//���ñ�ǩ����������
		this.add(numberLabel,BorderLayout.CENTER);
		//��������������ɫ
		this.setBackground(new Color(187,173,160));
	}
	public Number4(Coordinates coordinate){
		//��������
		this.coordinate = coordinate;
		//������������ΪBorderLayout
		this.setLayout(new BorderLayout());
		numberLabel = new JLabel();
		numberLabel.setFont(new Font("Arial",Font.BOLD,60));//����������ʽ
		//����������ɫ,����ı�����Ϊ"4"����,����ʾ��ɫ
		numberLabel.setForeground(Color.BLACK);							
		//��������ˮƽ����
		numberLabel.setHorizontalAlignment(JLabel.CENTER);		
		//���ñ�ǩ����Ϊ2
		numberLabel.setText("4");
		//���ñ�ǩ����������
		this.add(numberLabel,BorderLayout.CENTER);
		//��������������ɫ
		this.setBackground(new Color(187,173,160));
	}
	//����ͼƬ
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Image bgImg = null;
		 try {
			 bgImg = ImageIO.read(new File("TwoZeroFourEight/src/image/4.png"));
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		 arg0.drawImage(bgImg, -25, -25,
					null);
	}
	 
  
}
