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

public class Number256 extends JPanel {
	private Coordinates coordinate;
	private JLabel numberLabel;
	public Number256(){
		this.setLayout(new BorderLayout());
		numberLabel = new JLabel();
		numberLabel.setFont(new Font("Arial",Font.BOLD,55));//����������ʽ
		//����������ɫ,����ı�����Ϊ"4"����,����ʾ��ɫ
		numberLabel.setForeground(Color.WHITE);							
		//��������ˮƽ����
		numberLabel.setHorizontalAlignment(JLabel.CENTER);		
		//���ñ�ǩ����Ϊ2
		numberLabel.setText("256");
		//���ñ�ǩ����������
		this.add(numberLabel,BorderLayout.CENTER);
		//��������������ɫ
		this.setBackground(new Color(187,173,160));
	}
	public Number256(Coordinates coordinate){
		//��������
		this.coordinate = coordinate;
		//������������ΪBorderLayout
		this.setLayout(new BorderLayout());
		numberLabel = new JLabel();
		numberLabel.setFont(new Font("Arial",Font.BOLD,55));//����������ʽ
		//����������ɫ,����ı�����Ϊ"4"����,����ʾ��ɫ
		numberLabel.setForeground(Color.WHITE);							
		//��������ˮƽ����
		numberLabel.setHorizontalAlignment(JLabel.CENTER);		
		//���ñ�ǩ����Ϊ2
		numberLabel.setText("256");
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
			 bgImg = ImageIO.read(new File("TwoZeroFourEight/src/image/256.png"));
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		 arg0.drawImage(bgImg, -25, -25,
					null);
	}
	 
  
}
